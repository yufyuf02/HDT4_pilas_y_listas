import listas.ILista;
import listas.ListaDoble;
import listas.ListaSimple;

public class ListFactory<T> {

    public ILista<String> crearLista(int opcion) {

        switch (opcion) {
            case 1: return new ListaSimple<>();
            case 2: return new ListaDoble<>();
            default:
                throw new IllegalArgumentException("Opción inválida para lista");
        }
    }
}
