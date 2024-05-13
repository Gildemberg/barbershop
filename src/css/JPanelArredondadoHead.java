package css;

import javax.swing.*;
import java.awt.*;

public class JPanelArredondadoHead extends JPanel {
    private final int radius;

    public JPanelArredondadoHead(int radius) {
        this.radius = radius;
        setOpaque(false); // Garante que o JPanel seja transparente para que o efeito da borda arredondada seja visível
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Criar um retângulo arredondado apenas nas bordas inferiores
        int width = getWidth();
        int height = getHeight();
        g2.fillRoundRect(0, 0, width - 1, height - 1, radius, radius); // Criar um retângulo completo arredondado
        
        // Criar uma área retangular para cobrir a parte superior (para criar um efeito de bordas planas)
        g2.setColor(getBackground());
        g2.fillRect(0, 0, width - 1, height - radius); // Cobrir a parte superior para manter bordas planas
        
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        Insets insets = getInsets();
        return new Dimension(80 + insets.left + insets.right, 80 + insets.top + insets.bottom);
    }
}