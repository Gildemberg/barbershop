
package view;

import com.raven.datechooser.SelectedDate;
import dao.BarbeariaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.TransfCod;
import model.Agendamento;
import model.Barbearia;

public class TelaAgendamento extends javax.swing.JFrame{

    int COD_USR, COD_EMP, COD_AGEND;
    
    
    public TelaAgendamento() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
    }
    
    public void receberCod(TransfCod TC){
        this.COD_EMP = TC.getCod();
        this.COD_USR = TC.getCod1();
        consultarEmpresa(COD_EMP);
    }
    
    public void receberCodReAgend(TransfCod TC){
        this.COD_AGEND = TC.getCod();
        this.COD_EMP = TC.getCod1();
        this.COD_USR = TC.getCod2();
        consultarEmpresa(COD_EMP);
    }
    
    public void consultarEmpresa (int COD_EMP){
        BarbeariaDAO bDAO = new BarbeariaDAO();
        List<Barbearia> barbearias = new ArrayList();
        barbearias=bDAO.read();
        
        txtBarbearia.setText(barbearias.get(COD_EMP-1).getNome());
        txtDescricao.setText("<html>"+barbearias.get(COD_EMP-1).getDescricao()+"</html>"); //inserir a tag HTML server para qubrar a linha do JLabel
        txtEmail.setText("Email: "+barbearias.get(COD_EMP-1).getEmail());
        txtEndereco.setText("Localização: "+barbearias.get(COD_EMP-1).getEndereco());
        txtRegra1.setText("• "+barbearias.get(COD_EMP-1).getRegra1());
        txtRegra2.setText("• "+barbearias.get(COD_EMP-1).getRegra2());
        txtRegra3.setText("• "+barbearias.get(COD_EMP-1).getRegra3());
        txtRegra4.setText("• "+barbearias.get(COD_EMP-1).getRegra4());
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new css.FundoGradiente(0, 51, 102, 0, 0, 0, 0, 0, 1500, 100);
        icon = new javax.swing.JLabel();
        txtBarbearia = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        txtValores = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JLabel();
        txtRegra = new javax.swing.JLabel();
        txtRegra1 = new javax.swing.JLabel();
        txtRegra2 = new javax.swing.JLabel();
        txtRegra3 = new javax.swing.JLabel();
        txtRegra4 = new javax.swing.JLabel();
        Direita = new css.FundoGradiente(0, 191, 255, 65, 105, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        Agendamento = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        Minuto = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        calendario = new com.raven.datechooser.DateChooser();
        btnAgendar = new javax.swing.JButton();
        txtHora = new css.ArrendondarBordas();
        txtMinuto = new css.ArrendondarBordas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Agendamento");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        txtBarbearia.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        txtBarbearia.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBarbearia.setBorder(new javax.swing.border.MatteBorder(null));

        txtDescricao.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(255, 255, 255));
        txtDescricao.setBorder(new javax.swing.border.MatteBorder(null));

        txtEmail.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(new javax.swing.border.MatteBorder(null));

        txtValores.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        txtValores.setForeground(new java.awt.Color(255, 255, 255));
        txtValores.setBorder(new javax.swing.border.MatteBorder(null));

        txtEndereco.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtEndereco.setForeground(new java.awt.Color(255, 255, 255));
        txtEndereco.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra.setText("REGRAS DO ESTABELECIMENTO:");
        txtRegra.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra1.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra1.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra2.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra2.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra3.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra3.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra3.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra4.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra4.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra4.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBarbearia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtValores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegra1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegra2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegra3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(txtRegra4, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(icon)
                .addGap(43, 43, 43)
                .addComponent(txtBarbearia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addComponent(txtRegra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRegra1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRegra2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegra3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRegra4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtValores, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
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
        Agendamento.setText("AGENDAMENTO");

        Hora.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Hora.setForeground(new java.awt.Color(255, 255, 255));
        Hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Hora.setText("HORA");

        Minuto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Minuto.setForeground(new java.awt.Color(255, 255, 255));
        Minuto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minuto.setText("MINUTO");

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
        btnAgendar.setText("AGENDAR");
        btnAgendar.setBorderPainted(false);
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        txtHora.setBorder(null);
        txtHora.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        txtMinuto.setBorder(null);
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
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(sair)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(Agendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addComponent(Hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Minuto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(74, 74, 74)))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hora)
                    .addComponent(Minuto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addComponent(Data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        TelaPrincipal TP = new TelaPrincipal();
        TransfCod TC = new TransfCod();
        TC.setCod(COD_USR); //setando o cod usr
        TP.receberCodUsr(TC); 
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sairMouseClicked

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        String hora = txtHora.getText()+":"+txtMinuto.getText();
        SelectedDate d = calendario.getSelectedDate();
        String data = d.getDay()+"/"+d.getMonth()+"/"+d.getYear();
        ImageIcon iconConfirmar = new ImageIcon(getToolkit().createImage(getClass().getResource("../images/confirmar.png"))); //criando um icone para alerta de mensagem
        
        if(COD_AGEND != 0){// SERVE PARA ALTERAR O AGENDAMENTO
            Agendamento a = new Agendamento(0, 0, data, hora, "", COD_AGEND);   
            a.alterarAgendamento(a);
            JOptionPane.showMessageDialog(null, "Agendamento Alterado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
        }else{//SERVE PARA AGENDAR DO ZERO
            Agendamento a = new Agendamento(COD_EMP, COD_USR, data, hora, "", 0);   
            a.agendarHorario(a);
            JOptionPane.showMessageDialog(null, "Agendamento Realizado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
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
            java.util.logging.Logger.getLogger(TelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agendamento;
    private javax.swing.JLabel Data;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JLabel Hora;
    private javax.swing.JLabel Minuto;
    private javax.swing.JButton btnAgendar;
    private com.raven.datechooser.DateChooser calendario;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel sair;
    private javax.swing.JLabel txtBarbearia;
    private javax.swing.JLabel txtDescricao;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtEndereco;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JFormattedTextField txtMinuto;
    private javax.swing.JLabel txtRegra;
    private javax.swing.JLabel txtRegra1;
    private javax.swing.JLabel txtRegra2;
    private javax.swing.JLabel txtRegra3;
    private javax.swing.JLabel txtRegra4;
    private javax.swing.JLabel txtValores;
    // End of variables declaration//GEN-END:variables
}
