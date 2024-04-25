package view.barbearia;

import com.raven.datechooser.SelectedDate;
import controller.ExpedienteController;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Expediente;

public class TelaDefinirExpediente extends javax.swing.JFrame {

    int CODBARBEARIA;
    ExpedienteController expedienteController = new ExpedienteController();
    Expediente modelExpediente = new Expediente();
    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
    SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public TelaDefinirExpediente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){
        this.CODBARBEARIA = CODBARBEARIA;
    }
    
    public void definirExpediente(){
        try {
            String dataInicialString = txtDataInicial.getText(); 
            String dataFinalString = txtDataFinal.getText(); 
            
            String horaInicialString = txtHoraIni.getText()+":"+txtMinutoIni.getText(); 
            String horaFinalString = txtHoraFim.getText()+":"+txtMinutoFim.getText(); 
            
            if ("  :  ".equals(horaInicialString) || "  :  ".equals(horaFinalString)) {
                JOptionPane.showMessageDialog(null, "Preencha o horário", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return;
            }
            if ("  /  /    ".equals(dataInicialString) || "  /  /    ".equals(dataFinalString)) {
                JOptionPane.showMessageDialog(null, "Preencha a data", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return;
            }
            
            //convertendo a String data para DATE
            Date dataInicial = new Date(dataFormatada.parse(dataInicialString).getTime());
            Date dataFinal = new Date(dataFormatada.parse(dataFinalString).getTime());
            
            Date HorarioInicial = new Date(horaFormatada.parse(horaInicialString).getTime()); //TIME DATE
            Time horaInicial = new Time(HorarioInicial.getTime()); //Pegando o TIME da DATE
            
            Date HorarioFinal = new Date(horaFormatada.parse(horaFinalString).getTime()); //TIME DATE
            Time horaFinal = new Time(HorarioFinal.getTime()); //Pegando o TIME da DATE
            
            modelExpediente.setCodbarbearia(CODBARBEARIA);
            modelExpediente.setDataInicial(dataInicial);
            modelExpediente.setDataFinal(dataFinal);
            modelExpediente.setHoraInicial(horaInicial);
            modelExpediente.setHoraFinal(horaFinal);
            
            
            if(expedienteController.controller(modelExpediente)){
                txtDataInicial.setText("");
                txtDataFinal.setText("");
                txtHoraIni.setText("");
                txtMinutoIni.setText("");
                txtHoraFim.setText("");
                txtMinutoFim.setText("");
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(TelaAlterarExpediente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new css.FundoGradiente(0, 51, 102, 0, 0, 0, 0, 0, 1500, 100);
        icon = new javax.swing.JLabel();
        txtRegra5 = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        btnDefinir = new javax.swing.JButton();
        txtDataInicial = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        Data1 = new javax.swing.JLabel();
        Direita = new css.FundoGradiente(0, 191, 255, 65, 105, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        horarioInicio = new javax.swing.JLabel();
        txtHoraIni = new css.ArrendondarBordas();
        doispontos = new javax.swing.JLabel();
        txtMinutoIni = new css.ArrendondarBordas();
        horarioFim = new javax.swing.JLabel();
        txtHoraFim = new css.ArrendondarBordas();
        doispontos1 = new javax.swing.JLabel();
        txtMinutoFim = new css.ArrendondarBordas();
        txtRegra6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Alterar Expediente");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        txtRegra5.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        txtRegra5.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra5.setText("<html><div style='text-align: justify;'>DEFINA O PERÍODO QUE HAVERÁ EXPEDIENTE</div></html>");
        txtRegra5.setBorder(new javax.swing.border.MatteBorder(null));

        Data.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Data.setForeground(new java.awt.Color(255, 255, 255));
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data.setText("DATA INICIAL");

        btnDefinir.setBackground(new java.awt.Color(0, 153, 255));
        btnDefinir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDefinir.setForeground(new java.awt.Color(255, 255, 255));
        btnDefinir.setText("DEFINIR ");
        btnDefinir.setBorderPainted(false);
        btnDefinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefinirActionPerformed(evt);
            }
        });

        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Data1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Data1.setForeground(new java.awt.Color(255, 255, 255));
        Data1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data1.setText("DATA FINAL");

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                        .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                        .addGap(0, 110, Short.MAX_VALUE)
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(txtDataInicial))
                                .addGap(125, 125, 125)
                                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(Data1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(207, 207, 207))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                                .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))))))
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(btnDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(icon)
                .addGap(211, 211, 211)
                .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Data)
                    .addComponent(Data1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(btnDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        Direita.setBackground(new java.awt.Color(0, 153, 255));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saida.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        horarioInicio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        horarioInicio.setForeground(new java.awt.Color(255, 255, 255));
        horarioInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horarioInicio.setText("HORÁRIO DE INÍCIO DO EXPEDIENTE");

        txtHoraIni.setBorder(null);
        txtHoraIni.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHoraIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraIni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraIni.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        doispontos.setFont(new java.awt.Font("Dialog", 0, 41)); // NOI18N
        doispontos.setForeground(new java.awt.Color(255, 255, 255));
        doispontos.setText(":");

        txtMinutoIni.setBorder(null);
        txtMinutoIni.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtMinutoIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMinutoIni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMinutoIni.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        horarioFim.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        horarioFim.setForeground(new java.awt.Color(255, 255, 255));
        horarioFim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horarioFim.setText("HORÁRIO DE FIM DO EXPEDIENTE");

        txtHoraFim.setBorder(null);
        txtHoraFim.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHoraFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraFim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraFim.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        doispontos1.setFont(new java.awt.Font("Dialog", 0, 41)); // NOI18N
        doispontos1.setForeground(new java.awt.Color(255, 255, 255));
        doispontos1.setText(":");

        txtMinutoFim.setBorder(null);
        txtMinutoFim.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtMinutoFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMinutoFim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMinutoFim.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        txtRegra6.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        txtRegra6.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra6.setText("<html><div style='text-align: justify;'> DEFINA O HORÁRIO PADRÃO</div></html>");
        txtRegra6.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horarioFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(horarioInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(0, 631, Short.MAX_VALUE)
                                .addComponent(sair))))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doispontos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMinutoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(txtHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doispontos1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMinutoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(txtRegra6, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair)
                .addGap(164, 164, 164)
                .addComponent(txtRegra6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(horarioInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doispontos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinutoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(horarioFim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doispontos1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinutoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnDefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefinirActionPerformed
        definirExpediente();
    }//GEN-LAST:event_btnDefinirActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TP.receberCodBarbearia(CODBARBEARIA);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sairMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDefinirExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaDefinirExpediente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Data1;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JButton btnDefinir;
    private javax.swing.JLabel doispontos;
    private javax.swing.JLabel doispontos1;
    private javax.swing.JLabel horarioFim;
    private javax.swing.JLabel horarioInicio;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel sair;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    private javax.swing.JFormattedTextField txtHoraFim;
    private javax.swing.JFormattedTextField txtHoraIni;
    private javax.swing.JFormattedTextField txtMinutoFim;
    private javax.swing.JFormattedTextField txtMinutoIni;
    private javax.swing.JLabel txtRegra5;
    private javax.swing.JLabel txtRegra6;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
