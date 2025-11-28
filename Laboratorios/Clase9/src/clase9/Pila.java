/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase9;

import java.util.EmptyStackException;

/**
 *
 * @author fbarg
 */
class Pila<T> {

    private Nodo<T> cima; // Puntero al nodo superior

    public Pila() {
        this.cima = null; // Inicialmente, la pila está vacía
    }

    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        System.out.println("Ágregando dato" + dato);
        System.out.println("nodo" + nuevoNodo);

        nuevoNodo.siguiente = cima; // Enlazar el nuevo nodo a la cima actual

        cima = nuevoNodo; // Actualizar la cima

        System.out.println("cima" + cima + "\n");

    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Manejo de pila vacía - throw una nueva excepcion
        }
        T dato = cima.dato; // Obtener el dato en la cima
        cima = cima.siguiente; // Mover la cima al siguiente nodo
        return dato; // Retornar el dato eliminado
    }

    public T peek() {
        if (cima == null) {
            throw new EmptyStackException();
        }
        return cima.dato; // Retornar el dato en la cima sin eliminarlo
    }

    public boolean isEmpty() {
        return cima == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila: ");
        Nodo<T> actual = cima;
        while (actual != null) {
            sb.append(actual.dato).append(" -> "); //Agregan dato del nodo actual
            actual = actual.siguiente; // Mover al siguiente nodo 
        }
        sb.append(" []");
        return sb.toString();
    }

    public Nodo nodoCima() {
        return cima;
    }

    public String Unir() {
        Nodo<T> auxiliar = cima;
        StringBuilder sb = new StringBuilder();

        while (auxiliar != null) {
            sb.append(auxiliar.dato);
            auxiliar = auxiliar.siguiente;
        }
        return sb.toString();
    }

}
