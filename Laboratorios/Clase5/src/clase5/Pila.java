/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5;

import java.util.EmptyStackException;

/**
 *
 * @author fbarg
 */
public class Pila {

    private int maxSize; //tamaño maximo de la pila
    private int[] stackArray; // contedor de elementos
    private int top; // tope de la pila

    public Pila(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;// cuando pila esta vacia 
    }

    public void push(int value) {
        if (top + 1 == maxSize) {
            System.out.println("La pila ya esta Llena");
            return;
        }
        this.stackArray[++top] = value;
        System.out.println("Elemento agregado: " + value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stackArray[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

}
