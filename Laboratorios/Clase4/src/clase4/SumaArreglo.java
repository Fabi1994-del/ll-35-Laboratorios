/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4;

import java.util.Scanner;

/**
 *
 * @author fbarg
 */
public class SumaArreglo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del arreglo");

        int size = scanner.nextInt();
        int[] arreglo = new int[size];
        int suma = 0;
        
        for (int i = 0; i < size + 1; i++) {
            System.out.println("Ingrese el elemento " + (i + 1));
            arreglo[i] = scanner.nextInt();
            suma += arreglo[i];
        }

        System.out.println("La suma de los elementos es: " + suma);

    }
}
