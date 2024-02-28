package view;


public class TelaPrincipal extends javax.swing.JFrame {

      public TelaPrincipal() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Centro = new javax.swing.JPanel();
        Cima = new javax.swing.JPanel();
        sair = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JLabel();
        barbeariaDuMario = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        barbeariaImperius = new javax.swing.JPanel();
        nome1 = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        barbeariaMenSpace = new javax.swing.JPanel();
        nome2 = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Centro.setBackground(new java.awt.Color(206, 230, 255));

        Cima.setBackground(new java.awt.Color(29, 93, 183));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sair2.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair)
                .addGap(23, 23, 23))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(sair)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(122, 188, 255));

        jPanel1.setBackground(new java.awt.Color(206, 230, 255));

        jLabel1.setBackground(new java.awt.Color(29, 93, 183));
        jLabel1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 93, 183));
        jLabel1.setText("MEUS AGENDAMENTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon2_TESTE.png"))); // NOI18N

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_user.png"))); // NOI18N

        nomeUsuario.setFont(new java.awt.Font("Mongolian Baiti", 0, 24)); // NOI18N
        nomeUsuario.setForeground(new java.awt.Color(0, 51, 204));
        nomeUsuario.setText("Olá, GILDEMBERG VIEIRA LOPES");

        barbeariaDuMario.setBackground(new java.awt.Color(122, 188, 255));
        barbeariaDuMario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        nome.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        nome.setForeground(new java.awt.Color(29, 93, 183));
        nome.setText("Barbearia Du' Mario");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_du_mario.jpg"))); // NOI18N

        javax.swing.GroupLayout barbeariaDuMarioLayout = new javax.swing.GroupLayout(barbeariaDuMario);
        barbeariaDuMario.setLayout(barbeariaDuMarioLayout);
        barbeariaDuMarioLayout.setHorizontalGroup(
            barbeariaDuMarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbeariaDuMarioLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 779, Short.MAX_VALUE)
                .addComponent(logo)
                .addContainerGap())
        );
        barbeariaDuMarioLayout.setVerticalGroup(
            barbeariaDuMarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        barbeariaImperius.setBackground(new java.awt.Color(122, 188, 255));
        barbeariaImperius.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        nome1.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        nome1.setForeground(new java.awt.Color(29, 93, 183));
        nome1.setText("Imperius Salon");

        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_du_mario.jpg"))); // NOI18N

        javax.swing.GroupLayout barbeariaImperiusLayout = new javax.swing.GroupLayout(barbeariaImperius);
        barbeariaImperius.setLayout(barbeariaImperiusLayout);
        barbeariaImperiusLayout.setHorizontalGroup(
            barbeariaImperiusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbeariaImperiusLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo1)
                .addContainerGap())
        );
        barbeariaImperiusLayout.setVerticalGroup(
            barbeariaImperiusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbeariaImperiusLayout.createSequentialGroup()
                .addGroup(barbeariaImperiusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbeariaMenSpace.setBackground(new java.awt.Color(122, 188, 255));
        barbeariaMenSpace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        nome2.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        nome2.setForeground(new java.awt.Color(29, 93, 183));
        nome2.setText("Men Space");

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        javax.swing.GroupLayout barbeariaMenSpaceLayout = new javax.swing.GroupLayout(barbeariaMenSpace);
        barbeariaMenSpace.setLayout(barbeariaMenSpaceLayout);
        barbeariaMenSpaceLayout.setHorizontalGroup(
            barbeariaMenSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbeariaMenSpaceLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nome2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo2))
        );
        barbeariaMenSpaceLayout.setVerticalGroup(
            barbeariaMenSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbeariaMenSpaceLayout.createSequentialGroup()
                .addGroup(barbeariaMenSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Mongolian Baiti", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icone_local.png"))); // NOI18N
        jLabel3.setText("Paulo Afonso - BA");

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(img)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeUsuario)
                            .addComponent(jLabel3)))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barbeariaDuMario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbeariaImperius, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbeariaMenSpace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 564, Short.MAX_VALUE)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(img))
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(nomeUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(57, 57, 57)
                        .addComponent(barbeariaDuMario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(barbeariaImperius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(barbeariaMenSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        this.dispose();
        new TelaLogin().setVisible(true);
    }//GEN-LAST:event_sairMouseClicked

        public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel barbeariaDuMario;
    private javax.swing.JPanel barbeariaImperius;
    private javax.swing.JPanel barbeariaMenSpace;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nome1;
    private javax.swing.JLabel nome2;
    private javax.swing.JLabel nomeUsuario;
    private javax.swing.JLabel sair;
    // End of variables declaration//GEN-END:variables
}
