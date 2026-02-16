import java.util.Scanner;

/** 
 * HDT4: Pilas y listas
 * Autores: Yu-Fong Chen 242115 y Axel Xitumul 25783
 * 
 * Uso de interfaces para pila y lista.
*/

public class Main {
    public static void main(String[] args) {
        int resultado = menu();
        int seleccion = resultado / 10;
        int opcion = resultado % 10;
        // System.out.println(seleccion + " " + opcion);    Viendo si funciona la separación de selección y opción
        if (seleccion != 3) {   // Si no eligió salir
            Controlador controlador = new Controlador();
            controlador.iniciar(seleccion, opcion);
        }
    }

// FIN DE PROGRAMA

    private static int menu() {
        Scanner teclado = new Scanner(System.in);
        int seleccion;

        do {
            System.out.println("");
            System.out.println("*** Calculadora de infix ***");
            System.out.println("");

            System.out.println("¿Qué te gustaría usar?");
            System.out.println("    (1) Pila / Stack");
            System.out.println("    (2) Lista");
            System.out.println("    (3) Salir");

            seleccion = teclado.nextInt();

            switch (seleccion) {
                case 1:
                    System.out.println("¿Qué clase de implementación te gustaría?");
                    System.out.println("    (1) ArrayList");
                    System.out.println("    (2) Vector");
                    System.out.println("    (3) Lista");

                    int opcionPila = teclado.nextInt();
                    teclado.close();
                    return seleccion * 10 + opcionPila;

                case 2:
                    System.out.println("¿Qué clase de implementación te gustaría?");
                    System.out.println("    (1) Simplemente encadenada");
                    System.out.println("    (2) Doblemente encadenada");

                    int opcionLista = teclado.nextInt();
                    teclado.close();
                    return seleccion * 10 + opcionLista;
                case 3:
                    System.out.println("¡Gracias por usar!");
                    teclado.close();
                    return seleccion * 10;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (true);
    }
}
