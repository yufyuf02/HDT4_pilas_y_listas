import org.junit.Test;
import static org.junit.Assert.*;
import listas.*;

public class ListaTests {

    @Test
    public void testListaSimple() {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.add(1);
        lista.add(2);
        assertEquals(2, (int) lista.removeLast());
        assertEquals(1, (int) lista.removeLast());
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaDoble() {
        ListaDoble<String> lista = new ListaDoble<>();
        lista.add("A");
        lista.add("B");
        assertEquals("B", lista.removeLast());
        assertEquals("A", lista.removeLast());
        assertTrue(lista.isEmpty());
    }
}