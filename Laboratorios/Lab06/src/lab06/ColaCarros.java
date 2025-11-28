/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author fbarg
 */
public class ColaCarros {

    private Queue<Carro> carretera = new LinkedList<>();

    //Encolar Carro
    public void addCarro(Carro carro) {
        carretera.offer(carro);
    }

    //Desencolar carro
    public Carro pollCarro() {
        return carretera.poll();
    }

    //Consultar el siguiente carro
    public Carro peekCarro() {
        return carretera.peek();
    }

    //Tamaño de la cola de carros
    public int size() {
        return carretera.size();
    }

    //Valida Cola vacia
    public boolean isEmpty() {
        return carretera.isEmpty();
    }

    public static void main(String[] args) {
        ColaCarros carretera = new ColaCarros();

        System.out.println("Carretera esta vacia: "
                + (carretera.isEmpty() ? "Si" : "No"));

        Carro c1 = new Carro("BYD", "Seagull", "Blanco", 2020);
        Carro c2 = new Carro("Toyota", "Yaris", "Azul", 2020);

        Carro c3 = new Carro("Toyota", "Hilux", "Gris", 2020);
        Carro c4 = new Carro("Honda", "Civic", "Rojo", 2022);
        Carro c5 = new Carro("Nissan", "Sentra", "Gris", 2023);

        carretera.addCarro(c5);
        carretera.addCarro(c4);
        carretera.addCarro(c3);
        carretera.addCarro(c2);
        carretera.addCarro(c1);

        System.out.println("En la carretera hay " + carretera.size() + " carros");

        System.out.println("Carretera esta vacia: "
                + (carretera.isEmpty() ? "Si" : "No"));

        carretera.pollCarro();
        carretera.pollCarro();
        carretera.pollCarro();
        carretera.pollCarro();
        carretera.pollCarro();
        System.out.println("En la carretera hay " + carretera.size() + " carros");
        System.out.println("Siguiente Carro: " + carretera.peekCarro());       
        
    }

    public String listar() {
           var sal = "";
        for (Carro carro : carretera) {
            sal += carro + "\n";
        }
        return sal;
    }
}
