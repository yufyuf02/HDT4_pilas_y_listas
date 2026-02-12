package Pilas;

public interface IPila<T> {
    
    void push(T elemento);

    T pop();

    T peek();

    boolean isEmpty();

    int size();

    void clear();

}


