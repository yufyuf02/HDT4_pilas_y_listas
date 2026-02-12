package Pilas;

public class PilaLista<T> implements IPila<T>{

    private String data;

    public PilaLista() {
        this.data = "";
    }

    @Override
    public void push(T element) {
        this.data += element.toString() + " ";
    }

    @Override
    public T pop() {
        if (this.data.isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        String[] elements = this.data.trim().split(" ");
        String topElement = elements[elements.length - 1];
        this.data = this.data.substring(0, this.data.lastIndexOf(topElement)).trim();
        return (T) topElement;
    }

    @Override
    public T peek() {
        if (this.data.isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        String[] elements = this.data.trim().split(" ");
        return (T) elements[elements.length - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }


    @Override
    public int size() {
        if (this.data.isEmpty()) {
            return 0;
        }
        return this.data.trim().split(" ").length;
    }

    @Override
    public void clear() {
        this.data = "";
    }
    

}
