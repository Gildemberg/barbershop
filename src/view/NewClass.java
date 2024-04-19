
package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class NewClass extends JFrame {

    public NewClass() {
        setTitle("Janela Responsiva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adiciona um layout manager (exemplo com BorderLayout)
        setLayout(new BorderLayout());
        
        // Adiciona alguns componentes
        JLabel label = new JLabel("Meu Label");
        JButton button = new JButton("Meu Botão");
        
        // Adiciona os componentes ao JFrame
        add(label, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);
        
        // Adiciona um listener de redimensionamento
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Lógica para ajustar os componentes aqui
            }
        });
        
        setSize(400, 300); // Define um tamanho inicial
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NewClass::new);
    }
}
