
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

public class TelaDefinirExpedienteBarbearia extends javax.swing.JFrame {
    
    int CODBARBEARIA;
    ExpedienteController expedienteController = new ExpedienteController();
    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
    
    public TelaDefinirExpedienteBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){
        this.CODBARBEARIA = CODBARBEARIA;
    }
    
    public void definirExpediente(){
        try {
            SelectedDate d = calendario.getSelectedDate();
            String dataString = d.getDay()+"/"+d.getMonth()+"/"+d.getYear(); //Pegando a data
            
            //convertendo a String data para DATE
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date(dataFormatada.parse(dataString).getTime());
            
            expedienteController.verificarExpedienteNoBanco(data, CODBARBEARIA);
        } catch (ParseException ex) {
            Logger.getLogger(TelaDefinirExpedienteBarbearia.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    /*
    public void definirHorario(){
        try {
            String horaIniString = txtHoraIni.getText()+":"+txtMinutoIni.getText();
            Date HorarioIni = new Date(horaFormatada.parse(horaIniString).getTime()); 
            Time horaIni = new Time(HorarioIni.getTime()); 
            
            String horaFimString = txtHoraFim.getText()+":"+txtMinutoFim.getText();
            Date HorarioFim = new Date(horaFormatada.parse(horaFimString).getTime()); 
            Time horaFim = new Time(HorarioFim.getTime()); 
            
            expedienteController.verificarHorarioNoBanco(horaIni, horaFim);
        } catch (ParseException ex) {
            Logger.getLogger(TelaDefinirExpedienteBarbearia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new css.FundoGradiente(0, 51, 102, 0, 0, 0, 0, 0, 1500, 100);
        icon = new javax.swing.JLabel();
        txtRegra = new javax.swing.JLabel();
        txtRegra5 = new javax.swing.JLabel();
        Agendamento = new javax.swing.JLabel();
        Agendamento1 = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        calendario = new com.raven.datechooser.DateChooser();
        btnData = new javax.swing.JButton();
        Direita = new css.FundoGradiente(0, 191, 255, 65, 105, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        defina = new javax.swing.JLabel();
        expediente = new javax.swing.JLabel();
        horarioInicio = new javax.swing.JLabel();
        txtHoraIni = new css.ArrendondarBordas();
        doispontos = new javax.swing.JLabel();
        txtMinutoIni = new css.ArrendondarBordas();
        horarioFim = new javax.swing.JLabel();
        txtHoraFim = new css.ArrendondarBordas();
        doispontos1 = new javax.swing.JLabel();
        txtMinutoFim = new css.ArrendondarBordas();
        btnHorario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Definir Expediente");
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

        Agendamento.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        Agendamento.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Agendamento.setText("DEFINA O DIA QUE NÃO");

        Agendamento1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        Agendamento1.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Agendamento1.setText("HAVERÁ EXPEDIENTE!");

        Data.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Data.setForeground(new java.awt.Color(255, 255, 255));
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data.setText("DATA");

        calendario.setForeground(new java.awt.Color(0, 51, 102));
        calendario.setToolTipText("");
        calendario.setPreferredSize(new java.awt.Dimension(500, 500));

        btnData.setBackground(new java.awt.Color(0, 153, 255));
        btnData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnData.setForeground(new java.awt.Color(255, 255, 255));
        btnData.setText("DEFINIR DIA");
        btnData.setBorderPainted(false);
        btnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRegra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                        .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                        .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(508, 508, 508))))
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(icon)
                .addGap(27, 27, 27)
                .addComponent(txtRegra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Agendamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Agendamento1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnData, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(0, 153, 255));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saida.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        defina.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        defina.setForeground(new java.awt.Color(255, 255, 255));
        defina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defina.setText("DEFINA O HORÁRIO");

        expediente.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        expediente.setForeground(new java.awt.Color(255, 255, 255));
        expediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expediente.setText("DO EXPEDIENTE");

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

        btnHorario.setBackground(new java.awt.Color(0, 51, 102));
        btnHorario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHorario.setForeground(new java.awt.Color(255, 255, 255));
        btnHorario.setText("DEFINIR HORARIO");
        btnHorario.setBorderPainted(false);
        btnHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorarioActionPerformed(evt);
            }
        });

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
                                .addComponent(sair))
                            .addComponent(defina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(expediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                .addComponent(txtMinutoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(259, 259, 259)
                                .addComponent(btnHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair)
                .addGap(109, 109, 109)
                .addComponent(defina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expediente)
                .addGap(46, 46, 46)
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
                .addGap(65, 65, 65)
                .addComponent(btnHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TP.receberCodBarbearia(CODBARBEARIA);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sairMouseClicked

    private void btnDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataActionPerformed
        definirExpediente();
    }//GEN-LAST:event_btnDataActionPerformed

    private void btnHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorarioActionPerformed
        //definirHorario();
    }//GEN-LAST:event_btnHorarioActionPerformed


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
    private javax.swing.JButton btnData;
    private javax.swing.JButton btnHorario;
    private com.raven.datechooser.DateChooser calendario;
    private javax.swing.JLabel defina;
    private javax.swing.JLabel doispontos;
    private javax.swing.JLabel doispontos1;
    private javax.swing.JLabel expediente;
    private javax.swing.JLabel horarioFim;
    private javax.swing.JLabel horarioInicio;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel sair;
    private javax.swing.JFormattedTextField txtHoraFim;
    private javax.swing.JFormattedTextField txtHoraIni;
    private javax.swing.JFormattedTextField txtMinutoFim;
    private javax.swing.JFormattedTextField txtMinutoIni;
    private javax.swing.JLabel txtRegra;
    private javax.swing.JLabel txtRegra5;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
