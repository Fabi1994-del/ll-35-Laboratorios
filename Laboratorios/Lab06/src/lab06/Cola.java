package lab06;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class Cola {

    private int tamañoMaximo;
    private int[] cola;
    private int frente;
    private int fin;
    private int tamaño;

    // Constructor
    public Cola(int tamaño) {
        this.tamañoMaximo = tamaño;
        this.cola = new int[tamañoMaximo];
        this.frente = 0;
        this.fin = -1;
        this.tamaño = 0;
    }

    // enqueue: Agregar a la cola
    public void enqueue(int elemento) {
        if (tamaño == tamañoMaximo) {
            JOptionPane.showMessageDialog(null, this);
            throw new IllegalStateException("La cola está llena.");
        }

        System.out.println("elemento" + elemento);
        System.out.println("(fin + 1)=" + (fin + 1));
        System.out.println("(fin + 1) % tamañoMaximo = " + ((fin + 1) % tamañoMaximo));

        fin = (fin + 1) % tamañoMaximo; // Circular
        System.out.println("Fin:" + fin);
        cola[fin] = elemento;
        tamaño++;
        System.out.println("Se agrego a la cola el elemento: " + elemento);
    }
    // fin de enqueue

    // dequeue: eliminar de a la cola
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        int elemento = cola[frente];
        frente = (frente + 1) % tamañoMaximo; // Circular
        tamaño--;
        return elemento;
    }
    // fin de dequeue

    // peek: consultar el frete de la cola
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        System.out.println("Frente:" + frente);
        return cola[frente];
    }
    // fin de peek

    //isEmpty: validar si esta vacia la cola 
    public boolean isEmpty() {
        return tamaño == 0;
    }
    // fin de isEmpty

    // size: cantidad de elemento en la cola
    public int size() {
        return tamaño;
    }
    // fin de isEmpty
    
    @Override
    public String toString() {
        return "Cola: " + Arrays.toString(cola);
    }

    public static void main(String[] args) {
        Cola colita = new Cola(5);
        colita.enqueue(10);
        colita.enqueue(20);
        colita.enqueue(30);
        colita.enqueue(40);
        colita.enqueue(50);
        colita.enqueue(60);

        System.out.println("size:" + colita.size());
        System.out.println("peek:" + colita.peek());

        System.out.println(colita);
        

    }
}
