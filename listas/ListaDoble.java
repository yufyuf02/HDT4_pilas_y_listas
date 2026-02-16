package listas;

public class ListaDoble<T> implements ILista<T>{
        private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int size;

    // Constructor
    public ListaDoble() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    @Override
    public void add(T element) {   
        NodoDoble<T> nuevo = new NodoDoble<>(element, null, cola);

        if (isEmpty()) {
            cabeza = nuevo;
        } else {
            cola.siguiente = nuevo;
        }
        cola = nuevo;
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
            cola = cola.anterior;
            cola.siguiente = null;
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

    @Override
    public void clear() {
        cabeza = null;
        cola = null;
        size = 0;
    }

}
