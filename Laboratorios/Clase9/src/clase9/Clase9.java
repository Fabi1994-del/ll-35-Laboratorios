/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase9;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 *
 * @author fbarg
 */
public class Clase9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Pila
        Pila<String> pilaString = new Pila<>();
        
        pilaString.push("Hola");
        pilaString.push("Mundo");
        //pilaString.push("123");

        System.out.println("*********pilaString**********"); // 
        System.out.println(pilaString); // 
        while (!pilaString.isEmpty()) {
            System.out.println("Elemento en la cima: " + pilaString.peek());
            String elemento = pilaString.pop();
            System.out.println("Popped: " + elemento);
        }

        //Cola
        System.out.println("*********colaChar**********"); //
        Cola<Character> colaChar = new Cola<>();
        colaChar.enqueue('A');
        colaChar.enqueue('A');
        colaChar.enqueue('B');
        colaChar.enqueue('C');
        colaChar.enqueue('D');        
        System.out.println(colaChar);
        
        while (!colaChar.isEmpty()) {
            System.out.println("Frente de la cola: " + colaChar.front());
            char elemento = colaChar.dequeue();
            System.out.println("Dequeue: " + elemento);
            System.out.println(colaChar);
        }


        System.out.println("*********colaInt**********"); // 
        Cola<Integer> colaInt = new Cola<>();
        colaInt.enqueue(10);
        colaInt.enqueue(20);
        colaInt.enqueue(30);
        colaInt.enqueue(40);
        System.out.println(colaInt);
        
        System.out.println("Frente: " + colaInt.nodoFrente());

        while (!colaInt.isEmpty()) {            
            int elemento = colaInt.dequeue();
            System.out.println("Dequeue: " + elemento);
            System.out.println(colaInt);
            System.out.println("Frente: " + colaInt.nodoFrente());
        }
    }
}
