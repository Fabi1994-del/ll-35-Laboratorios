/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

/**
 *
 * @author fbarg
 */
public class Factorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1; // Caso base
        } else {
            System.out.println("n:" + (n - 1));
            return n * factorial(n - 1); // Llamada recursiva
        }
    }

    public static void main(String[] args) {
        int number = 3;
        System.out.println("Factorial de " + number + " = " + factorial(number));
    }
}
