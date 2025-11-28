/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab07;

public class ListaEnlazada<T> {

    private Nodo<T> cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    public void agregar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void mostrar() {
        Nodo<T> actual = cabeza;

        while (actual != null) {
            System.out.print(actual.dato + "->");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }
}
