package css;

import javax.swing.*;
import java.awt.*;

public class CustomScrollPaneConfigurator {

    public static void applyCustomizations(JScrollPane scrollPane) {
        // Customizar a borda
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

        // Ajustar o comportamento da barra de rolagem
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        JScrollBar horizontalBar = scrollPane.getHorizontalScrollBar();
        verticalBar.setBackground(Color.BLACK); // Cor preta
        verticalBar.setForeground(Color.BLACK); // Cor do "thumb" da barra
        verticalBar.setUnitIncrement(16); // Unidade de incremento para rolar
        verticalBar.setBorder(BorderFactory.createEmptyBorder()); // Borda quadrada
        verticalBar.setPreferredSize(new Dimension(12, Integer.MAX_VALUE)); // Largura da barra de rolagem

        // Configurações para a barra de rolagem horizontal (opcional)
        horizontalBar.setBackground(Color.BLACK);
        horizontalBar.setForeground(Color.WHITE);
        horizontalBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 12));

        // Definir a política de rolagem
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Sempre visível
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Conforme necessário
    }
}
