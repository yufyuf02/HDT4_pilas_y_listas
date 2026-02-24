import listas.ILista;
import pilas.IPila;

public class Controlador {

    // Implementación de Factory's
    StackFactory<Object> factoryDePilas = new StackFactory<>();
    ListFactory<Object> factoryDeListas = new ListFactory<>();

    public void iniciar(int seleccion, int opcion) {

        if (seleccion == 1) {

            // IPila<String> pila = crearPila(opcion);                  Funcionamiento inicial
            // factoryDePilas.crearPila(opcion);                        Factory
            IPila<String> pila = factoryDePilas.crearPila(opcion);      // Combinación más reciente

            System.out.println("Usando implementación de pila: "
                    + pila.getClass().getSimpleName());

            leerArchivo lector = new leerArchivo(pila);

            String resultado = lector.procesarArchivo("datos.txt");

            System.out.println(resultado);
        }

        else if (seleccion == 2) {

            // ILista<String> lista = crearLista(opcion);
            // factoryDeListas.crearLista(opcion);
            ILista<String> lista = factoryDeListas.crearLista(opcion);

            System.out.println("Usando implementación de lista: "
                    + lista.getClass().getSimpleName());

            leerArchivo lector = new leerArchivo(lista);

            String resultado = lector.procesarArchivo("datos.txt");


            System.out.println(resultado);
        }

        else {
            System.out.println("Saliendo del programa...");
        }
    }
}