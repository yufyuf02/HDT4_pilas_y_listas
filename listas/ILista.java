/**
* Interfaz de la Lista

* Delimita que puede hacer "add", "removeLast", "getLast", "isEmpty" y "size".
* El tipo de dato en "add", "removeLast" y "getLast" es genérico (T) y se puede especificar.
*/

package listas;

public interface ILista<T> {
    void add (T element);
    T removeLast();
    T getLast();
    boolean isEmpty();
    int size();
    void clear();
}