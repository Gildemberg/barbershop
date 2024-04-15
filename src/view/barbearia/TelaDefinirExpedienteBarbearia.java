
package view.barbearia;

import com.raven.datechooser.SelectedDate;
import controller.ExpedienteController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TransfCod;

public class TelaDefinirExpedienteBarbearia extends javax.swing.JFrame {
    
    int CODBARBEARIA;
    
    public TelaDefinirExpedienteBarbearia() {
        initComponents();
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){
        this.CODBARBEARIA = CODBARBEARIA;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new css.FundoGradiente(0, 51, 102, 0, 0, 0, 0, 0, 1500, 100);
        icon = new javax.swing.JLabel();
        txtRegra = new javax.swing.JLabel();
        txtRegra5 = new javax.swing.JLabel();
        Direita = new css.FundoGradiente(0, 191, 255, 65, 105, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        Agendamento = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        calendario = new com.raven.datechooser.DateChooser();
        btnAgendar = new javax.swing.JButton();
        Agendamento1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Definir Expediente");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        txtRegra.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra.setText("ATENÇÃO!");
        txtRegra.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra5.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra5.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra5.setText("<html><div style='text-align: justify;'>POR PADRÃO AO CADASTRAR SUA BARBEARIA NO NOSSO SITEMA, É DEFINIDO EXPEDIENTE PARA TODOS OS DIAS DO ANO, CASO QUEIRA REMOVER ALGUM DIA ESPECÍFICO, É SÓ SELECIONAR AO LADO.</div></html>");
        txtRegra5.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtRegra, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                        .addGap(0, 302, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(icon)
                .addGap(18, 18, 18)
                .addComponent(txtRegra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        Agendamento.setText("DEFINA O DIA QUE NÃO");

        Data.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Data.setForeground(new java.awt.Color(255, 255, 255));
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data.setText("DATA");

        calendario.setForeground(new java.awt.Color(0, 51, 102));
        calendario.setToolTipText("");
        calendario.setPreferredSize(new java.awt.Dimension(500, 500));

        btnAgendar.setBackground(new java.awt.Color(0, 51, 102));
        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar.setText("DEFINIR");
        btnAgendar.setBorderPainted(false);
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        Agendamento1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        Agendamento1.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Agendamento1.setText("HAVERÁ EXPEDIENTE!");

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(0, 117, Short.MAX_VALUE)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(sair)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                        .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131)))
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(237, 237, 237))))
                    .addComponent(Agendamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair)
                .addGap(87, 87, 87)
                .addComponent(Agendamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Agendamento1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(Data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(435, 435, 435))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TransfCod TC = new TransfCod();
        TC.setCod(CODBARBEARIA);
        TP.receberCodBarbearia(TC);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sairMouseClicked

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        try {
            SelectedDate d = calendario.getSelectedDate();
            String dataString = d.getDay()+"-"+d.getMonth()+"-"+d.getYear(); //Pegando a data
            
            //convertendo a String data para DATE
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
            Date data = new Date(dataFormatada.parse(dataString).getTime());
            
            ExpedienteController exped = new ExpedienteController();
            exped.verificarExpedienteNoBanco(data, CODBARBEARIA);
        } catch (ParseException ex) {
            Logger.getLogger(TelaDefinirExpedienteBarbearia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAgendarActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDefinirExpedienteBarbearia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaDefinirExpedienteBarbearia().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agendamento;
    private javax.swing.JLabel Agendamento1;
    private javax.swing.JLabel Data;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JButton btnAgendar;
    private com.raven.datechooser.DateChooser calendario;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel sair;
    private javax.swing.JLabel txtRegra;
    private javax.swing.JLabel txtRegra5;
    // End of variables declaration//GEN-END:variables
}
