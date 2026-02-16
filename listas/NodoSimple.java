// Para los nodos de encadenamiento simple
// que tienen de atributos data y siguiente.

package listas;

public class NodoSimple<T> {
    T data;
    NodoSimple<T> siguiente;

    // Constructor
    public NodoSimple(T data, NodoSimple<T> siguiente) {
        this.data = data;
        this.siguiente = siguiente;
    }
}
