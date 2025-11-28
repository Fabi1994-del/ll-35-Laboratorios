package clase8;

import java.util.Stack;

public class ListaEnlazada<T> {

    private Nodo<T> cabeza;     // Primer nodo de la lista
    private Stack<T> eliminados; // Pila con los elementos eliminados

    public ListaEnlazada() {
        this.cabeza = null; 
        this.eliminados = new Stack<>();
    }

    //  AGREGAR 
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevoNodo);
        }
        mostrar();
    }

    // MOSTRAR 
    public void mostrar() {
        Nodo<T> actual = cabeza;

        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }

        System.out.println("[]");
    }

    // BUSCAR (NODO) 
    public Nodo<T> buscarNodo(T dato) {
        Nodo<T> actual = cabeza;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    //  BUSCAR (MENSAJE)
    public String buscar(T dato) {
        return (buscarNodo(dato) != null)
                ? "Elemento " + dato + " encontrado en la lista."
                : "Elemento " + dato + " no encontrado en la lista.";
    }

    //  ELIMINAR 
    public boolean eliminar(T dato) {

        if (isEmpty()) return false;

        // Caso 1: Eliminar cabeza
        if (cabeza.getDato().equals(dato)) {
            eliminados.push(cabeza.getDato());
            cabeza = cabeza.getSiguiente();
            mostrar();
            return true;
        }

        // Caso 2: Buscar nodo interior
        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;

        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) return false; // No encontrado

        // Eliminar nodo
        eliminados.push(actual.getDato());
        anterior.setSiguiente(actual.getSiguiente());

        mostrar();
        return true;
    }

    //GETTERS 
    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public Stack<T> getEliminados() {
        return eliminados;
    }
}
