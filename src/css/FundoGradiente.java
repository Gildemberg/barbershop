
package css;
import javax.swing.*;
import java.awt.*;

public class FundoGradiente extends JPanel {

    private final Color startColor;
    private final Color endColor;
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public FundoGradiente(int startRed, int startGreen, int startBlue, int endRed, int endGreen, int endBlue, int startX, int startY, int endX, int endY) {
        this.startColor = new Color(startRed, startGreen, startBlue);
        this.endColor = new Color(endRed, endGreen, endBlue);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // Define o gradiente
        GradientPaint gradientPaint = new GradientPaint(startX, startY, startColor, endX, endY, endColor);
        g2d.setPaint(gradientPaint);

        // Desenha o gradiente no fundo do painel
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.dispose();
    }
}
