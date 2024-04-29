package view;

import java.awt.Toolkit;
import view.cliente.TelaLoginCliente;
import view.barbearia.TelaLoginBarbearia;

public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        //setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        barber = new javax.swing.JLabel();
        shop = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        btnBarbearia = new css.JPanelArredondadoBarbearias(20);
        logoBarbearia = new javax.swing.JLabel();
        tituloBarbearia = new javax.swing.JLabel();
        btnCliente = new css.JPanelArredondadoBarbearias(20);
        logoCliente = new javax.swing.JLabel();
        tituloCliente = new javax.swing.JLabel();
        Bemvindo = new javax.swing.JLabel();
        selecione = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));
        Esquerda.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Esquerda.setPreferredSize(new java.awt.Dimension(820, 1080));

        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon1-removebg-preview.png"))); // NOI18N

        barber.setBackground(new java.awt.Color(255, 255, 255));
        barber.setFont(new java.awt.Font("Caladea", 0, 80)); // NOI18N
        barber.setForeground(new java.awt.Color(255, 255, 255));
        barber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barber.setText("BARBER");

        shop.setBackground(new java.awt.Color(255, 255, 255));
        shop.setFont(new java.awt.Font("Caladea", 0, 80)); // NOI18N
        shop.setForeground(new java.awt.Color(255, 255, 255));
        shop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shop.setText("SHOP");

        desc.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desc.setText("Transformando estilo em praticidade.");

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE))
                .addContainerGap())
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barber, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(shop, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(255, 255, 255));
        Direita.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Direita.setPreferredSize(new java.awt.Dimension(1100, 1080));
        Direita.setRequestFocusEnabled(false);

        btnBarbearia.setBackground(new java.awt.Color(0, 51, 102));
        btnBarbearia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBarbearia.setMaximumSize(new java.awt.Dimension(550, 600));
        btnBarbearia.setMinimumSize(new java.awt.Dimension(550, 600));
        btnBarbearia.setPreferredSize(new java.awt.Dimension(351, 408));
        btnBarbearia.setRequestFocusEnabled(false);
        btnBarbearia.setVerifyInputWhenFocusTarget(false);

        logoBarbearia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBarbearia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/barbearia.png"))); // NOI18N
        logoBarbearia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoBarbearia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoBarbeariaMouseClicked(evt);
            }
        });

        tituloBarbearia.setFont(new java.awt.Font("Caladea", 0, 45)); // NOI18N
        tituloBarbearia.setForeground(new java.awt.Color(255, 255, 255));
        tituloBarbearia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloBarbearia.setText("Barbearia");

        javax.swing.GroupLayout btnBarbeariaLayout = new javax.swing.GroupLayout(btnBarbearia);
        btnBarbearia.setLayout(btnBarbeariaLayout);
        btnBarbeariaLayout.setHorizontalGroup(
            btnBarbeariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBarbeariaLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(btnBarbeariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoBarbearia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tituloBarbearia, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnBarbeariaLayout.setVerticalGroup(
            btnBarbeariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBarbeariaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(logoBarbearia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloBarbearia, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCliente.setBackground(new java.awt.Color(0, 51, 102));
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.setMaximumSize(new java.awt.Dimension(550, 600));
        btnCliente.setMinimumSize(new java.awt.Dimension(550, 600));
        btnCliente.setRequestFocusEnabled(false);
        btnCliente.setVerifyInputWhenFocusTarget(false);

        logoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homem.png"))); // NOI18N
        logoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoClienteMouseClicked(evt);
            }
        });

        tituloCliente.setFont(new java.awt.Font("Caladea", 0, 45)); // NOI18N
        tituloCliente.setForeground(new java.awt.Color(255, 255, 255));
        tituloCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCliente.setText("Cliente");

        javax.swing.GroupLayout btnClienteLayout = new javax.swing.GroupLayout(btnCliente);
        btnCliente.setLayout(btnClienteLayout);
        btnClienteLayout.setHorizontalGroup(
            btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClienteLayout.createSequentialGroup()
                .addGroup(btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(tituloCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnClienteLayout.setVerticalGroup(
            btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClienteLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(logoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Bemvindo.setBackground(new java.awt.Color(0, 51, 102));
        Bemvindo.setFont(new java.awt.Font("Caladea", 0, 120)); // NOI18N
        Bemvindo.setForeground(new java.awt.Color(0, 51, 102));
        Bemvindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bemvindo.setText("Bem Vindo!");

        selecione.setBackground(new java.awt.Color(0, 51, 102));
        selecione.setFont(new java.awt.Font("Caladea", 1, 43)); // NOI18N
        selecione.setForeground(new java.awt.Color(0, 51, 102));
        selecione.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selecione.setText("Selecione o tipo de usuário abaixo:");

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(btnBarbearia, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addComponent(Bemvindo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selecione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(Bemvindo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selecione, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBarbearia, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(173, 173, 173))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoClienteMouseClicked
        TelaLoginCliente TL = new TelaLoginCliente();
        TL.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoClienteMouseClicked

    private void logoBarbeariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoBarbeariaMouseClicked
        TelaLoginBarbearia TLA = new TelaLoginBarbearia();
        TLA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoBarbeariaMouseClicked


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bemvindo;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel barber;
    private javax.swing.JPanel btnBarbearia;
    private javax.swing.JPanel btnCliente;
    private javax.swing.JLabel desc;
    private javax.swing.JLabel logoBarbearia;
    private javax.swing.JLabel logoCliente;
    private javax.swing.JLabel selecione;
    private javax.swing.JLabel shop;
    private javax.swing.JLabel tituloBarbearia;
    private javax.swing.JLabel tituloCliente;
    // End of variables declaration//GEN-END:variables

    
}
