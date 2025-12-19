/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

import java.util.Scanner;

/**
 *
 * @author fbarg
 */
public class FibonacciIterativo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int x = scanner.nextInt();

        System.out.println("Sucesión de Fibonacci hasta " + x + ":");
        imprimirFibonacciHasta(x);
    }

    public static void imprimirFibonacciHasta(int x) {
        int a = 0, b = 1;
        // Imprimir 0 si x es mayor o igual a 0
        if (x >= 0) {
            System.out.print(a + " ");
        }
        while (b <= x) { // Cambiar la condición para incluir 'b'
            System.out.print(b + " ");
            int siguiente = a + b; // Siguiente número en la sucesión
            a = b; // Actualizar 'a' al siguiente número
            b = siguiente; // Actualizar 'b' al siguiente número
        }
        System.out.println(); // Nueva línea al final
    }
}
