/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class Proyecto1 {

    private static Acumulador acu = new Acumulador();
    /**
     * @param args the command line arguments
     */
    public static String mostrarMenu() {
        String opciones[] = {
            "Salir",
            "Mostrar el acumulador",
            "Agregar Valor",
            "Undo",
            "Redo",
            "Estado"
        };
        String menu = "";
        int i = 0;
        for (String o : opciones) {
            menu += (i++) + ". " + o + "\n";
        }
        return menu;
    }

    public static void main(String[] args) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mostrarMenu());
            try {
                int option = Integer.parseInt(input);

                switch (option) {
                    case 0:
                        return;
                    case 1:
                        int acumulador = acu.getTotal();
                        JOptionPane.showMessageDialog(null, "El valor del acumulador es: " + acumulador);
                        break;
                    case 2:
                        manejarOperador();
                        break;
                    case 3:
                        manejarUndo();
                        break;
                    case 4:
                        manejarRedo();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");
            }
        }
    }

    private static void manejarUndo() {
        acu.undo();
    }

    private static void manejarRedo() {
        acu.redo();
    }

    private static void manejarOperador() {
        String input = JOptionPane.showInputDialog("Ingrese un valor positivo o negativo");
        int valor = Integer.parseInt(input);
        acu.aplicar(valor);
    }
}
