import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManejadorDePalabras{
	private Arbol arbol= new Arbol();
	
	
	public void leerDiccionario(String file) throws FileNotFoundException{
		File archivo = new File(file);
		String palabra = "";
		String[] palabras;
		BufferedReader br = new BufferedReader(new FileReader(file));
	    String line = null;
        try {
			while ((line = br.readLine()) != null) {
			    palabra = line.toString().replace("(", "").replace(",", "").replace(")", "");
			    palabras=palabra.split(" ");
			    arbol.agregarNodo(arbol.getRoot(), palabras[0], palabras[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String traducir(String file) throws FileNotFoundException{
		File archivo = new File(file);
		String[] palabras;
		String traduccion = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
	    String line = null;
        try {
			while ((line = br.readLine()) != null) {
			    palabras=line.toString().replace(".", "").split(" ");
			    for(String palabra: palabras){
			    	arbol.setTraduccion("");
			    	arbol.buscarPalabra(arbol.getRoot(), palabra);
			    	if(arbol.getTraduccion().equalsIgnoreCase("")){
			    		traduccion=traduccion+"*"+palabra+"* ";
			    	}else{
			    		traduccion=traduccion+ arbol.getTraduccion()+" ";
			    	}
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return traduccion;
	}
	public Arbol getArbol() {
		return arbol;
	}
	public void setArbol(Arbol arbol) {
		this.arbol = arbol;
	}
	
}