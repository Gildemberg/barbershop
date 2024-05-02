package view.barbearia;

import com.raven.datechooser.SelectedDate;
import controller.ExpedienteController;
import css.BordaArredondada;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
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

        Cima = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        Centro = new javax.swing.JPanel();
        DefinaDia = new javax.swing.JLabel();
        calendario = new com.raven.datechooser.DateChooser();
        DefinaHora = new javax.swing.JLabel();
        inicioExpediente = new javax.swing.JLabel();
        txtHoraIni = new css.ArrendondarBordas();
        doispontos = new javax.swing.JLabel();
        txtMinutoIni = new css.ArrendondarBordas();
        fimExpediente = new javax.swing.JLabel();
        txtHoraFim = new css.ArrendondarBordas();
        doispontos1 = new javax.swing.JLabel();
        txtMinutoFim = new css.ArrendondarBordas();
        btnSemExpediente = new javax.swing.JRadioButton();
        btnData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Definir Expediente");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 150));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));
        Cima.setPreferredSize(new java.awt.Dimension(1920, 150));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        titulo.setFont(new java.awt.Font("Caladea", 1, 90)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Alterar Expediente");
        titulo.setBorder(new javax.swing.border.MatteBorder(null));

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

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addComponent(icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        Centro.setMaximumSize(new java.awt.Dimension(1920, 930));
        Centro.setMinimumSize(new java.awt.Dimension(1920, 930));
        Centro.setPreferredSize(new java.awt.Dimension(1920, 930));

        DefinaDia.setFont(new java.awt.Font("Caladea", 1, 75)); // NOI18N
        DefinaDia.setForeground(new java.awt.Color(0, 51, 102));
        DefinaDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DefinaDia.setText("Defina o dia");
        DefinaDia.setBorder(new javax.swing.border.MatteBorder(null));

        calendario.setForeground(new java.awt.Color(0, 51, 102));
        calendario.setToolTipText("");
        calendario.setPreferredSize(new java.awt.Dimension(500, 500));

        DefinaHora.setFont(new java.awt.Font("Caladea", 1, 75)); // NOI18N
        DefinaHora.setForeground(new java.awt.Color(0, 51, 102));
        DefinaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DefinaHora.setText("Defina o horário");
        DefinaHora.setBorder(new javax.swing.border.MatteBorder(null));

        inicioExpediente.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        inicioExpediente.setForeground(new java.awt.Color(0, 51, 102));
        inicioExpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioExpediente.setText("Início do Expediente");

        txtHoraIni.setBorder(null);
        txtHoraIni.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHoraIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraIni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraIni.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        BordaArredondada borda = new BordaArredondada(new Color(0, 51, 102), 3, 10);
        Border bordaInterna = BorderFactory.createEmptyBorder(0, 10, 0, 0);
        Border bordaComposta = BorderFactory.createCompoundBorder(borda, bordaInterna);
        txtHoraIni.setBackground(new Color(222, 222, 222, 222));
        txtHoraIni.setBorder(bordaComposta);

        doispontos.setFont(new java.awt.Font("Dialog", 0, 41)); // NOI18N
        doispontos.setForeground(new java.awt.Color(0, 51, 102));
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
        txtMinutoIni.setBackground(new Color(222, 222, 222, 222));
        txtMinutoIni.setBorder(bordaComposta);

        fimExpediente.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        fimExpediente.setForeground(new java.awt.Color(0, 51, 102));
        fimExpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fimExpediente.setText("Fim do Expediente");

        txtHoraFim.setBorder(null);
        txtHoraFim.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHoraFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraFim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraFim.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtHoraFim.setBackground(new Color(222, 222, 222, 222));
        txtHoraFim.setBorder(bordaComposta);

        doispontos1.setFont(new java.awt.Font("Dialog", 0, 41)); // NOI18N
        doispontos1.setForeground(new java.awt.Color(0, 51, 102));
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
        txtMinutoFim.setBackground(new Color(222, 222, 222, 222));
        txtMinutoFim.setBorder(bordaComposta);

        btnSemExpediente.setBackground(new java.awt.Color(255, 255, 255));
        btnSemExpediente.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        btnSemExpediente.setForeground(new java.awt.Color(0, 51, 102));
        btnSemExpediente.setText("Sem expediente nesse dia");
        btnSemExpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSemExpediente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSemExpediente.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnSemExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemExpedienteActionPerformed(evt);
            }
        });

        btnData.setBackground(new java.awt.Color(0, 51, 102));
        btnData.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        btnData.setForeground(new java.awt.Color(255, 255, 255));
        btnData.setText("Concluir");
        btnData.setBorderPainted(false);
        btnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSemExpediente, javax.swing.GroupLayout.DEFAULT_SIZE, 1908, Short.MAX_VALUE)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addGap(397, 397, 397)
                                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CentroLayout.createSequentialGroup()
                                        .addGap(169, 169, 169)
                                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fimExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inicioExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(CentroLayout.createSequentialGroup()
                                        .addGap(236, 236, 236)
                                        .addComponent(txtHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(doispontos1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinutoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(CentroLayout.createSequentialGroup()
                                        .addGap(236, 236, 236)
                                        .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(doispontos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinutoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(DefinaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DefinaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(758, 758, 758))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DefinaDia)
                    .addComponent(DefinaHora))
                .addGap(38, 38, 38)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(inicioExpediente)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(doispontos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CentroLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtMinutoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fimExpediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doispontos1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMinutoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addComponent(btnSemExpediente)
                .addGap(81, 81, 81)
                .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Centro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TP.receberCodBarbearia(CODBARBEARIA);
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
            java.util.logging.Logger.getLogger(TelaAlterarExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaAlterarExpediente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JLabel DefinaDia;
    private javax.swing.JLabel DefinaHora;
    private javax.swing.JButton btnData;
    private javax.swing.JRadioButton btnSemExpediente;
    private javax.swing.JButton btnVoltar;
    private com.raven.datechooser.DateChooser calendario;
    private javax.swing.JLabel doispontos;
    private javax.swing.JLabel doispontos1;
    private javax.swing.JLabel fimExpediente;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel inicioExpediente;
    private javax.swing.JLabel titulo;
    private javax.swing.JFormattedTextField txtHoraFim;
    private javax.swing.JFormattedTextField txtHoraIni;
    private javax.swing.JFormattedTextField txtMinutoFim;
    private javax.swing.JFormattedTextField txtMinutoIni;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
