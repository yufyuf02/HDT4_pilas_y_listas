// Para los nodos de doble encadenamiento
// que tienen de atributos data, siguiente y anterior.

package listas;

public class NodoDoble<T> {
    T data;
    NodoDoble<T> siguiente;
    NodoDoble<T> anterior;

    // Constructor
    public NodoDoble(T data, NodoDoble<T> siguiente, NodoDoble<T> anterior) {
        this.data = data;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
}
