/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase9;

import java.util.NoSuchElementException;

/**
 *
 * @author fbarg
 */
class Cola<T> {

    private Nodo<T> frente; // Puntero al primer nodo
    private Nodo<T> fondo; // Puntero al último nodo

    public Cola() {
        this.frente = null;
        this.fondo = null; // Inicialmente, la cola está vacía
    }

    public void enqueue(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (fondo != null) {
            fondo.siguiente = nuevoNodo; // Enlazar el nuevo nodo al final actual
        } else {
            frente = nuevoNodo; // Si está vacía, establecer frente
        }
        fondo = nuevoNodo; // Actualizar el puntero final
        
        System.out.println("Agregamos dato:" + dato);
        System.out.println("frente:" + frente);
        System.out.println("final:" + fondo + "\n");
        
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException(); // Manejo de cola vacía
        }
        T dato = frente.dato; // Obtener el dato del frente
        frente = frente.siguiente; // Mover el frente al siguiente nodo

        if (frente == null) {
            fondo = null; // Si queda vacío, también actualizar fondo
        }

        return dato; // Retornar el dato eliminado
    }

    public T front() {
        if (frente == null) {
            throw new NoSuchElementException();
        }
        return frente.dato; // Retornar el dato en el frente sin eliminarlo
    }

    public Nodo nodoFrente() {
       
        return frente; // Retornar el nodo en el frente sin eliminarlo
    }

    public Nodo nodoFondo(){
        return fondo;
    }
    
    public boolean isEmpty() {
        return frente == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cola: ");
        Nodo<T> actual = frente;
        while (actual != null) {
            sb.append(actual.dato).append(" -> "); //Agregan dato del nodo actual
            actual = actual.siguiente;
        }
        sb.append("[]");
        return sb.toString();
    }

    String Unir() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = frente;
        while (actual != null) {
            sb.append(actual.dato); //Agregan dato del nodo actual
            actual = actual.siguiente;
        }
        
        return sb.toString();
    }

}
