/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

/**
 *
 * @author fbarg
 */
public class ContarOcurrencias {
    
    //Recursividad
    
    
    public static int contarOcurrencias(int[] array, int objetivo, int indice) {
        System.out.println( "indice " + indice);
        if (indice >= array.length) { // caso base o validacion de salida 
            return 0; // Caso base
        } else if (array[indice] == objetivo) {
            return 1 + contarOcurrencias(array, objetivo, indice + 1 ); // Llamada recursiva si hay coincidencia
        } else {
            return contarOcurrencias(array, objetivo, indice + 1); // Llamada recursiva si no hay coincidencia
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 2, 4, 2};
        int objetivo = 2;
        System.out.println("El número " + objetivo + " aparece " +
                           contarOcurrencias(numeros, objetivo, 0) + " veces.");
    }
    
    /*
    contarOcurrencias -> numeros ->2 -> 0
    
    contarOcurencias (array, 2, 0) + 
    contarOcurencias (array, 2, 1) + 1
    contarOcurencias (array, 2, 2) +
    contarOcurencias (array, 2, 3) + 1
    contarOcurencias (array, 2, 4) +
    contarOcurencias (array, 2, 5) + 1
    contarOcurencias (array, 2, 5) +
    */
    
}
