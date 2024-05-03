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

        Cima = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        Centro = new javax.swing.JPanel();
        horarioInicio = new javax.swing.JLabel();
        txtHoraIni = new css.ArrendondarBordas();
        doispontos = new javax.swing.JLabel();
        txtMinutoIni = new css.ArrendondarBordas();
        horarioFim = new javax.swing.JLabel();
        txtHoraFim = new css.ArrendondarBordas();
        doispontos1 = new javax.swing.JLabel();
        txtMinutoFim = new css.ArrendondarBordas();
        txtRegra6 = new javax.swing.JLabel();
        btnDefinir = new javax.swing.JButton();
        txtRegra5 = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        Data1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Alterar Expediente");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 150));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));
        Cima.setPreferredSize(new java.awt.Dimension(1920, 150));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        titulo.setFont(new java.awt.Font("Caladea", 1, 90)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Definir Expediente");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon)
                .addGap(1604, 1604, 1604)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CimaLayout.createSequentialGroup()
                    .addGap(245, 245, 245)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(243, Short.MAX_VALUE)))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon))
            .addGroup(CimaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CimaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        Centro.setBackground(new java.awt.Color(255, 255, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1920, 960));
        Centro.setMinimumSize(new java.awt.Dimension(1920, 960));
        Centro.setPreferredSize(new java.awt.Dimension(1920, 960));

        horarioInicio.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        horarioInicio.setForeground(new java.awt.Color(0, 51, 102));
        horarioInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horarioInicio.setText("Início do Expediente");

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
        doispontos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        horarioFim.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        horarioFim.setForeground(new java.awt.Color(0, 51, 102));
        horarioFim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horarioFim.setText("Fim do Expediente");

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
        doispontos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        txtRegra6.setFont(new java.awt.Font("Caladea", 1, 50)); // NOI18N
        txtRegra6.setForeground(new java.awt.Color(0, 51, 102));
        txtRegra6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra6.setText("Horário padrão");
        txtRegra6.setBorder(new javax.swing.border.MatteBorder(null));

        btnDefinir.setBackground(new java.awt.Color(0, 51, 102));
        btnDefinir.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        btnDefinir.setForeground(new java.awt.Color(255, 255, 255));
        btnDefinir.setText("Concluir");
        btnDefinir.setBorderPainted(false);
        btnDefinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefinirActionPerformed(evt);
            }
        });

        txtRegra5.setFont(new java.awt.Font("Caladea", 1, 50)); // NOI18N
        txtRegra5.setForeground(new java.awt.Color(0, 51, 102));
        txtRegra5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra5.setText("Período em que haverá expediente");
        txtRegra5.setBorder(new javax.swing.border.MatteBorder(null));

        Data.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        Data.setForeground(new java.awt.Color(0, 51, 102));
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data.setText("Data início");

        txtDataInicial.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataInicial.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtDataInicial.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtDataInicial.setBackground(new Color(222, 222, 222, 222));
        txtDataInicial.setBorder(bordaComposta);

        txtDataFinal.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataFinal.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtDataFinal.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtDataFinal.setBackground(new Color(222, 222, 222, 222));
        txtDataFinal.setBorder(bordaComposta);

        Data1.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        Data1.setForeground(new java.awt.Color(0, 51, 102));
        Data1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data1.setText("Data fim");

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtRegra5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtRegra6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CentroLayout.createSequentialGroup()
                    .addGap(993, 993, 993)
                    .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CentroLayout.createSequentialGroup()
                            .addComponent(txtHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(doispontos1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMinutoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(horarioFim, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(532, 532, 532)))
            .addGroup(CentroLayout.createSequentialGroup()
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(567, 567, 567)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDataFinal)
                            .addComponent(Data1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doispontos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMinutoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(759, 759, 759)
                        .addComponent(btnDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(Data1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataFinal))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(Data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addComponent(txtRegra6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(doispontos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMinutoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horarioFim)
                            .addComponent(horarioInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doispontos1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMinutoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(83, 83, 83)
                .addComponent(btnDefinir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Centro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1926, Short.MAX_VALUE)
                    .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, 1926, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Centro, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefinirActionPerformed
        definirExpediente();
    }//GEN-LAST:event_btnDefinirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDefinirExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaDefinirExpediente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Data1;
    private javax.swing.JButton btnDefinir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel doispontos;
    private javax.swing.JLabel doispontos1;
    private javax.swing.JLabel horarioFim;
    private javax.swing.JLabel horarioInicio;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel titulo;
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
