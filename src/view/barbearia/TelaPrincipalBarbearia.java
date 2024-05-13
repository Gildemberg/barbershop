
package view.barbearia;

import dao.BarbeariaDAO;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import model.Barbearia;

public class TelaPrincipalBarbearia extends javax.swing.JFrame {
    
    int CODBARBEARIA;
    String NOMEBARBEARIA, horario;
    TelaCadastroBarbearia TCB = new TelaCadastroBarbearia();

    public TelaPrincipalBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){
        this.CODBARBEARIA = CODBARBEARIA; 
        preencherCamposBarber(CODBARBEARIA);
    }
    
    public void preencherCamposBarber (int CODBARBEARIA){
        List<Barbearia> barbearias = new ArrayList(); 
        BarbeariaDAO BarberDao = new BarbeariaDAO();
        barbearias=BarberDao.read();
        nome_emp.setText(barbearias.get(CODBARBEARIA-1).getNome()); //imprimendo o nome usr
        localizacao.setText(barbearias.get(CODBARBEARIA-1).getCidade()+" - "+barbearias.get(CODBARBEARIA-1).getUf());
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new javax.swing.JPanel();
        localizacao = new javax.swing.JLabel();
        nome_emp = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        sair = new javax.swing.JLabel();
        editarCadastro = new javax.swing.JLabel();
        btnAlterarCadastro = new javax.swing.JButton();
        Centro = new javax.swing.JPanel();
        labelSejaBemVindo = new javax.swing.JLabel();
        btnConsultarAgenda = new css.JPanelArredondadoBarbearias(30);
        iconConsultar = new javax.swing.JLabel();
        consultaragenda = new javax.swing.JLabel();
        btnServico = new css.JPanelArredondadoBarbearias(30);
        iconDefinirServico = new javax.swing.JLabel();
        defirnirservicos = new javax.swing.JLabel();
        btnExpediente = new css.JPanelArredondadoBarbearias(30);
        iconAlterarExpediente = new javax.swing.JLabel();
        alterarexpediente = new javax.swing.JLabel();
        btnCaixa = new css.JPanelArredondadoBarbearias(30);
        iconCaixa = new javax.swing.JLabel();
        caixa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal Barbearia");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 150));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));
        Cima.setName(""); // NOI18N
        Cima.setPreferredSize(new java.awt.Dimension(1920, 150));

        localizacao.setFont(new java.awt.Font("DejaVu Sans Light", 0, 18)); // NOI18N
        localizacao.setForeground(new java.awt.Color(255, 255, 255));
        localizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localizacao.png"))); // NOI18N
        localizacao.setText("Paulo Afonso - BA");

        nome_emp.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        nome_emp.setForeground(new java.awt.Color(255, 255, 255));
        nome_emp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nome_emp.setText("Barbearia do Mãrio");
        nome_emp.setBorder(new javax.swing.border.MatteBorder(null));

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

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barber_principal.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        editarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        editarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarCadastroMouseClicked(evt);
            }
        });

        btnAlterarCadastro.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterarCadastro.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnAlterarCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterar_user.png"))); // NOI18N
        btnAlterarCadastro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAlterarCadastro.setBorderPainted(false);
        btnAlterarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(editarCadastro)
                .addGap(18, 18, 18)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(localizacao)
                    .addComponent(nome_emp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
                .addComponent(sair)
                .addGap(661, 661, 661)
                .addComponent(btnAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarCadastro)
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(nome_emp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localizacao))
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        Centro.setBackground(new java.awt.Color(255, 255, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1920, 960));
        Centro.setMinimumSize(new java.awt.Dimension(1920, 960));
        Centro.setPreferredSize(new java.awt.Dimension(1920, 960));

        labelSejaBemVindo.setFont(new java.awt.Font("Mongolian Baiti", 0, 60)); // NOI18N
        labelSejaBemVindo.setForeground(new java.awt.Color(0, 51, 102));
        labelSejaBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSejaBemVindo.setText("Seja Bem Vindo!");

        btnConsultarAgenda.setBackground(new java.awt.Color(0, 51, 102));
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
        iconConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendario.png"))); // NOI18N
        iconConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        consultaragenda.setBackground(new java.awt.Color(0, 51, 102));
        consultaragenda.setFont(new java.awt.Font("Caladea", 0, 36)); // NOI18N
        consultaragenda.setForeground(new java.awt.Color(255, 255, 255));
        consultaragenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        consultaragenda.setText("Agendamentos");

        javax.swing.GroupLayout btnConsultarAgendaLayout = new javax.swing.GroupLayout(btnConsultarAgenda);
        btnConsultarAgenda.setLayout(btnConsultarAgendaLayout);
        btnConsultarAgendaLayout.setHorizontalGroup(
            btnConsultarAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConsultarAgendaLayout.createSequentialGroup()
                .addGroup(btnConsultarAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(consultaragenda, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnConsultarAgendaLayout.setVerticalGroup(
            btnConsultarAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConsultarAgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconConsultar)
                .addGap(39, 39, 39)
                .addComponent(consultaragenda)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnServico.setBackground(new java.awt.Color(0, 51, 102));
        btnServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServico.setMaximumSize(new java.awt.Dimension(550, 600));
        btnServico.setMinimumSize(new java.awt.Dimension(550, 600));
        btnServico.setPreferredSize(new java.awt.Dimension(550, 600));
        btnServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServicoMouseClicked(evt);
            }
        });

        iconDefinirServico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconDefinirServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tesoura.png"))); // NOI18N
        iconDefinirServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        defirnirservicos.setBackground(new java.awt.Color(0, 51, 102));
        defirnirservicos.setFont(new java.awt.Font("Caladea", 0, 36)); // NOI18N
        defirnirservicos.setForeground(new java.awt.Color(255, 255, 255));
        defirnirservicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defirnirservicos.setText("Serviços");

        javax.swing.GroupLayout btnServicoLayout = new javax.swing.GroupLayout(btnServico);
        btnServico.setLayout(btnServicoLayout);
        btnServicoLayout.setHorizontalGroup(
            btnServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defirnirservicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconDefinirServico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnServicoLayout.setVerticalGroup(
            btnServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconDefinirServico)
                .addGap(38, 38, 38)
                .addComponent(defirnirservicos)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnExpediente.setBackground(new java.awt.Color(0, 51, 102));
        btnExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExpediente.setMaximumSize(new java.awt.Dimension(550, 600));
        btnExpediente.setMinimumSize(new java.awt.Dimension(550, 600));
        btnExpediente.setPreferredSize(new java.awt.Dimension(350, 324));
        btnExpediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExpedienteMouseClicked(evt);
            }
        });

        iconAlterarExpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAlterarExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar.png"))); // NOI18N
        iconAlterarExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        alterarexpediente.setBackground(new java.awt.Color(0, 51, 102));
        alterarexpediente.setFont(new java.awt.Font("Caladea", 0, 36)); // NOI18N
        alterarexpediente.setForeground(new java.awt.Color(255, 255, 255));
        alterarexpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alterarexpediente.setText("Expediente");

        javax.swing.GroupLayout btnExpedienteLayout = new javax.swing.GroupLayout(btnExpediente);
        btnExpediente.setLayout(btnExpedienteLayout);
        btnExpedienteLayout.setHorizontalGroup(
            btnExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(alterarexpediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconAlterarExpediente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnExpedienteLayout.setVerticalGroup(
            btnExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExpedienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconAlterarExpediente)
                .addGap(40, 40, 40)
                .addComponent(alterarexpediente)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnCaixa.setBackground(new java.awt.Color(0, 51, 102));
        btnCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaixa.setMaximumSize(new java.awt.Dimension(550, 600));
        btnCaixa.setMinimumSize(new java.awt.Dimension(550, 600));
        btnCaixa.setPreferredSize(new java.awt.Dimension(350, 324));
        btnCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCaixaMouseClicked(evt);
            }
        });

        iconCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caixa.png"))); // NOI18N
        iconCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        caixa.setBackground(new java.awt.Color(0, 51, 102));
        caixa.setFont(new java.awt.Font("Caladea", 0, 36)); // NOI18N
        caixa.setForeground(new java.awt.Color(255, 255, 255));
        caixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        caixa.setText("Caixa");

        javax.swing.GroupLayout btnCaixaLayout = new javax.swing.GroupLayout(btnCaixa);
        btnCaixa.setLayout(btnCaixaLayout);
        btnCaixaLayout.setHorizontalGroup(
            btnCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(caixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnCaixaLayout.setVerticalGroup(
            btnCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconCaixa)
                .addGap(40, 40, 40)
                .addComponent(caixa)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelSejaBemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnConsultarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnServico, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(labelSejaBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnConsultarAgenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnServico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnExpediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(289, Short.MAX_VALUE))
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
        
    }//GEN-LAST:event_sairMouseClicked

    private void editarCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarCadastroMouseClicked
        
    }//GEN-LAST:event_editarCadastroMouseClicked

    private void btnConsultarAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarAgendaMouseClicked
        TelaAgendamentos TCA = new TelaAgendamentos();
        TCA.receberCodUsr(CODBARBEARIA, NOMEBARBEARIA);
        TCA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultarAgendaMouseClicked

    private void btnServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicoMouseClicked
        TelaServicos TDS = new TelaServicos();
        TDS.receberCodBarbearia(CODBARBEARIA);
        TDS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnServicoMouseClicked

    private void btnExpedienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpedienteMouseClicked
        TelaExpediente TAE = new TelaExpediente();
        TAE.receberCodBarbearia(CODBARBEARIA);
        TAE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExpedienteMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        new TelaLoginBarbearia().setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCadastroActionPerformed
        TCB.atualizarCadastro(CODBARBEARIA);
        TCB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAlterarCadastroActionPerformed

    private void btnCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaixaMouseClicked
        TelaCaixa TC = new TelaCaixa();
        TC.receberCod(CODBARBEARIA);
        TC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCaixaMouseClicked

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
    private javax.swing.JButton btnAlterarCadastro;
    private javax.swing.JPanel btnCaixa;
    private javax.swing.JPanel btnConsultarAgenda;
    private javax.swing.JPanel btnExpediente;
    private javax.swing.JPanel btnServico;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel caixa;
    private javax.swing.JLabel consultaragenda;
    private javax.swing.JLabel defirnirservicos;
    private javax.swing.JLabel editarCadastro;
    private javax.swing.JLabel iconAlterarExpediente;
    private javax.swing.JLabel iconCaixa;
    private javax.swing.JLabel iconConsultar;
    private javax.swing.JLabel iconDefinirServico;
    private javax.swing.JLabel labelSejaBemVindo;
    private javax.swing.JLabel localizacao;
    private javax.swing.JLabel nome_emp;
    private javax.swing.JLabel sair;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
