/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase12;

/**
 *
 * @author fbarg
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TorresFrame extends JFrame implements ActionListener {
    private JButton resolverButton;
    private JTextField numDiscosField;
    
    public TorresFrame() {
        setTitle("Torres de Hanoi");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        numDiscosField = new JTextField(10);
        resolverButton = new JButton("Resolver");
        
        resolverButton.addActionListener(this);
        
        panel.add(new JLabel("Número de discos:"));
        panel.add(numDiscosField);
        panel.add(resolverButton);
        
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = Integer.parseInt(numDiscosField.getText());
        moverDiscos(n, 'A', 'C', 'B');
    }

    public static void moverDiscos(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco de " + origen + " a " + destino);
            // Aquí se puede agregar lógica para actualizar la interfaz gráfica
        } else {
            moverDiscos(n - 1, origen, auxiliar, destino);
            System.out.println("Mover disco de " + origen + " a " + destino);
            // Actualizar la interfaz gráfica aquí también
            moverDiscos(n - 1, auxiliar, destino, origen);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TorresFrame frame = new TorresFrame();
            frame.setVisible(true);
        });
    }
}
