/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1;

/**
 *
 * @author LENOVO
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println("Hola Mundo");
        String[] variables = new String [3];
        //["0"] ["1"] ["2"]
                
        int edad1 = 10;
        int edad2 = 22;
        boolean esMayor; //sino pone el false por defecto es un false 
        
        esMayor = edad1 >=18;
        
        boolean esMayor2 = edad2 >= 18;
        
        System.out.println( 
                 "Edad1: " + (esMayor ? " Si es Mayor" : "Es menor") + "\n" + 
                 "Edad2: " + (esMayor2 ? " Si es Mayor" : "Es menor"));
        
        String nombre = "Fabiola ";
        variables[0] = nombre;
        
        char inicial = nombre.charAt(0); // imprime el espacio indicado dentro del parentesis 
        int tamaño = nombre.length();
        char ultima = nombre.charAt(tamaño - 2); 
        
        variables[1] = inicial + "";
        variables[2] = ultima + "";
        
        for (String variable : variables){
            System.out.println(variable);
        }
        
        //Decimales
        int numero = 10;
        float division;
        division = (float) numero / 4;
        System.out.println(division);
    }
    
}
