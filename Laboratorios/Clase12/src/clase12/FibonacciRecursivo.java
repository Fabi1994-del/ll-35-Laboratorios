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
public class FibonacciRecursivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la posición hasta donde desea imprimir la sucesión de Fibonacci: ");
        int x = scanner.nextInt();

        System.out.println("Sucesión de Fibonacci hasta la posición " + x + ":");
        for (int i = 0; i < x; i++) { // Llamar a la función para cada posición
            System.out.print(fib(i) + " ");
        }
        System.out.println(); // Nueva línea al final
    }

    public static int fib(int n) {
        if (n == 0) return 0; // Caso base para n=0
        if (n == 1) return 1; // Caso base para n=1
        return fib(n - 1) + fib(n - 2); // Llamada recursiva
    }
}
