
package view.barbearia;

import dao.BarbeariaDAO;
import java.awt.Toolkit;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class TelaPrincipalBarbearia extends javax.swing.JFrame {
    
    int CODBARBEARIA;
    String NOMEBARBEARIA, horario;
    TelaCadastroBarbearia TCB = new TelaCadastroBarbearia();

    public TelaPrincipalBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
        inserirDataHora();
    }
    
    public void inserirDataHora(){
        LocalDate data = LocalDate.now();
        LocalDateTime hora = LocalDateTime.now();
        DayOfWeek dia = hora.getDayOfWeek();
        DateTimeFormatter formatoDATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHORA = DateTimeFormatter.ofPattern("HH:mm a");
        String DATA = data.format(formatoDATA);
        String HORA = hora.format(formatoHORA);
        String DIA = dia.getDisplayName(TextStyle.SHORT, Locale.getDefault());
        DIA = DIA.replace(".", "");
        DIA = DIA.toUpperCase();
        dataAtual.setText(DIA+" - "+DATA +" - "+ HORA);
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){//receber o cod EMPRESA
        this.CODBARBEARIA = CODBARBEARIA; //recebendo o cod emp
        consultarNomeEmp(CODBARBEARIA);
    }
    
    public void consultarNomeEmp (int CODBARBEARIA){//consultando o nome USUÁRIO
        BarbeariaDAO BarberDao = new BarbeariaDAO();
        NOMEBARBEARIA = BarberDao.retornoNome(CODBARBEARIA); //consultando o nome usr
        nome_emp.setText(NOMEBARBEARIA); //imprimendo o nome usr
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new css.FundoGradiente(70, 130, 180, 25, 25, 112, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();
        localizacao = new javax.swing.JLabel();
        editarCadastro = new javax.swing.JLabel();
        Centro = new javax.swing.JPanel();
        ola = new javax.swing.JLabel();
        nome_emp = new javax.swing.JLabel();
        btnDefinirExpediente = new css.JPanelArredondadoBarbearias(100);
        iconDefinirExpediente = new javax.swing.JLabel();
        definirexpediente = new javax.swing.JLabel();
        btnConsultarAgenda = new css.JPanelArredondadoBarbearias(100);
        iconConsultar = new javax.swing.JLabel();
        consultaragenda = new javax.swing.JLabel();
        btnDefinirServico = new css.JPanelArredondadoBarbearias(100);
        iconDefinirServico = new javax.swing.JLabel();
        defirnirservicos = new javax.swing.JLabel();
        btnAlterarExpediente = new css.JPanelArredondadoBarbearias(100);
        iconAlterarExpediente = new javax.swing.JLabel();
        alterarexpediente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal Barbearia");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(29, 93, 183));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 130));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 100));
        Cima.setPreferredSize(new java.awt.Dimension(866, 130));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saida.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        dataAtual.setFont(new java.awt.Font("DejaVu Sans Light", 0, 18)); // NOI18N
        dataAtual.setForeground(new java.awt.Color(255, 255, 255));
        dataAtual.setBorder(new javax.swing.border.MatteBorder(null));

        localizacao.setFont(new java.awt.Font("DejaVu Sans Light", 0, 18)); // NOI18N
        localizacao.setForeground(new java.awt.Color(255, 255, 255));
        localizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localizacao.png"))); // NOI18N
        localizacao.setText("Paulo Afonso - BA");

        editarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/definicoes.png"))); // NOI18N
        editarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarCadastroMouseClicked(evt);
            }
        });

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
                .addComponent(editarCadastro)
                .addGap(18, 18, 18)
                .addComponent(sair)
                .addGap(23, 23, 23))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localizacao)
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(editarCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnDefinirExpediente.setBackground(new java.awt.Color(25, 25, 112));
        btnDefinirExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDefinirExpediente.setMaximumSize(new java.awt.Dimension(550, 600));
        btnDefinirExpediente.setMinimumSize(new java.awt.Dimension(550, 600));
        btnDefinirExpediente.setPreferredSize(new java.awt.Dimension(550, 600));
        btnDefinirExpediente.setRequestFocusEnabled(false);
        btnDefinirExpediente.setVerifyInputWhenFocusTarget(false);
        btnDefinirExpediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDefinirExpedienteMouseClicked(evt);
            }
        });

        iconDefinirExpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconDefinirExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/definirExpediente.png"))); // NOI18N
        iconDefinirExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        definirexpediente.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        definirexpediente.setForeground(new java.awt.Color(255, 255, 255));
        definirexpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        definirexpediente.setText("DEFINIR EXPEDIENTE");

        javax.swing.GroupLayout btnDefinirExpedienteLayout = new javax.swing.GroupLayout(btnDefinirExpediente);
        btnDefinirExpediente.setLayout(btnDefinirExpedienteLayout);
        btnDefinirExpedienteLayout.setHorizontalGroup(
            btnDefinirExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDefinirExpedienteLayout.createSequentialGroup()
                .addGroup(btnDefinirExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(definirexpediente, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(iconDefinirExpediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnDefinirExpedienteLayout.setVerticalGroup(
            btnDefinirExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDefinirExpedienteLayout.createSequentialGroup()
                .addComponent(iconDefinirExpediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(definirexpediente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnConsultarAgenda.setBackground(new java.awt.Color(25, 25, 112));
        btnConsultarAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarAgenda.setMaximumSize(new java.awt.Dimension(550, 600));
        btnConsultarAgenda.setMinimumSize(new java.awt.Dimension(550, 600));
        btnConsultarAgenda.setPreferredSize(new java.awt.Dimension(550, 600));
        btnConsultarAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarAgendaMouseClicked(evt);
            }
        });

        iconConsultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/consultarAgendamento.png"))); // NOI18N
        iconConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        consultaragenda.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        consultaragenda.setForeground(new java.awt.Color(255, 255, 255));
        consultaragenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        consultaragenda.setText("CONSULTAR AGENDA");

        javax.swing.GroupLayout btnConsultarAgendaLayout = new javax.swing.GroupLayout(btnConsultarAgenda);
        btnConsultarAgenda.setLayout(btnConsultarAgendaLayout);
        btnConsultarAgendaLayout.setHorizontalGroup(
            btnConsultarAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConsultarAgendaLayout.createSequentialGroup()
                .addGroup(btnConsultarAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(consultaragenda, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(iconConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnConsultarAgendaLayout.setVerticalGroup(
            btnConsultarAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConsultarAgendaLayout.createSequentialGroup()
                .addComponent(iconConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultaragenda)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnDefinirServico.setBackground(new java.awt.Color(25, 25, 112));
        btnDefinirServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDefinirServico.setMaximumSize(new java.awt.Dimension(550, 600));
        btnDefinirServico.setMinimumSize(new java.awt.Dimension(550, 600));
        btnDefinirServico.setPreferredSize(new java.awt.Dimension(550, 600));
        btnDefinirServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDefinirServicoMouseClicked(evt);
            }
        });

        iconDefinirServico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconDefinirServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/definirServicos.png"))); // NOI18N
        iconDefinirServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        defirnirservicos.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        defirnirservicos.setForeground(new java.awt.Color(255, 255, 255));
        defirnirservicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defirnirservicos.setText("DEFINIR SERVIÇOS");

        javax.swing.GroupLayout btnDefinirServicoLayout = new javax.swing.GroupLayout(btnDefinirServico);
        btnDefinirServico.setLayout(btnDefinirServicoLayout);
        btnDefinirServicoLayout.setHorizontalGroup(
            btnDefinirServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defirnirservicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconDefinirServico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnDefinirServicoLayout.setVerticalGroup(
            btnDefinirServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDefinirServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconDefinirServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defirnirservicos)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnAlterarExpediente.setBackground(new java.awt.Color(25, 25, 112));
        btnAlterarExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterarExpediente.setMaximumSize(new java.awt.Dimension(550, 600));
        btnAlterarExpediente.setMinimumSize(new java.awt.Dimension(550, 600));
        btnAlterarExpediente.setPreferredSize(new java.awt.Dimension(350, 324));
        btnAlterarExpediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarExpedienteMouseClicked(evt);
            }
        });

        iconAlterarExpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAlterarExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarExpediente.png"))); // NOI18N
        iconAlterarExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        alterarexpediente.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        alterarexpediente.setForeground(new java.awt.Color(255, 255, 255));
        alterarexpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alterarexpediente.setText("ALTERAR EXPEDIENTE");

        javax.swing.GroupLayout btnAlterarExpedienteLayout = new javax.swing.GroupLayout(btnAlterarExpediente);
        btnAlterarExpediente.setLayout(btnAlterarExpedienteLayout);
        btnAlterarExpedienteLayout.setHorizontalGroup(
            btnAlterarExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(alterarexpediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAlterarExpedienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconAlterarExpediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAlterarExpedienteLayout.setVerticalGroup(
            btnAlterarExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAlterarExpedienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconAlterarExpediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alterarexpediente)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap(622, Short.MAX_VALUE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ola, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
                .addGap(544, 544, 544))
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnDefinirExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDefinirServico, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnAlterarExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(ola, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnConsultarAgenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnDefinirExpediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDefinirServico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAlterarExpediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, Short.MAX_VALUE))
                .addContainerGap(426, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
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

    private void editarCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarCadastroMouseClicked
        TCB.atualizarCadastro(CODBARBEARIA);
        TCB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editarCadastroMouseClicked

    private void btnDefinirExpedienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDefinirExpedienteMouseClicked
        TelaDefinirExpediente TDE = new TelaDefinirExpediente();
        TDE.receberCodBarbearia(CODBARBEARIA);
        TDE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDefinirExpedienteMouseClicked

    private void btnConsultarAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarAgendaMouseClicked
        TelaAgendamentoBarbearia TCA = new TelaAgendamentoBarbearia();
        TCA.receberCodUsr(CODBARBEARIA, NOMEBARBEARIA);
        TCA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultarAgendaMouseClicked

    private void btnDefinirServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDefinirServicoMouseClicked
        TelaDefinirServicos TDS = new TelaDefinirServicos();
        TDS.receberCodBarbearia(CODBARBEARIA);
        TDS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDefinirServicoMouseClicked

    private void btnAlterarExpedienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarExpedienteMouseClicked
        TelaAlterarExpediente TAE = new TelaAlterarExpediente();
        TAE.receberCodBarbearia(CODBARBEARIA);
        TAE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAlterarExpedienteMouseClicked

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
    private javax.swing.JLabel alterarexpediente;
    private javax.swing.JPanel btnAlterarExpediente;
    private javax.swing.JPanel btnConsultarAgenda;
    private javax.swing.JPanel btnDefinirExpediente;
    private javax.swing.JPanel btnDefinirServico;
    private javax.swing.JLabel consultaragenda;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JLabel definirexpediente;
    private javax.swing.JLabel defirnirservicos;
    private javax.swing.JLabel editarCadastro;
    private javax.swing.JLabel iconAlterarExpediente;
    private javax.swing.JLabel iconConsultar;
    private javax.swing.JLabel iconDefinirExpediente;
    private javax.swing.JLabel iconDefinirServico;
    private javax.swing.JLabel localizacao;
    private javax.swing.JLabel nome_emp;
    private javax.swing.JLabel ola;
    private javax.swing.JLabel sair;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
