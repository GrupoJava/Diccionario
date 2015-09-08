public class Arbol{
	private Nodo root;
	private String traduccion="";
	
	
	public void agregarNodo(Nodo raiz, String palabraInglesa, String palabraEspanola){
		if(root!=null){
			if(raiz==null)return;
			if(raiz.getPalabraInglesa().compareTo(palabraInglesa)>0){
				//Agregando a la izquierda
				if(raiz.getHijoIzquierdo()==null){
					System.out.println("Agregando "+palabraInglesa+ " a la izquierda de "+raiz.getPalabraInglesa());
					raiz.setHijoIzquierdo(new Nodo(null, null, palabraInglesa, palabraEspanola));
				}else{
					agregarNodo(raiz.getHijoIzquierdo(), palabraInglesa, palabraEspanola);
				}
			}else{
				//Agregando a la derecha
				if(raiz.getHijoDerecho()==null){
					System.out.println("Agregando "+palabraInglesa +" a la derecha de "+raiz.getPalabraInglesa());
					raiz.setHijoDerecho(new Nodo(null, null,palabraInglesa, palabraEspanola));
				}else{
					agregarNodo(raiz.getHijoDerecho(), palabraInglesa, palabraEspanola);
				}
			}
		}else{
			System.out.println("Agregando RAIZ "+palabraInglesa+", "+palabraEspanola);
			root= new Nodo(null,null, palabraInglesa, palabraEspanola);
			}
		}
	/*public void agregarNodo(Nodo raiz, String palabraInglesa, String palabraEspanola){
		if(bandera){	
			if(root!=null){
				if(raiz ==null) return;
				if(raiz.getHijoIzquierdo() == null && raiz.getHijoDerecho()==null){
					System.out.println("Agregando izquierdo "+palabraInglesa+", "+palabraEspanola);
					raiz.setHijoIzquierdo(new Nodo(null, null,palabraInglesa, palabraEspanola));
					raiz=null;
					bandera =false;
					return;
				} 
				if(raiz.getHijoDerecho()==null && raiz.getHijoIzquierdo()!=null){
					System.out.println("Agregando derecho "+palabraInglesa+", "+palabraEspanola);
					raiz.setHijoDerecho(new Nodo(null, null,palabraInglesa, palabraEspanola));
					raiz=null;
					bandera =false;
					return;
				}
				agregarNodo(raiz.getHijoIzquierdo(), palabraInglesa, palabraEspanola);
				System.out.println("HACIENDO CAMBIO");
				agregarNodo(raiz.getHijoDerecho(), palabraInglesa, palabraEspanola);
			}else{
				System.out.println("Agregando RAIZ "+palabraInglesa+", "+palabraEspanola);
				root= new Nodo(null,null, palabraInglesa, palabraEspanola);
			}
		}
	}*/
	public void recorrerArbol(Nodo raiz){
		if(raiz ==null) return;
		recorrerArbol(raiz.getHijoIzquierdo());
		System.out.println(raiz.getPalabraInglesa());
		recorrerArbol(raiz.getHijoDerecho());
	}
	
	public void buscarPalabra(Nodo raiz, String palabraInglesa){
		if(raiz == null) return;
		buscarPalabra(raiz.getHijoIzquierdo(), palabraInglesa);
		if(raiz.getPalabraInglesa().equalsIgnoreCase(palabraInglesa)) traduccion=traduccion+raiz.getPalabraEspanola()+ " ";//return raiz.getPalabraEspanola();
		buscarPalabra(raiz.getHijoDerecho(), palabraInglesa);
		traduccion= traduccion+"*"+palabraInglesa+"* ";
	}

	public Nodo getRoot() {
		return root;
	}

	public void setRoot(Nodo root) {
		this.root = root;
	}
	public String getTraduccion() {
		return traduccion;
	}
	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

}