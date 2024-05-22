package view.cliente;

public class TelaAjudaCliente extends javax.swing.JFrame {
    int CODCLIENTE;
    public TelaAjudaCliente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
    }
    
    public void receberCodBarbearia(int CODCLIENTE){
        this.CODCLIENTE = CODCLIENTE;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        Centro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 150));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));
        Cima.setName(""); // NOI18N

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar-azul.png"))); // NOI18N
        btnVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVoltar.setBorderPainted(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Caladea", 1, 90)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Ajuda");
        titulo.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addComponent(icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(CimaLayout.createSequentialGroup()
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon)
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Centro.setBackground(new java.awt.Color(255, 255, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1920, 960));
        Centro.setMinimumSize(new java.awt.Dimension(1920, 960));

        jLabel1.setBackground(new java.awt.Color(0, 51, 102));
        jLabel1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajuda_barbearias.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setBackground(new java.awt.Color(0, 51, 102));
        jLabel2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("<html><div style='text-align: justify;'><b>Passo 1:</b> Escolha uma barbearia e clique nela</div></html>");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setBackground(new java.awt.Color(0, 51, 102));
        jLabel3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("<html><div style='text-align: justify;'><b>Passo 2:</b> Escolha um serviço oferecido pela barbearia</div></html>");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel7.setBackground(new java.awt.Color(0, 51, 102));
        jLabel7.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("<html><div style='text-align: justify;'><b>Passo 3:</b> Selecione a data que deseja agendar</div></html>");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel8.setBackground(new java.awt.Color(0, 51, 102));
        jLabel8.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("<html><div style='text-align: justify;'><b>Passo 5:</b> Ao concluir o agendamento o sistema retornará para a Tela Princial</div></html>");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel9.setBackground(new java.awt.Color(0, 51, 102));
        jLabel9.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("AGENDAR HORÁRIO");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel15.setBackground(new java.awt.Color(0, 51, 102));
        jLabel15.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 102));
        jLabel15.setText("<html><div style='text-align: justify;'><b>Passo 1:</b> Verifique em \"MEUS AGENDAMENTOS\" um<br> horário que deseja alterar ou cancelar</div></html>");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel27.setBackground(new java.awt.Color(0, 51, 102));
        jLabel27.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 102));
        jLabel27.setText("<html><div style='text-align: justify;'><b>Passo 4:</b> Selecione um horário disponível no dia</div></html>");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel28.setBackground(new java.awt.Color(0, 51, 102));
        jLabel28.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 51, 102));
        jLabel28.setText("<html><div style='text-align: justify;'><b>Passo 6:</b> Verifique em \"MEUS AGENDAMENTOS\" se agendamento foi registrado</div></html>");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel5.setBackground(new java.awt.Color(0, 51, 102));
        jLabel5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajuda_agendamento1.png"))); // NOI18N
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel6.setBackground(new java.awt.Color(0, 51, 102));
        jLabel6.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajuda_agendamento2.png"))); // NOI18N
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel16.setBackground(new java.awt.Color(0, 51, 102));
        jLabel16.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("ALTERAR OU CANCELAR AGENDAMENTO");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jSeparator1.setBackground(new java.awt.Color(0, 51, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 102));
        jSeparator1.setPreferredSize(new java.awt.Dimension(1920, 50));

        jLabel10.setBackground(new java.awt.Color(0, 51, 102));
        jLabel10.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajuda_agendamento2.png"))); // NOI18N
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel17.setBackground(new java.awt.Color(0, 51, 102));
        jLabel17.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 102));
        jLabel17.setText("<html><div style='text-align: justify;'><b>Passo 2:</b> Clique em alterar ou cancelar</div></html>");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel11.setBackground(new java.awt.Color(0, 51, 102));
        jLabel11.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel12.setBackground(new java.awt.Color(0, 51, 102));
        jLabel12.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel13.setBackground(new java.awt.Color(0, 51, 102));
        jLabel13.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajuda_reagendamento.png"))); // NOI18N
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setBackground(new java.awt.Color(0, 51, 102));
        jLabel4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("<html><div style='text-align: justify;'><b>Passo 3:</b> Escolha um serviço oferecido pela barbearia</div></html>");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel14.setBackground(new java.awt.Color(0, 51, 102));
        jLabel14.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setText("<html><div style='text-align: justify;'><b>Passo 4:</b> Selecione a data que deseja agendar</div></html>");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel29.setBackground(new java.awt.Color(0, 51, 102));
        jLabel29.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 51, 102));
        jLabel29.setText("<html><div style='text-align: justify;'><b>Passo 5:</b> Selecione um horário disponível no dia</div></html>");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(117, 117, 117)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CentroLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(62, 62, 62))
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(CentroLayout.createSequentialGroup()
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipalCliente TP = new TelaPrincipalCliente();
        TP.receberCodCliente(CODCLIENTE);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAjudaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaAjudaCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
