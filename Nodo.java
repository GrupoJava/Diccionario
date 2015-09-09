public class Nodo<E>{
	private Nodo<E> hijoDerecho;
	private Nodo<E> hijoIzquierdo;
	private Association< String, String> Palabras;
	
	public Nodo(Nodo hijoDerecho, Nodo hijoIzquierdo, String palabraInglesa,
			String palabraEspanola) {
		super();
		this.hijoDerecho = hijoDerecho;
		this.hijoIzquierdo = hijoIzquierdo;
		this.Palabras = new Association<String,String>(palabraInglesa,palabraEspanola);
	}
	public Nodo<E> getHijoDerecho() {
		return hijoDerecho;
	}
	public void setHijoDerecho(Nodo hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
	public Nodo<E> getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	public void setHijoIzquierdo(Nodo hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	public String getPalabraInglesa() {
		return Palabras.getKey();
	}
	public void setPalabraInglesa(String palabraInglesa) {
		Palabras.setKey(palabraInglesa);
	}
	public String getPalabraEspanola() {
		return Palabras.getValue();
	}
	public void setPalabraEspanola(String palabraEspanola) {
		Palabras.setValue(palabraEspanola);
	}
	
}