package listas;

public class ListaSimple<T> implements ILista<T> {
    private NodoSimple<T> cabeza;
    private NodoSimple<T> cola;
    private int size;

    // Constructor
    public ListaSimple() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    @Override
    public void add(T element) {   
        NodoSimple<T> nuevo = new NodoSimple<T>(element, null);

        if (isEmpty()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        size++;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T dato = cola.data;

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            NodoSimple<T> actual = cabeza;

            while (actual.siguiente != cola) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
            cola = actual;
        }
        size--;
        return dato;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return cola.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

}
