import java.util.Scanner;

/** 
 * HDT4: Pilas y listas
 * Autores: Yu-Fong Chen 242115 y Axel Xitumul 25783
 * 
 * Uso de interfaces para pila y lista.
*/

public class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner teclado = new Scanner(System.in);
        int seleccion = 0;

        System.out.println("*** Calculadora de infix ***");
        System.out.println("");

        if (seleccion == 0) {
            System.out.println("Qué te gustaría usar?\r\n" + //
                        "        (1) Pila / Stack\r\n" + //
                        "        (2) Lista");
            teclado.nextInt();
        } else if (seleccion == 1) {
            System.out.println("Qué clase de implementación te gustaría?\r\n" + //
                        "        (1) ArrayList\r\n" + //
                        "        (2) Vector\r\n" + //
                        "        (3) Lista");
        } else if (seleccion == 2) {
            System.out.println("Qué clase de implementación te gustaría?\r\n" + //
                        "        (1) Simplemente encadenada\r\n" + //
                        "        (2) Doblemente encadenada");
        }

        System.out.println("");
    }
}
