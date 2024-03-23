
package view;

import controller.AgendamentoController;
import dao.AgendamentoDAO;
import dao.CalendarioDAO;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Agendamento;
import model.Calendario;
import model.TransfCod;

public class TelaAgendamento extends javax.swing.JFrame{

    int COD_USR, COD_EMP;
    
    public void receberCodEmp(TransfCod TCE){
        int cod = TCE.getCod();
    }
    public TelaAgendamento() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
    }
    
    public void transferirCodUsr(TransfCod TCU){
        COD_USR = TCU.getCod();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        sair = new javax.swing.JLabel();
        Agendamento = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        calendario = new com.raven.datechooser.DateChooser();
        Agendar5 = new javax.swing.JButton();
        txtHora = new model.ArrendondarBordas();
        txtMinuto = new model.ArrendondarBordas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        Direita.setBackground(new java.awt.Color(0, 153, 255));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sair2.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        Agendamento.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        Agendamento.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Agendamento.setText("AGENDAMENTO");

        Hora.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Hora.setForeground(new java.awt.Color(255, 255, 255));
        Hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Hora.setText("HORA");

        Data.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Data.setForeground(new java.awt.Color(255, 255, 255));
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data.setText("DATA");

        calendario.setForeground(new java.awt.Color(0, 51, 102));
        calendario.setToolTipText("");
        calendario.setPreferredSize(new java.awt.Dimension(500, 500));

        Agendar5.setBackground(new java.awt.Color(0, 51, 102));
        Agendar5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Agendar5.setForeground(new java.awt.Color(255, 255, 255));
        Agendar5.setText("AGENDAR");
        Agendar5.setBorderPainted(false);
        Agendar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agendar5ActionPerformed(evt);
            }
        });

        txtHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtHora.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        txtMinuto.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtMinuto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMinuto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMinuto.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(sair)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(Agendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(Hora)
                                .addGap(216, 216, 216)))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(Agendar5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237))))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair)
                .addGap(87, 87, 87)
                .addComponent(Agendamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(Hora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addComponent(Data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(Agendar5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(449, 449, 449)
                .addComponent(icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 557, Short.MAX_VALUE)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Direita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(icon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Tela de Agendamento");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        this.setVisible(false);
        new TelaPrincipal().setVisible(true);
    }//GEN-LAST:event_sairMouseClicked

    private void Agendar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agendar5ActionPerformed

    }//GEN-LAST:event_Agendar5ActionPerformed

    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agendamento;
    private javax.swing.JButton Agendar5;
    private javax.swing.JLabel Data;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JLabel Hora;
    private com.raven.datechooser.DateChooser calendario;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel sair;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JFormattedTextField txtMinuto;
    // End of variables declaration//GEN-END:variables
}
