/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase7;

/**
 *
 * @author fbarg
 */
public class ColaConArray {

    private int maxSize;
    private int[] cola;
    private int frente;
    private int fin;
    private int tamaño;

    public ColaConArray(int size) {
        this.maxSize = size;
        this.cola = new int[maxSize];
        this.frente = 0;
        this.fin = -1;
        this.tamaño = 0;
    }

    public void enqueue(int elemento) {
        if (tamaño == maxSize) {
            throw new IllegalStateException("La cola está llena.");
        }
        fin = (fin + 1) % maxSize; // Circular
        cola[fin] = elemento;
        tamaño++;
        System.out.println("Se agrego a la cola el elemento: " + elemento);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        int elemento = cola[frente];
        frente = (frente + 1) % maxSize; // Circular
        tamaño--;
        return elemento;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return cola[frente];
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public int size() {
        return tamaño;
    }
}
