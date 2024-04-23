package view.barbearia;

import controller.BarbeariaController;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Servico;

public class TelaDefinirServicos extends javax.swing.JFrame {
    int CODBARBEARIA;
    boolean check;
    Servico modelServico = new Servico();
    BarbeariaController barbeariaController = new BarbeariaController();
    SimpleDateFormat horaFormatada = new SimpleDateFormat("mm");
    
    public TelaDefinirServicos() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){
        this.CODBARBEARIA = CODBARBEARIA;
    }
    
    public void cadastrar(){
        try {
            String horaString = inTempo.getText(); //Pegando a HORA em STRING
            Date Horario = new Date(horaFormatada.parse(horaString).getTime()); //TIME DATE
            Time hora = new Time(Horario.getTime()); //Pegando o TIME da DATE
            
            modelServico.setNome(inServico.getText());
            modelServico.setValor(Float.valueOf(inValor.getText()));
            modelServico.setTempo(hora);
            modelServico.setCODBARBEARIA(CODBARBEARIA);
            check=barbeariaController.verificarServico(modelServico);
            
            if(check){
                inServico.setText("");
                inValor.setText("");
                inTempo.setText("");
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(TelaDefinirServicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new css.FundoGradiente(0, 51, 102, 0, 0, 0, 0, 0, 1500, 100);
        Direita = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        txtServico = new javax.swing.JLabel();
        inServico = new javax.swing.JTextField();
        txtValor = new javax.swing.JLabel();
        txtTempo = new javax.swing.JLabel();
        inTempo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        inValor = new javax.swing.JTextField();
        sair = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Cadastro de Serviços");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 0, 102));
        Esquerda.setMaximumSize(new java.awt.Dimension(1320, 1080));
        Esquerda.setMinimumSize(new java.awt.Dimension(1320, 1080));
        Esquerda.setPreferredSize(new java.awt.Dimension(1320, 1080));

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );

        Direita.setBackground(new java.awt.Color(0, 153, 255));

        titulo.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CADASTRAR SERVIÇOS");

        txtServico.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        txtServico.setForeground(new java.awt.Color(255, 255, 255));
        txtServico.setText("Serviço:");

        inServico.setBackground(new java.awt.Color(255, 255, 255));
        inServico.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N

        txtValor.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        txtValor.setForeground(new java.awt.Color(255, 255, 255));
        txtValor.setText("Valor: (R$)");

        txtTempo.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        txtTempo.setForeground(new java.awt.Color(255, 255, 255));
        txtTempo.setText("Tempo: (minutos)");

        inTempo.setBackground(new java.awt.Color(255, 255, 255));
        inTempo.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CADASTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        inValor.setBackground(new java.awt.Color(255, 255, 255));
        inValor.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saida.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inTempo)
                            .addComponent(inServico)
                            .addComponent(txtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(sair)
                        .addContainerGap())))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair)
                .addGap(102, 102, 102)
                .addComponent(titulo)
                .addGap(42, 42, 42)
                .addComponent(txtServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inServico, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtValor)
                .addGap(18, 18, 18)
                .addComponent(inValor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txtTempo)
                .addGap(18, 18, 18)
                .addComponent(inTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastrar();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDefinirServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> {
            new TelaDefinirServicos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JTextField inServico;
    private javax.swing.JTextField inTempo;
    private javax.swing.JTextField inValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel sair;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtServico;
    private javax.swing.JLabel txtTempo;
    private javax.swing.JLabel txtValor;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
