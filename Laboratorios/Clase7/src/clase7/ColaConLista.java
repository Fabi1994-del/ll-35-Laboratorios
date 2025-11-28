/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase7;

/**
 *
 * @author fbarg
 */
import java.util.LinkedList;

public class ColaConLista {
    private LinkedList<Integer> cola;

    public ColaConLista() {
        this.cola = new LinkedList<>();
    }

    public void enqueue(int elemento) {
        System.out.println("Se agrego a la cola el elemento: " + elemento);
        cola.addLast(elemento); // Agregar al final
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return cola.removeFirst(); // Eliminar desde el frente
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return cola.getFirst(); // Obtener el primer elemento sin eliminar
    }

    public boolean isEmpty() {
        return cola.isEmpty();
    }

    public int size() {
        return cola.size();
    }
}
