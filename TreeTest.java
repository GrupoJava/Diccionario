import static org.junit.Assert.*;

import org.junit.Test;


public class TreeTest {
	
	@Test
	public void testAdd() {
		Tree<String> arbol= new Tree<String>();
		arbol.add(arbol.getRoot(), "Hello", "Hola");
		Nodo<?> a = arbol.getRoot();
		String b = a.getPalabraEspanola();
		String c = a.getPalabraInglesa();
		b.equals("Hola");
		c.equals("Hello");
	}

	@Test
	public void testSearch() {
		Tree<String> arbol= new Tree<String>();
		arbol.add(arbol.getRoot(), "Hello", "Hola");
		String palabra="Hello";
		arbol.setTraduccion("");
    	arbol.search(arbol.getRoot(), palabra);
    	if(((String) arbol.getTraduccion()).equalsIgnoreCase(""))
    		assertEquals(0,10,0); //Desigualdad si no se cumple
    	else
    		assertEquals(0,0,0);
	}

}
