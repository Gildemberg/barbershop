
package view;

import controller.AgendamentoController;
import dao.AgendamentoDAO;
import dao.CalendarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Agendamento;
import model.Calendario;
import model.TransfCod;

public class TelaAgendamento extends javax.swing.JFrame {

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
        titulo5 = new javax.swing.JLabel();
        sair5 = new javax.swing.JLabel();
        dateChooser6 = new com.raven.datechooser.DateChooser();
        Agendar5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        Direita.setBackground(new java.awt.Color(0, 153, 255));

        titulo5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        titulo5.setForeground(new java.awt.Color(255, 255, 255));
        titulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo5.setText("AGENDAR HORÁRIO");

        sair5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sair2.png"))); // NOI18N
        sair5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sair5MouseClicked(evt);
            }
        });

        dateChooser6.setForeground(new java.awt.Color(0, 51, 102));
        dateChooser6.setPreferredSize(new java.awt.Dimension(500, 500));

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

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(sair5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(dateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(titulo5)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(Agendar5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251))))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair5)
                .addGap(46, 46, 46)
                .addComponent(titulo5)
                .addGap(42, 42, 42)
                .addComponent(dateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 609, Short.MAX_VALUE)
                .addComponent(Agendar5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
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

    private void sair5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sair5MouseClicked
        this.setVisible(false);
        new TelaPrincipal().setVisible(true);
    }//GEN-LAST:event_sair5MouseClicked

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
    private javax.swing.JButton Agendar1;
    private javax.swing.JButton Agendar2;
    private javax.swing.JButton Agendar3;
    private javax.swing.JButton Agendar4;
    private javax.swing.JButton Agendar5;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Direita2;
    private javax.swing.JPanel Direita3;
    private javax.swing.JPanel Direita4;
    private javax.swing.JPanel Direita5;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JPanel Esquerda1;
    private javax.swing.JPanel Esquerda2;
    private javax.swing.JPanel Esquerda3;
    private javax.swing.JPanel Esquerda4;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private com.raven.datechooser.DateChooser dateChooser4;
    private com.raven.datechooser.DateChooser dateChooser5;
    private com.raven.datechooser.DateChooser dateChooser6;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel sair1;
    private javax.swing.JLabel sair2;
    private javax.swing.JLabel sair3;
    private javax.swing.JLabel sair4;
    private javax.swing.JLabel sair5;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel titulo4;
    private javax.swing.JLabel titulo5;
    // End of variables declaration//GEN-END:variables
}
