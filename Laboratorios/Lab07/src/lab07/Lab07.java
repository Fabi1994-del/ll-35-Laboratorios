/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab07;

/**
 *
 * @author LENOVO
 */
public class Lab07 {

    public static void main(String[] args) {

        ListaEnlazada<Persona> lista = new ListaEnlazada<>();

        lista.agregar(new Persona("FABIOLA", "DELGADO", 31));
        lista.agregar(new Persona("PEDRO", "LOPEZ", 22));

        lista.mostrar();
    }
}
