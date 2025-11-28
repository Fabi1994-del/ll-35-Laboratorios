/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6;

/**
 *
 * @author fbarg
 */


import java.util.LinkedList;
import java.util.Queue;

public class EjemploCola {
    public static void main(String[] args) {
        // Crear una cola, primero en entrar primero en salir 
        Queue<String> cola = new LinkedList<>();
        cola.add("Elemento 1");
        
        /* 
        element ---- peek
        element, maneja excepciones
        */
        
        System.out.println("Elementos en cola" + cola.peek());
        
        /* 
        Metodos de inserccion
        offer --- peek
        element --
        */
        // Agregar elementos a la cola con el offer
        cola.add("Elemento 1");
        cola.offer("Elemento 2");
        cola.offer("Elemento 3");
        cola.offer("Elemento 4");
        
        System.out.println("Siguiente en la cola: " + cola.size());
        // metodos de eliminacion 
        // element  -- peek 
        // remove, maneja excepciones 
//        // Mostrar el primer elemento de la cola sin eliminarlo
//        cola.remove();
//        cola.remove();
        System.out.println("Primer elemento en la cola: " + cola.peek());

        // Procesar los elementos de la cola
        while (!cola.isEmpty()) {
            System.out.println("Procesando: " + cola.poll()); // Elimina y retorna el primer elemento
        }
        
        System.out.println("Procesando: " + cola.poll()); // Elimina y retorna el primer elemento
        
        //cola.remove();
        
        // Intentar procesar de nuevo (la cola está vacía)
        if (cola.isEmpty()) {
            System.out.println("La cola está vacía.");
        }
    }
}
