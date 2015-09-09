


/**
 * @author Rudy Garrido
 * @author Andre Rodas
 * @author Delbert Custodio
 * 
 * Clase basada en el capitulo 4 del libro de Texto, sirve para relacionar 
 * la palabra en ingles con su traduccion en castellano
 *
 * @param <K> palabra en ingles
 * @param <V> palabra en castellano
 */
public class Association<K,V>{
	
	
	protected K theKey;
	protected V theValue;
	
	/**
	 * @param key palabra en ingles
	 * @param value palabra en castellano
	 * 
	 */
	public Association( K key, V value){
		
		theKey = key;
		theValue = value;
		
	}
	
	
	/**
	 * @return el valor de la palabra en castellano
	 */
	public V getValue(){
		return theValue;
	}
	
	/**
	 * @return el valor de la palabra en ingles
	 */
	public K getKey(){
		return theKey;
	}
	
	/**
	 * @param val, palabra en castellano
	 * @return el valor que se reemplazo
	 */
	public V setValue(V val){
		V oldValue = theValue;
		theValue = val;
		return oldValue;
	}
	
	/**
	 * @param val, valor de la palabra en ingles
	 * @return el valor de la palabra que se reemplazo
	 */
	public K setKey(K val){
		K oldKey = theKey;
		theKey = val;
		return oldKey;
	}
	
	
}