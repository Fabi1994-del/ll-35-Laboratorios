/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author fbarg
 */
public class EditorTexto {

    private Stack<String> acciones;

    public EditorTexto() {
        acciones = new Stack<>();
    }

    public void escribir(String texto) {
        acciones.push(texto);
        System.out.println("Escribiendo: " + texto);
    }

    public void deshacer() {
        if (!acciones.isEmpty()) {
            String textDeshecho = acciones.pop();
            System.out.println("Deshaciendo: " + textDeshecho);
        } else {
            System.err.println("No hay acciones para deshacer.");
        }
    }

    public int size() {
        return acciones.size();
    }

    public static void main(String[] args) {
        EditorTexto et = new EditorTexto();
        et.escribir("Hola");
        et.escribir("Mundo");
        et.escribir("Mundo");
        et.escribir("Mundo");
        et.escribir("Mundo");
        et.escribir("Mundo");

        System.out.println("Acciones: " + et.size());

        et.deshacer();
        et.deshacer();
        System.out.println("Acciones: " + et.size());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese el texto a escribir");
            String texto = scanner.next();
            
            if (texto.contains("0")) {
                return;
            }

            if (texto.contains("!q")) {
                et.deshacer();
            } else {
                et.escribir(texto);
                System.out.println("Size:" + et.size());
            }
            
        }
    }
}
