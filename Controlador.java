import Pilas.IPila;
import Pilas.PilaArrayList;
import Pilas.PilaVector;
import Pilas.PilaLista;

import listas.ILista;
import listas.ListaSimple;
import listas.ListaDoble;

public class Controlador {

    public void iniciar(int seleccion, int opcion) {

        if (seleccion == 1) {

            IPila<String> pila = crearPila(opcion);

            System.out.println("Usando implementación de pila: "
                    + pila.getClass().getSimpleName());

            leerArchivo lector = new leerArchivo(pila);

            String resultado = lector.procesarArchivo("datos.txt");

            System.out.println(resultado);
        }

        else if (seleccion == 2) {

            ILista<String> lista = crearLista(opcion);

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

    private IPila<String> crearPila(int opcion) {

        switch (opcion) {
            case 1: return new PilaArrayList<>();
            case 2: return new PilaVector<>();
            case 3: return new PilaLista<>();
            default:
                throw new IllegalArgumentException("Opción inválida para pila");
        }
    }

    private ILista<String> crearLista(int opcion) {

        switch (opcion) {
            case 1: return new ListaSimple<>();
            case 2: return new ListaDoble<>();
            default:
                throw new IllegalArgumentException("Opción inválida para lista");
        }
    }
}
