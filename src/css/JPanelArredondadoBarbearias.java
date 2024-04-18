package css;

import javax.swing.*;
import java.awt.*;

public class JPanelArredondadoBarbearias extends JPanel {
    private final int radius;

    public JPanelArredondadoBarbearias(int radius) {
        this.radius = radius;
        setOpaque(false); // Garante que o JPanel seja transparente para que o efeito da borda arredondada seja visível
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        Insets insets = getInsets();
        return new Dimension(60 + insets.left + insets.right, 60 + insets.top + insets.bottom);
    }
}