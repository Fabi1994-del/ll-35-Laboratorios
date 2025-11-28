/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase8;

/**
 *
 * @author fbarg
 */
public class Clase8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        //Eliminar estando vacio
        System.out.println("Eliminar 99: " + lista.eliminar(99));

        //Agregar elementos a la lista
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);
        lista.agregar(50);
        
        System.out.println("Cabeza: " + lista.getCabeza());

        //Mostrar los elementos de la lista
        System.out.println("Elementos de la lista");
        lista.mostrar();
        // buscando 0
        System.out.println(lista.buscar(0));
        System.out.println("Buscar Nodo con dato 0: " + lista.buscarNodo(0));

        // buscando 30
        System.out.println(lista.buscar(30));
        System.out.println("Buscar Nodo con dato 0: " + lista.buscarNodo(30));

        lista.eliminar(30);
        lista.mostrar();

        System.out.println("Eliminar 40: " + lista.eliminar(40));
        lista.mostrar();

        //Eliminar cabeza(primer elemento de la lista)
        System.out.println("Eliminar 10: " + lista.eliminar(10));
        lista.mostrar();
        System.out.println("Cabeza: " + lista.getCabeza());

    }

}
