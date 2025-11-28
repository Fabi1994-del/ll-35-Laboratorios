/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase5;

import java.util.EmptyStackException;

/**
 *
 * @author fbarg
 */
public class Clase5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila pila = new Pila(5); // Creando clase pila con size de 5

        // Agreguo elemento en la pila
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);
        pila.push(50);
        pila.push(60);

        try {
            //Eliminar un elemento de la pila
            //pila.pop();
            //pila.pop();
            //pila.pop();
            //pila.pop();

            // Ver el ultimo elemento;
            System.out.println("Elemento en el tope de la pila: " + pila.peek());
            
            // Tamaño de la pila 
            System.out.println("Tama?o de la pila: " + pila.size());
            
            while(!pila.isEmpty()){
                System.out.println("Eliminando elemento de la pila: " + pila.pop());
            }
            
            pila.pop();

        } catch (EmptyStackException e) {
            System.out.println("La pila esta vacia.");
        }

    }

}
