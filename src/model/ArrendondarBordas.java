package model;




import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class ArrendondarBordas extends JFormattedTextField {

    public ArrendondarBordas() {
        this("");
    }

    public ArrendondarBordas(String mask) {
        super();
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Ajusta o espaçamento interno
        setOpaque(false); // Torna o fundo transparente para que o painel pai possa definir o plano de fundo
        setForeground(Color.BLACK); // Define a cor do texto
        setFont(new Font("Arial", Font.PLAIN, 14)); // Define a fonte e o tamanho do texto

        try {
            MaskFormatter formatter = new MaskFormatter(mask);
            setFormatterFactory(new DefaultFormatterFactory(formatter));
        } catch (ParseException ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Define o raio dos cantos
        super.paintComponent(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.white); // Define a cor da borda
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Define o raio dos cantos
        g2d.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        ArrendondarBordas roundedTextField = new ArrendondarBordas("###.###.###-##");
        roundedTextField.setPreferredSize(new Dimension(150, 30));

        frame.add(roundedTextField);

        frame.pack();
        frame.setVisible(true);
    }
}
