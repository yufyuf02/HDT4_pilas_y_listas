import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Pilas.IPila;
import listas.ILista;

public class leerArchivo {

    private IPila<String> pila;
    private ILista<String> lista;
    private boolean usarPila;

    // Constructor para Pila
    public leerArchivo(IPila<String> pila) {
        this.pila = pila;
        this.usarPila = true;
    }

    // Constructor para Lista
    public leerArchivo(ILista<String> lista) {
        this.lista = lista;
        this.usarPila = false;
    }

    public String procesarArchivo(String nombreArchivo) {

        String infix = leer(nombreArchivo);

        String postfix = convertirInfixPostfix(infix);

        // Limpiar antes de evaluar
        clearEstructura();

        int resultado = evaluarPostfix(postfix);

        return "Postfix: " + postfix +
               "\nResultado de la ecuación: " + resultado;
    }

    // ===============================
    // LEER ARCHIVO
    // ===============================

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

    // ===============================
    // INFIX → POSTFIX
    // ===============================

    private String convertirInfixPostfix(String infix) {

        StringBuilder postfix = new StringBuilder();
        String[] tokens = infix.trim().split("\\s+");

        for (String token : tokens) {

            if (token.matches("\\d+")) {
                postfix.append(token).append(" ");
            }

            else if (token.equals("(")) {
                push(token);
            }

            else if (token.equals(")")) {

                while (!isEmpty() && !peek().equals("(")) {
                    postfix.append(pop()).append(" ");
                }

                pop(); // quitar "("
            }

            else if (esOperador(token.charAt(0))) {

                while (!isEmpty() &&
                       precedencia(token.charAt(0)) <= precedencia(peek().charAt(0))) {

                    postfix.append(pop()).append(" ");
                }

                push(token);
            }
        }

        while (!isEmpty()) {
            postfix.append(pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    // ===============================
    // EVALUAR POSTFIX
    // ===============================

    private int evaluarPostfix(String postfix) {

        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {

            if (token.matches("\\d+")) {
                push(token);
            }

            else if (esOperador(token.charAt(0))) {

                if (size() < 2) {
                    System.out.println("Error: No hay suficientes números en la pila para operar.");
                    return 0;
                }

                int b = Integer.parseInt(pop());
                int a = Integer.parseInt(pop());

                int resultado = 0;

                switch (token.charAt(0)) {
                    case '+': resultado = a + b; break;
                    case '-': resultado = a - b; break;
                    case '*': resultado = a * b; break;
                    case '/': resultado = a / b; break;
                }

                push(String.valueOf(resultado));
            }
        }

        return Integer.parseInt(pop());
    }

    // ===============================
    // MÉTODOS AUXILIARES
    // ===============================

    private void push(String dato) {
        if (usarPila) {
            pila.push(dato);
        } else {
            lista.add(dato);
        }
    }

    private String pop() {
        if (usarPila) {
            return pila.pop();
        } else {
            return lista.removeLast();
        }
    }

    private String peek() {
        if (usarPila) {
            return pila.peek();
        } else {
            return lista.getLast();
        }
    }

    private boolean isEmpty() {
        if (usarPila) {
            return pila.isEmpty();
        } else {
            return lista.isEmpty();
        }
    }

    private int size() {
        if (usarPila) {
            return pila.size();
        } else {
            return lista.size();
        }
    }

    private void clearEstructura() {
        if (usarPila) {
            pila.clear();
        } else {
            lista.clear();
        }
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedencia(char c) {
        switch (c) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
        }
        return -1;
    }
}
