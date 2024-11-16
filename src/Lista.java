import javax.swing.*;

public class Lista {
    private Nodo inicio;
    private int tamano;

    public Lista() {
        inicio = null;
        tamano = 0;
    }

    public void agregar(int dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
        actualizarTextArea(textArea);
    }

    public void ordenarBurbuja(JTextArea textArea) {
        if (inicio == null || inicio.siguiente == null) return;

        boolean swapped;
        do {
            swapped = false;
            Nodo actual = inicio;
            Nodo siguiente = inicio.siguiente;
            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    swapped = true;
                }
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (swapped);

        actualizarTextArea(textArea);
    }

    public int buscarBinario(int dato, JTextArea textArea) {
        ordenarBurbuja(textArea);
        int[] array = convertirAArray();
        int inicio = 0;
        int fin = tamano - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (array[medio] == dato) {
                return medio;
            }
            if (array[medio] < dato) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    private int[] convertirAArray() {
        int[] array = new int[tamano];
        Nodo actual = inicio;
        int i = 0;
        while (actual != null) {
            array[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return array;
    }

    public void mostrarLista(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("La lista está vacía.");
        } else {
            StringBuilder listaStr = new StringBuilder();
            Nodo actual = inicio;
            while (actual != null) {
                listaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(listaStr.toString());
        }
    }

    private void actualizarTextArea(JTextArea textArea) {
        mostrarLista(textArea);
    }
}