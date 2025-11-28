/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4;

import java.util.Scanner;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class SumaArregloValidado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        System.out.println("Ingrese el tamaño del arreglo");

        while (true) {
            try {
                //Integer.parseInt(scanner.next());
                size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tama;o del arreglo"));
                
                if (size > 0) {
                    break;
                } else {
                    System.err.println("Error: Debe ingresar un numero mayor que 0");
                }
            } catch (Exception e) {
                System.err.println("Error: Debe ingresar un numero entero. Intente de nuevo");
            }
        }

        int[] arreglo = new int[size];
        int suma = 0;

        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.println("Ingrese el elemento " + (i + 1));
                    arreglo[i] = Integer.parseInt(scanner.next());
                    suma += arreglo[i];
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Error: Debe ingresar un numero entero. Intente de nuevo");
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error: Se excedio el tamaño del arreglo");
                }

            }
        }

        System.out.println(Arrays.toString(arreglo));
        System.out.println("La suma de los elementos es: " + suma);

    }
}
