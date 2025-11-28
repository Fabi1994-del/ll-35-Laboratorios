/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class Acumulador {

    private int total;
    Stack<Integer> pilaUndo;
    Stack<Integer> pilaRedo;

    public Acumulador() {
        pilaUndo = new Stack<>();
    }
    
    public int getTotal() {
        return total;
    }

    public Stack<Integer> getUndoStack() {
        return pilaUndo;
    }

    public Stack<Integer> getRedoStack() {
        return pilaRedo;
    }

    public void undo() {
//Tanto para el metodo undo y redo requerimos realizar una validacion, si pila undo esta vacia agregar un 
//mensaje que diga "no hay operaciones para deshacer"
//El Undo va a eliminar de la pila de undo, va a eliminar el elemento que este al tope y la v a ainsertar en el 
//elemento Redo 
// paso 1: Desapilar pilaUndo 
// pas 2: Apilar en pilaRedola inversa de la operacion 
    }

    public void redo() {

    }

    // puede ser positivo o negativo
    public void aplicar(int valor) {
        pilaUndo.add(valor);
        total = 0;

        for (Integer v : pilaUndo) {
            total += v;
        }
        System.out.println("Total:" + total);
        System.out.println("undoStack:" + pilaUndo);
    }

    public void estado() {
        JOptionPane.showMessageDialog(null,
                "UNDO:" + pilaUndo + "\n" + "REDO:" + pilaRedo);
    }

}
