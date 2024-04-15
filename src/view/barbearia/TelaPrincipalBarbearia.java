
package view.barbearia;

import dao.BarbeariaDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.ConsultarNome;
import model.TransfCod;
import view.barbearia.TelaLoginBarbearia;

public class TelaPrincipalBarbearia extends javax.swing.JFrame {
    
    int CODBARBEARIA;
    String NOME_EMP, horario;

    public TelaPrincipalBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        //Inserindo horario atual na tela principal
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        horario = hoje.format(formato);
        dataAtual.setText(horario);
    }
    
    public void receberCodBarbearia(TransfCod TCE){//receber o cod EMPRESA
        this.CODBARBEARIA = TCE.getCod(); //recebendo o cod emp
        BarbeariaDAO BarberDao = new BarbeariaDAO();
        ConsultarNome CNE = new ConsultarNome();
        CNE = BarberDao.retornoNome(CODBARBEARIA); //consultando o nome usr
        consultarNomeEmp(CNE);
    }
    
    public void consultarNomeEmp (ConsultarNome CNE){//consultando o nome USUÁRIO
        NOME_EMP = CNE.getNome(); //recebendo o nome usr
        nome_emp.setText(NOME_EMP); //imprimendo o nome usr
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new css.FundoGradiente(0, 255, 255, 30, 144, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();
        localizacao = new javax.swing.JLabel();
        Centro = new javax.swing.JPanel();
        ola = new javax.swing.JLabel();
        nome_emp = new javax.swing.JLabel();
        jPanel1 = new css.FundoGradiente(0, 255, 255, 30, 144, 255, 0, 0, 1500, 100);
        btnDefinir = new javax.swing.JLabel();
        jPanel2 = new css.FundoGradiente(0, 255, 255, 30, 144, 255, 0, 0, 1500, 100);
        btnConsultar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Gestor");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(29, 93, 183));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 100));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 100));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sair2.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        dataAtual.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        dataAtual.setForeground(new java.awt.Color(0, 51, 204));
        dataAtual.setBorder(new javax.swing.border.MatteBorder(null));

        localizacao.setFont(new java.awt.Font("Mongolian Baiti", 0, 18)); // NOI18N
        localizacao.setForeground(new java.awt.Color(0, 51, 204));
        localizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icone_local.png"))); // NOI18N
        localizacao.setText("Paulo Afonso - BA");

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localizacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair)
                .addGap(23, 23, 23))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(sair))
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localizacao)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        Centro.setBackground(new java.awt.Color(206, 230, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1420, 980));
        Centro.setMinimumSize(new java.awt.Dimension(1420, 980));

        ola.setFont(new java.awt.Font("Mongolian Baiti", 0, 60)); // NOI18N
        ola.setForeground(new java.awt.Color(0, 51, 204));
        ola.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ola.setText("Seja Bem Vindo!");

        nome_emp.setFont(new java.awt.Font("Mongolian Baiti", 0, 60)); // NOI18N
        nome_emp.setForeground(new java.awt.Color(0, 51, 204));
        nome_emp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nome_emp.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        btnDefinir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDefinir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/definir_horario.png"))); // NOI18N
        btnDefinir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDefinir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDefinirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDefinir, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDefinir, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        btnConsultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/consultar_agendamento.png"))); // NOI18N
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ola, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
                .addGap(544, 544, 544))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 636, Short.MAX_VALUE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(ola, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        this.dispose();
        new TelaLoginBarbearia().setVisible(true);
    }//GEN-LAST:event_sairMouseClicked

    private void btnConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseClicked
        TelaAgendamentoBarbearia TCA = new TelaAgendamentoBarbearia();
        TCA.receberCodUsr(CODBARBEARIA, NOME_EMP, horario);
        TCA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultarMouseClicked

    private void btnDefinirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDefinirMouseClicked
        TelaDefinirExpedienteBarbearia TDEB = new TelaDefinirExpedienteBarbearia();
        TDEB.receberCodBarbearia(CODBARBEARIA);
        TDEB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDefinirMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalBarbearia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipalBarbearia().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JLabel btnConsultar;
    private javax.swing.JLabel btnDefinir;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel localizacao;
    private javax.swing.JLabel nome_emp;
    private javax.swing.JLabel ola;
    private javax.swing.JLabel sair;
    // End of variables declaration//GEN-END:variables
}
