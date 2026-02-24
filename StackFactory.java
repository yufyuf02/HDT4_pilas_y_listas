import pilas.IPila;
import pilas.PilaArrayList;
import pilas.PilaLista;
import pilas.PilaVector;

public class StackFactory<T> {

        public IPila<String> crearPila(int opcion) {

        switch (opcion) {
            case 1: return new PilaArrayList<>();
            case 2: return new PilaVector<>();
            case 3: return new PilaLista<>();
            default:
                throw new IllegalArgumentException("Opción inválida para pila");
        }
    }
}
