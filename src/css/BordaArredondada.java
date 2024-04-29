package css;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BordaArredondada implements Border {
    private final Color cor;
    private final int espessura;
    private final int raio;

    public BordaArredondada(Color cor, int espessura, int raio) {
        this.cor = cor;
        this.espessura = espessura;
        this.raio = raio;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int largura, int altura) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(cor);
        g2.setStroke(new BasicStroke(espessura));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha a borda arredondada
        int ajuste = espessura / 2; // Ajusta para que a borda seja desenhada corretamente
        g2.drawRoundRect(x + ajuste, y + ajuste, largura - espessura, altura - espessura, raio, raio);

        g2.dispose(); // Limpa o contexto gráfico
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(espessura, espessura, espessura, espessura);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}

