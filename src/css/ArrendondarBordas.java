package css;

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
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fillRoundRect(-1, -1, getWidth() - 0, getHeight() - 0, 15, 15); // Define o raio dos cantos
        super.paintComponent(g2d);
        g2d.dispose();
    }
}
