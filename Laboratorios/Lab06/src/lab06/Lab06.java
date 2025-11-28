/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab06;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author fbarg
 */
public class Lab06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue colita = new LinkedList<>();

        colita.add(10);
        colita.add(20);
        colita.add(30);
        colita.add(40);
        colita.add(50);
        colita.add(60);

        System.out.println("Cuanto hay: " + colita.size());
        System.out.println("Siguiente en la cola:" + colita.remove());
        System.out.println("Siguiente en la cola:" + colita.remove());
        System.out.println("Siguiente en la cola:" + colita.peek());
        System.out.println("Cuanto hay: " + colita.size());

    }

}
