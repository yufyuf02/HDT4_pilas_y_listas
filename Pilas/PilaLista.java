package Pilas;

public class PilaLista<T> implements IPila<T> {

    private String data;

    public PilaLista() {
        this.data = "";
    }

    @Override
    public void push(T element) {

        if (data.length() == 0) {
            data = element.toString();
        } else {
            data = data + " " + element.toString();
        }
    }

    @Override
    public T pop() {

        if (data.length() == 0) {
            throw new RuntimeException("La pila está vacía");
        }

        int lastSpace = data.lastIndexOf(" ");

        String top;

        if (lastSpace == -1) {
            top = data;
            data = "";
        } else {
            top = data.substring(lastSpace + 1);
            data = data.substring(0, lastSpace);
        }

        return (T) top;
    }

    @Override
    public T peek() {

        if (data.length() == 0) {
            throw new RuntimeException("La pila está vacía");
        }

        int lastSpace = data.lastIndexOf(" ");

        if (lastSpace == -1) {
            return (T) data;
        }

        return (T) data.substring(lastSpace + 1);
    }

    @Override
    public boolean isEmpty() {
        return data.length() == 0;
    }

    @Override
    public int size() {

        if (data.length() == 0) {
            return 0;
        }

        int count = 1;

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ' ') {
                count++;
            }
        }

        return count;
    }

    @Override
    public void clear() {
        data = "";
    }
}
