public class Arbol{
	private Nodo root;
	
	
	public void agregarNodo(Nodo raiz, String palabraInglesa, String palabraEspanola){
		if(root!=null){
			if(raiz == null){
				raiz= new Nodo(null, null,palabraInglesa, palabraEspanola);
				return;
			}
			agregarNodo(raiz.getHijoDerecho(), palabraInglesa, palabraEspanola);
			agregarNodo(raiz.getHijoIzquierdo(), palabraInglesa, palabraEspanola);
		}else{
			root= new Nodo(null,null, palabraInglesa, palabraEspanola);
		}
	}
	
	public String buscarPalabra(Nodo raiz, String palabraInglesa){
		if(raiz == null) return null;
		buscarPalabra(raiz.getHijoDerecho(), palabraInglesa);
		if(raiz.getPalabraInglesa().equalsIgnoreCase(palabraInglesa)) return raiz.getPalabraEspanola();
		buscarPalabra(raiz.getHijoIzquierdo(), palabraInglesa);
		return null;
	}

	public Nodo getRoot() {
		return root;
	}

	public void setRoot(Nodo root) {
		this.root = root;
	}
}