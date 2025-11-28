/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 *
 * @author fbarg
 * @param <T>
 */
public class PilaList<T> {
    
    private final ArrayList<T> elements;
    private int top;

    public PilaList() {
        this.elements = new ArrayList<>();
        this.top = -1;
    }

    public void push(T value) {
        this.elements.add(value);
        ++top;
        System.out.println("Elemento agregado: " + value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T temp = this.elements.get(top);
        this.elements.remove(top);
        top--;
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        //return this.elements.get(top);
        return this.elements.getLast();
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pila{elements=[]}";
        }
        StringBuilder sb = new StringBuilder("Pila\n{elements=");
        for (int i = top; i >= 0; i--) {
            sb.append("\n[").append(elements.get(i)).append("]");
            if (i == top) {
                sb.append("<= top");
            }
        }
        sb.append("\n}");
        return sb.toString();
    }

    public static void main(String[] args) {
        PilaList<String> p = new PilaList();
        System.out.println(p.toString());
        p.push("Johan");
        p.push("Mario");
        p.push("Marcelo");
        

        System.out.println("Eliminando el elemento: " + p.pop());
        p.push("Joel");
        System.out.println("El elemento en el top es: " + p.peek());
        System.out.println("Elementos en la pila: " + p.size());

        System.out.println(p.toString());
    }
}

