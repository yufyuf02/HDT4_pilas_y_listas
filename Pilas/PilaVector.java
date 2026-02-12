package Pilas;

import java.util.Vector;

public class PilaVector<T> implements IPila<T> {

    private Vector<T> data;

    public PilaVector() {
        data = new Vector<>();
    }

    @Override
    public void push(T item) {
        data.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return data.get(data.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }  

    @Override
    public void clear() {
        data.clear();
    }
    
}
