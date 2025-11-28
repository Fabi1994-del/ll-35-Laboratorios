/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase10;

/**
 *
 * @author fbarg
 */
public class ListaDoble<T> {

    private Nodo<T> cabeza; // Puntero al primer nodo
    private Nodo<T> cola;   // Puntero al último nodo  

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public Nodo<T> getCola() {
        return cola;
    }

    public void agregarEnCola(T dato) {
        System.out.println("Agregando en la cola(al final): \t" + dato);
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (cabeza == null) { // Si la lista está vacía
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo; // Enlazar el nuevo nodo al final
            nuevoNodo.anterior = cola;   // Enlazar el nodo anterior
            cola = nuevoNodo;            // Actualizar la cola
        }
        mostrarDesdeCola();
    }

    public void agregarEnCabeza(T dato) {
        System.out.println("Agregando  a la cabeza(al principio): \t" + dato);
        Nodo<T> nuevoNodo = new Nodo<>(dato); // Se crea un nuevo nodo que tiene el dato 

        // <- A -> forma grafica 
        if (cabeza == null) { // Si la lista está vacía
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
        mostrarDesdeCabeza();
    }

    // Método para mostrar los elementos de la lista desde el principio
    public void mostrarDesdeCabeza() {
        Nodo<T> actual = cabeza;
        System.out.println("Desde el Inicio:\tCabeza=>\t");
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Método para mostrar los elementos de la lista desde el final
    public void mostrarDesdeCola() {
        Nodo<T> actual = cola;
        System.out.println("Desde el fin:\tCola=>\t");
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }

    public boolean eliminar(T dato) {
        Nodo<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(dato)) { // Comparar el dato
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente; // Enlazar el anterior al siguiente
                } else {
                    cabeza = actual.siguiente; // Actualizar la cabeza si es el primer nodo
                }

                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior; // Enlazar el siguiente al anterior
                } else {
                    cola = actual.anterior; // Actualizar la cola si es el último nodo
                }

                return true; // Nodo eliminado
            }

            actual = actual.siguiente; // Mover al siguiente nodo
        }
        return false; // Dato no encontrado
    }

    public int buscar(T dato) {
        Nodo<T> actual = cabeza;
        int posicion = 0;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return posicion; // Retornar la posición del dato encontrado
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1; // Dato no encontrado
    }

    public String unirDatosCabeza() {
        Nodo<T> actual = cabeza;
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append(actual.dato);
            actual = actual.siguiente;
        }
        return sb.toString();
    }

    public String unirDatosCola() {
        Nodo<T> actual = cola;
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append(actual.dato);
            actual = actual.anterior;
        }
        return sb.toString();
    }

    public void unir() {
        System.out.println("Datos desde cabeza:" + unirDatosCabeza());
        System.out.println("Datos desde cola:" + unirDatosCola());
    }

}
