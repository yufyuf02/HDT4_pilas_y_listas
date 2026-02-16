import org.junit.Test;
import static org.junit.Assert.*;
import Pilas.*;

public class PilaTests {

    @Test
    public void testPilaArrayList() {
        PilaArrayList<Integer> pila = new PilaArrayList<>();
        pila.push(1);
        pila.push(2);
        assertEquals(2, (int) pila.pop());
        assertEquals(1, (int) pila.peek());
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testPilaLista() {
        PilaLista<String> pila = new PilaLista<>();
        pila.push("A");
        pila.push("B");
        assertEquals("B", pila.pop());
        assertEquals("A", pila.peek());
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testPilaVector() {
        PilaVector<Double> pila = new PilaVector<>();
        pila.push(1.1);
        pila.push(2.2);
        assertEquals(2.2, pila.pop(), 0.001);
        assertEquals(1.1, pila.peek(), 0.001);
        assertFalse(pila.isEmpty());
    }
}