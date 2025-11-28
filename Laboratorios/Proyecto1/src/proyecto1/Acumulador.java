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

    private int total; // guarda el valor actual del acumulador 
    Stack<Integer> pilaUndo; // guarda las operaciones que el usuario ha realizado y Deshace la ultima operacion 
    Stack<Integer> pilaRedo; //  Mediante undo guarda las operaciones que fueron deshechas y las rehace 

    public Acumulador() { //constructor 
        pilaUndo = new Stack<>();
        pilaRedo = new Stack<>();
        total = 0; // el acumulador se inicia en 0 y las pilas vacias 
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
        if(pilaUndo.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay operaciones para deshacer");
            return;
        }
        
        //Elimina el elemento que este al tope de undo
        int operacion = pilaUndo.pop();
        
        //Se aplica la operacion inversa
        int inversa = -operacion;
        total += inversa; 
        
        //Envia al redo la operacion original
        pilaRedo.push(inversa);
    }

    public void redo() {
        if(pilaRedo.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay operaciones que rehacer");
            return;
        }
        //Sacar del tope de REDO
        int operacion = pilaRedo.pop();
        
        //Se aplica la operacion nuevamente
        int inversa = -operacion;
        total += inversa;
        
        //Se guardam nuevamente un Undo
        pilaUndo.push(inversa);
    }

    // puede ser positivo o negativo
    public void aplicar(int valor) {
        //Agrega a undo
        pilaUndo.push(valor);
        
        //hace una nueva operacion y limpia el redo 
        pilaRedo.clear();
        
        //Tira el resultado
        total += valor; 
        
        System.out.println("Total:" + total);
        System.out.println("undoStack:" + pilaUndo);
    }

    public void estado() {
        JOptionPane.showMessageDialog(null,
                "UNDO (tope → fondo): " + pilaUndo +
                "\nREDO (tope → fondo): " + pilaRedo +
                "\nTOTAL: " + total);
    }

}
