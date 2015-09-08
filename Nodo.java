public class Nodo{
	private Nodo hijoDerecho;
	private Nodo hijoIzquierdo;
	private String palabraInglesa;
	private String palabraEspanola;
	public Nodo(Nodo hijoDerecho, Nodo hijoIzquierdo, String palabraInglesa,
			String palabraEspanola) {
		super();
		this.hijoDerecho = hijoDerecho;
		this.hijoIzquierdo = hijoIzquierdo;
		this.palabraInglesa = palabraInglesa;
		this.palabraEspanola = palabraEspanola;
	}
	public Nodo getHijoDerecho() {
		return hijoDerecho;
	}
	public void setHijoDerecho(Nodo hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}
	public Nodo getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	public void setHijoIzquierdo(Nodo hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	public String getPalabraInglesa() {
		return palabraInglesa;
	}
	public void setPalabraInglesa(String palabraInglesa) {
		this.palabraInglesa = palabraInglesa;
	}
	public String getPalabraEspanola() {
		return palabraEspanola;
	}
	public void setPalabraEspanola(String palabraEspanola) {
		this.palabraEspanola = palabraEspanola;
	}
	
}