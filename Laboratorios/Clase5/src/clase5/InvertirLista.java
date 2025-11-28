/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class InvertirLista {

    public static List<String> invertirLista(List<String> lista) {
        Stack<String> pila = new Stack<>();
        

        // Apilar todos los elementos de la lista
        for (String elemento : lista) {
            pila.push(elemento);
        }

        // Crear una nueva lista para almacenar los elementos invertidos
        List<String> listaInvertida = new java.util.ArrayList<>();

        // Desapilar los elementos y agregarlos a la nueva lista
        while (!pila.isEmpty()) {
            listaInvertida.add(pila.pop());
        }

        return listaInvertida;
    }

    public static void main(String[] args) {
        //Lista original
        List<String> listaOriginal = Arrays.asList("Uno", "Dos", "Tres", "Cuatro", "Cinco");
       
        //Mostrar lista original en un JOptionPane
        JOptionPane.showMessageDialog(null, "Lista Oiginal: \n" + listaOriginal);

        //Invertir lista
        List<String> listaInvertida = invertirLista(listaOriginal);

        //Mostrar lista invertida en un JOptionPane
        JOptionPane.showMessageDialog(null, "Lista invertida: \n" + listaInvertida);
    }
    
   
    
}
