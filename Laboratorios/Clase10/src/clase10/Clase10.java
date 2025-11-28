/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase10;

/**
 *
 * @author fbarg
 */
public class Clase10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Lista doble<cancion>
        ListaDoble<Character> lista = new ListaDoble<>();

        // Agregar elementos a la lista
//        lista.agregarEnCola('A');
//        lista.agregarEnCola('B');
//        lista.agregarEnCola('C');
//        lista.mostrarDesdeCabeza();
//        lista.mostrarDesdeCola();
//        lista.mostrarDesdeCabeza();
//        lista.mostrarDesdeCola();
//
//        // Agregar elementos a la lista
//        lista.agregarEnCola(10);
//        lista.agregarEnCola(20);
//        lista.agregarEnCola(30);
//        lista.agregarEnCola(40);
//        lista.agregarEnCola(50);
//
//        // Mostrar elementos desde el inicio
//        System.out.println("Lista desde el inicio:");
//        lista.mostrarDesdeCabeza();
//
//        //lista.eliminar(30);
//        System.out.println("posicion: " + lista.buscar(300));
//
//        // Mostrar elementos desde el final
//        System.out.println("Lista desde el final:");
//        lista.mostrarDesdeCola();
//
//        System.out.println("Cola dato:" + lista.getCola().dato);
//        System.out.println("Cabeza dato:" + lista.getCabeza().dato);
//
//        System.out.println("Anterior Cabeza dato:" + lista.getCabeza().anterior.dato);
        //FABIOLA
        Character f = 'F';
        Character a = 'A';
        Character b = 'B';
        Character i = 'I';

        lista.agregarEnCola(b);
        lista.agregarEnCabeza(a);
        lista.agregarEnCabeza(f);
        lista.agregarEnCola(i);

        lista.unir();

        //Palindromo  - si se agrega alveris queda igual - palabra RADAR 
        Character r = 'R';
        Character d = 'D';
        ListaDoble<Character> listaPal = new ListaDoble<>();
        listaPal.agregarEnCabeza(r);
        listaPal.agregarEnCola(a);
        listaPal.agregarEnCola(d);
        listaPal.agregarEnCola(a);
        listaPal.agregarEnCola(r);
        listaPal.unir();
    }

}
