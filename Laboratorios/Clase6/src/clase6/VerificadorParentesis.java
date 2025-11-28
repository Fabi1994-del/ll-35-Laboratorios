/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase6;

/**
 *
 * @author fbarg
 */
import java.util.Stack;

public class VerificadorParentesis {
    public static boolean sonBalanceados(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (pila.isEmpty()) return false;
                char top = pila.pop();
                if (!esParentesisCorrespondiente(top, c)) return false;
            }
        }

        return pila.isEmpty();
    }

    private static boolean esParentesisCorrespondiente(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '{' && cierre == '}') ||
               (apertura == '[' && cierre == ']');
    }

    public static void main(String[] args) {
        String[] expresiones = { "{[()])}" };

        for (String expresion : expresiones) {
            System.out.println("La expresión \"" + expresion + "\" es balanceada: " + sonBalanceados(expresion));
        }
    }
}
