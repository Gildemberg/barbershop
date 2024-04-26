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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Expediente;

public class TelaAlterarExpediente extends javax.swing.JFrame {
    
    int CODBARBEARIA;
    Expediente modelExpediente = new Expediente();
    ExpedienteController expedienteController = new ExpedienteController();
    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
    
    public TelaAlterarExpediente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
        txtHoraIni.getDocument().addDocumentListener(new DocumentListener() {
            private void verificaTamanho() {
                if (txtHoraIni.getText().trim().length() == 2) {
                    txtMinutoIni.requestFocus(); 
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                verificaTamanho();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificaTamanho();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificaTamanho();
            }
        });
        txtHoraFim.getDocument().addDocumentListener(new DocumentListener() {
            private void verificaTamanho() {
                if (txtHoraFim.getText().trim().length() == 2) {
                    txtMinutoFim.requestFocus(); 
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                verificaTamanho();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificaTamanho();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificaTamanho();
            }
        });
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){
        this.CODBARBEARIA = CODBARBEARIA;
    }
    
    public void alterarExpediente(){
        try {
            boolean semExpediente = btnSemExpediente.isSelected();
            SelectedDate d = calendario.getSelectedDate();
            String dataString = d.getDay()+"/"+d.getMonth()+"/"+d.getYear(); //Pegando a data
            
            //convertendo a String data para DATE
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date(dataFormatada.parse(dataString).getTime());
            
            
            if(!semExpediente){
                String horaInicialString = txtHoraIni.getText()+":"+txtMinutoIni.getText(); 
                String horaFinalString = txtHoraFim.getText()+":"+txtMinutoFim.getText();
                if ("  :  ".equals(horaInicialString) || "  :  ".equals(horaFinalString)) {
                    JOptionPane.showMessageDialog(null, "Preencha o horário", "Mensagem", JOptionPane.ERROR_MESSAGE);
                return;
                }
                Date HorarioInicial = new Date(horaFormatada.parse(horaInicialString).getTime()); //TIME DATE
                Time horaInicial = new Time(HorarioInicial.getTime()); //Pegando o TIME da DATE

                Date HorarioFinal = new Date(horaFormatada.parse(horaFinalString).getTime()); //TIME DATE
                Time horaFinal = new Time(HorarioFinal.getTime()); //Pegando o TIME da DATE
                modelExpediente.setHoraInicial(horaInicial);
                modelExpediente.setHoraFinal(horaFinal);
            }
            
            
            modelExpediente.setDataInicial(data);
            modelExpediente.setCodbarbearia(CODBARBEARIA);
            
            if(expedienteController.controllerUpdate(modelExpediente, semExpediente)){
                txtHoraIni.setText("");
                txtMinutoIni.setText("");
                txtHoraFim.setText("");
                txtMinutoFim.setText("");
                btnSemExpediente.setSelected(false);
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
        txtRegra7 = new javax.swing.JLabel();
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
        btnSemExpediente = new javax.swing.JRadioButton();
        btnData = new javax.swing.JButton();
        txtRegra5 = new javax.swing.JLabel();
        calendario = new com.raven.datechooser.DateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Definir Expediente");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        txtRegra7.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        txtRegra7.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra7.setText("<html><div style='text-align: justify;'>ALTERAR EXPEDIENTE</div></html>");
        txtRegra7.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
                    .addComponent(txtRegra7))
                .addContainerGap())
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(icon)
                .addGap(56, 56, 56)
                .addComponent(txtRegra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(0, 153, 255));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        horarioInicio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        horarioInicio.setForeground(new java.awt.Color(0, 51, 102));
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
        horarioFim.setForeground(new java.awt.Color(0, 51, 102));
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
        txtRegra6.setForeground(new java.awt.Color(0, 51, 102));
        txtRegra6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra6.setText("<html><div style='text-align: justify;'>DEFINA O HORÁRIO</div></html>");
        txtRegra6.setBorder(new javax.swing.border.MatteBorder(null));

        btnSemExpediente.setBackground(new java.awt.Color(255, 255, 255));
        btnSemExpediente.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btnSemExpediente.setForeground(new java.awt.Color(0, 51, 102));
        btnSemExpediente.setText("SEM EXPEDIENTE NESSE DIA");
        btnSemExpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSemExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemExpedienteActionPerformed(evt);
            }
        });

        btnData.setBackground(new java.awt.Color(0, 51, 102));
        btnData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnData.setForeground(new java.awt.Color(255, 255, 255));
        btnData.setText("DEFINIR");
        btnData.setBorderPainted(false);
        btnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataActionPerformed(evt);
            }
        });

        txtRegra5.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        txtRegra5.setForeground(new java.awt.Color(0, 51, 102));
        txtRegra5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra5.setText("<html><div style='text-align: justify;'>DEFINA O DIA</div></html>");
        txtRegra5.setBorder(new javax.swing.border.MatteBorder(null));

        calendario.setForeground(new java.awt.Color(0, 51, 102));
        calendario.setToolTipText("");
        calendario.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegra5)
                            .addComponent(txtRegra6)
                            .addComponent(btnSemExpediente, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                            .addComponent(horarioFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(horarioInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(doispontos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinutoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addComponent(txtHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(doispontos1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinutoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(sair)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))))))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair)
                .addGap(18, 18, 18)
                .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(txtRegra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSemExpediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
                .addGap(122, 122, 122)
                .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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
        TP.receberCodBarbearia(CODBARBEARIA);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sairMouseClicked

    private void btnDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataActionPerformed
        alterarExpediente();
    }//GEN-LAST:event_btnDataActionPerformed

    private void btnSemExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemExpedienteActionPerformed
        if(btnSemExpediente.isSelected()){
            txtHoraIni.disable();
            txtMinutoIni.disable();
            txtHoraFim.disable();
            txtMinutoFim.disable();
                txtHoraIni.setText("");
                txtMinutoIni.setText("");
                txtHoraFim.setText("");
                txtMinutoFim.setText("");
        }else{
            txtHoraIni.enable();
            txtMinutoIni.enable();
            txtHoraFim.enable();
            txtMinutoFim.enable();
                txtHoraIni.setText("");
                txtMinutoIni.setText("");
                txtHoraFim.setText("");
                txtMinutoFim.setText("");
        }
        
        
    }//GEN-LAST:event_btnSemExpedienteActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaAlterarExpediente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JButton btnData;
    private javax.swing.JRadioButton btnSemExpediente;
    private com.raven.datechooser.DateChooser calendario;
    private javax.swing.JLabel doispontos;
    private javax.swing.JLabel doispontos1;
    private javax.swing.JLabel horarioFim;
    private javax.swing.JLabel horarioInicio;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel sair;
    private javax.swing.JFormattedTextField txtHoraFim;
    private javax.swing.JFormattedTextField txtHoraIni;
    private javax.swing.JFormattedTextField txtMinutoFim;
    private javax.swing.JFormattedTextField txtMinutoIni;
    private javax.swing.JLabel txtRegra5;
    private javax.swing.JLabel txtRegra6;
    private javax.swing.JLabel txtRegra7;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
