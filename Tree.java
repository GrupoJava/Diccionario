/**
 * @author Rudy Garrido
 * @author Andre Rodas
 * @author Delbert Custodio
 * 
 * Clase basada en el capitulo 14 del libro de Texto, sirve para relacionar 
 * agregar elementos mediante nodos de 2do grado
 *
 * @param <E> elemento generico
 */

public class Tree<E>{
	
	//Fuente del libro Java Structures
	
	private Nodo root;
	private String traduccion="";
	private String diccionario="";
	
	public void add(Nodo raiz, String palabraInglesa, String palabraEspanola){
		if(root!=null){
			if(raiz==null)return;
			if(raiz.getPalabraInglesa().compareTo(palabraInglesa)>0){
				//Agregando a la izquierda
				if(raiz.getHijoIzquierdo()==null){
					System.out.println("Agregando "+palabraInglesa+ " a la izquierda de "+raiz.getPalabraInglesa());
					raiz.setHijoIzquierdo(new Nodo(null, null, palabraInglesa, palabraEspanola));
				}else{
					add(raiz.getHijoIzquierdo(), palabraInglesa, palabraEspanola);
				}
			}else{
				//Agregando a la derecha
				if(raiz.getHijoDerecho()==null){
					System.out.println("Agregando "+palabraInglesa +" a la derecha de "+raiz.getPalabraInglesa());
					raiz.setHijoDerecho(new Nodo(null, null,palabraInglesa, palabraEspanola));
				}else{
					add(raiz.getHijoDerecho(), palabraInglesa, palabraEspanola);
				}
			}
		}else{
			System.out.println("Agregando RAIZ "+palabraInglesa+", "+palabraEspanola);
			root= new Nodo(null,null, palabraInglesa, palabraEspanola);
			}
		}
	public void get(Nodo raiz){
		if(raiz ==null) return;
		get(raiz.getHijoIzquierdo());
		diccionario=diccionario+"("+raiz.getPalabraInglesa()+", "+raiz.getPalabraEspanola()+")"+"\n";
		get(raiz.getHijoDerecho());
	}
	
	public void search(Nodo raiz, String palabraInglesa){
		if(raiz == null) return;
		search(raiz.getHijoIzquierdo(), palabraInglesa);
		if(raiz.getPalabraInglesa().equalsIgnoreCase(palabraInglesa)) traduccion=raiz.getPalabraEspanola()+ " ";//return raiz.getPalabraEspanola();
		search(raiz.getHijoDerecho(), palabraInglesa);
	}

	public Nodo getRoot() {
		return root;
	}

	public void setRoot(Nodo root) {
		this.root = root;
	}
	public E getTraduccion() {
		return (E) traduccion;
	}
	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}
	public E getDiccionario() {
		return (E) diccionario;
	}
	public void setDiccionario(String diccionario) {
		this.diccionario = diccionario;
	}

}