/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

import java.util.HashMap;

/**
 *
 * @author fbarg
 */
public class Fibonacci {

    private static HashMap<Integer, Integer> memo = new HashMap<>();
    int i = 0;
    
    public static int fib(int n) {
        if (n <= 1) {
            return n; // Caso base
        }
        int n1 = fib(n - 1);
        int n2 = fib(n - 2);
        
        // Store result in memo
        memo.put(n, n1 + n2);
        

        System.out.println("n=" + n + " | fib(" + (n - 1) + ")=" + (n1) + " + fib(" + (n - 2)
                + ")=" + n2 + " | " + (n1 + n2));
        System.out.print("");
        return n1 + n2; // Llamada recursiva
    }

    public static void main(String[] args) {
        int n = 5; // Ejemplo para calcular el 5to número de Fibonacci
        System.out.println("Fibonacci de " + n + " = " + fib(n));
    }

}
