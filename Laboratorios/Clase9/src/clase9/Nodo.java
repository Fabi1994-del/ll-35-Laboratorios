/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase9;

/**
 *
 * @author fbarg
 */
class Nodo<T> {

    T dato; // Tipo genérico
    Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "[ "  + dato + " -> " + siguiente + "]";
    } 
}
