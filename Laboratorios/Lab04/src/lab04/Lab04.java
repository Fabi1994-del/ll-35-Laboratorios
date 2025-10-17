package lab04;

public class Lab04 {
    public static void main(String[] args) {
        Pila<Carro> pilaDeCarros = new Pila<>();

        // Agregar carros a la pila (modelos más recientes)
        pilaDeCarros.push(new Carro("Nissan", "Frontier", 2022));
        System.out.println("Añadido: Nissan Frontier (2022) → " + pilaDeCarros);

        pilaDeCarros.push(new Carro("Toyota", "Hilux", 2024));
        System.out.println("Añadido: Toyota Hilux (2024) → " + pilaDeCarros);

        pilaDeCarros.push(new Carro("Ford", "Ranger", 2023));
        System.out.println("Añadido: Ford Ranger (2023) → " + pilaDeCarros);

        pilaDeCarros.push(new Carro("Chevrolet", "Colorado", 2021));
        System.out.println("Añadido: Chevrolet Colorado (2021) → " + pilaDeCarros);

        pilaDeCarros.push(new Carro("Mazda", "BT-50", 2020));
        System.out.println("Añadido: Mazda BT-50 (2020) → " + pilaDeCarros);

        // pop() x2
        try {
            Carro removido1 = pilaDeCarros.pop();
            System.out.println("Removido: " + removido1);

            Carro removido2 = pilaDeCarros.pop();
            System.out.println("Removido: " + removido2);
        } catch (Exception e) {
            System.out.println("Error al hacer pop: " + e.getMessage());
        }

        // peek()
        try {
            Carro enLaCima = pilaDeCarros.peek();
            System.out.println("Carro en la cima: " + enLaCima);
        } catch (Exception e) {
            System.out.println("Error al hacer peek: " + e.getMessage());
        }

        // tamaño final
        System.out.println("Tamaño final de la pila: " + pilaDeCarros.size());

        // pop() con pila vacía (demostración de excepción)
        try {
            while (true) {
                System.out.println("Removido: " + pilaDeCarros.pop());
            }
        } catch (Exception e) {
            System.out.println("Intento de pop en pila vacía: " + e.getClass().getSimpleName());
        }
    }
}


