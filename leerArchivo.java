import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Pilas.IPila;

public class leerArchivo {

    private IPila<String> pila;

    // Constructor (como lo tienes en UML)
    public leerArchivo(IPila<String> pila) {
        this.pila = pila;
    }

    // Método principal que lee y convierte
    public String procesarArchivo(String nombreArchivo) {

        String infix = leer(nombreArchivo);
        return convertirInfixPostfix(infix);
    }

    // Método que solo lee el archivo
    private String leer(String nombreArchivo) {

        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea);
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        return contenido.toString();
    }

    // Conversión Infix → Postfix usando la pila
    private String convertirInfixPostfix(String infix) {

        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {

            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
            }

            else if (c == '(') {
                pila.push(String.valueOf(c));
            }

            else if (c == ')') {

                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    postfix.append(pila.pop());
                }

                pila.pop(); // eliminar "("
            }

            else if (esOperador(c)) {

                while (!pila.isEmpty() &&
                        precedencia(c) <= precedencia(pila.peek().charAt(0))) {

                    postfix.append(pila.pop());
                }

                pila.push(String.valueOf(c));
            }
        }

        while (!pila.isEmpty()) {
            postfix.append(pila.pop());
        }

        return postfix.toString();
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedencia(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}
