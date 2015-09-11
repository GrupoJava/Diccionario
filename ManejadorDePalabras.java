/**
 * @author Rudy Garrido
 * @author Andre Rodas
 * @author Delbert Custodio
 * 
 * Clase basada en el capitulo 14 del libro de Texto, sirve para guardar en memoria
 * las palabras del archivo de texto y traducir 
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManejadorDePalabras{
	private Tree<String> arbol= new Tree();
	
	
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
			    arbol.add(arbol.getRoot(), palabras[0], palabras[1]);
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
			    	arbol.search(arbol.getRoot(), palabra);
			    	if(((String) arbol.getTraduccion()).equalsIgnoreCase("")){
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
	public Tree<String> getArbol() {
		return arbol;
	}
	public void setTree(Tree arbol) {
		this.arbol = arbol;
	}
	
}