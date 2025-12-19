/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

/**
 *
 * @author fbarg
 */
public class TorresDeHanoi {
    public static void moverTorre(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return;
        }
        //'A', 'B', 'C'
        moverTorre(n - 1, origen, auxiliar, destino);
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
        //'B', 'C', 'A'
        moverTorre(n - 1, auxiliar, destino, origen);
    }

    public static void main(String[] args) {
        int n = 5; // Número de discos
        moverTorre(n, 'A', 'C', 'B'); // A es el origen, C es el destino y B es el auxiliar
    }
}