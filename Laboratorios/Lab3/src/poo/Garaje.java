/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author LENOVO
 */
public class Garaje {
    private int capacidad;
    private Carro [] espacios; 
    private int index;

    public Garaje(int capacidad) {
        this.capacidad = capacidad;
        this.espacios = new Carro[capacidad]; 
    }
    
    //apartarCarros
    public void aparcarCarro(Carro carro){
        if (index < capacidad){
            this.espacios[index++] = carro;  
            System.out.printf("Aparcando %s-%s\n", carro.getMarca(), carro.getModelo());
        }else{
            System.err.printf("Garaje lleno, capacidad maxima de %d\n", this.capacidad);
        }
        
    }
    
    //listarCarros()
    public void listarCarros(){
        for(Carro espacio : espacios){
            System.out.printf(" %s-[%s]\n", espacio.getMarca(), espacio.getModelo() );
        }
    }
    
}
