/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class Proyecto1 {

    private static Acumulador acu = new Acumulador();
    /**
     //* @param args the command line arguments
     */
    public static String mostrarMenu() {
        String opciones[] = {
            "Salir",
            "Mostrar el acumulador",
            "Agregar Valor", //numero negativo o positivo
            "Undo", //deshacer
            "Redo", //rehacer
            "Estado" // mostrar pila
        };
        String menu = "";
        int i = 0;
        for (String o : opciones) {
            menu += (i++) + ". " + o + "\n";
        }
        return menu;
    }
     // pide una opcion y llama al metodo correspondiente 
    public static void main(String[] args) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mostrarMenu(),
                    "Menu Acumuldor", JOptionPane.PLAIN_MESSAGE);
            
            if( input == null){
                return;
            }
            try {
                int option = Integer.parseInt(input.trim());

                switch (option) {
                    case 0:
                        return;
                    case 1: //muestra el acumulador
                        int acumulador = acu.getTotal();
                        JOptionPane.showMessageDialog(null, 
                                "El valor del acumulador es: " + acumulador);
                        break;
                    case 2: // lo agrega
                        manejarOperador();
                        break;
                    case 3: // undo
                        manejarUndo();
                        break;
                    case 4: //redo
                        manejarRedo();
                        break;
                    case 5: //estado
                        acu.estado();
                    default:
                        JOptionPane.showMessageDialog(null,
                                "Opcion no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Debe ingresar un valor numerico valido");
            }
        }
    }

    private static void manejarUndo() {
        acu.undo();
        JOptionPane.showMessageDialog(null,
                "Undo ejecutado.\nTotal actual: " + acu.getTotal());
    }

    private static void manejarRedo() {
        acu.redo();
        JOptionPane.showMessageDialog(null,
                "Redo ejecutado.\nTotal actual: " + acu.getTotal());
    }

    private static void manejarOperador() {
        String input = JOptionPane.showInputDialog("Ingrese un valor positivo o negativo");
        
        if(input == null){
            return;
        }
        try {
        int valor = Integer.parseInt(input.trim());
        acu.aplicar(valor);
        JOptionPane.showMessageDialog(null, "Operación aplicada.\nTotal actual: " + acu.getTotal());
        
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }
}
