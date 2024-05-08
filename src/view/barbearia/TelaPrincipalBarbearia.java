
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
        ola = new javax.swing.JLabel();
        btnDefinirExpediente = new css.JPanelArredondadoBarbearias(30);
        iconDefinirExpediente = new javax.swing.JLabel();
        definirexpediente = new javax.swing.JLabel();
        btnConsultarAgenda = new css.JPanelArredondadoBarbearias(30);
        iconConsultar = new javax.swing.JLabel();
        consultaragenda = new javax.swing.JLabel();
        btnDefinirServico = new css.JPanelArredondadoBarbearias(30);
        iconDefinirServico = new javax.swing.JLabel();
        defirnirservicos = new javax.swing.JLabel();
        btnAlterarExpediente = new css.JPanelArredondadoBarbearias(30);
        iconAlterarExpediente = new javax.swing.JLabel();
        alterarexpediente = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        ola.setFont(new java.awt.Font("Mongolian Baiti", 0, 60)); // NOI18N
        ola.setForeground(new java.awt.Color(0, 51, 102));
        ola.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ola.setText("Seja Bem Vindo!");

        btnDefinirExpediente.setBackground(new java.awt.Color(0, 51, 102));
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
        iconDefinirExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendario-plus.png"))); // NOI18N
        iconDefinirExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        definirexpediente.setBackground(new java.awt.Color(0, 51, 102));
        definirexpediente.setFont(new java.awt.Font("Caladea", 0, 36)); // NOI18N
        definirexpediente.setForeground(new java.awt.Color(255, 255, 255));
        definirexpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        definirexpediente.setText("Definir Expediente");

        javax.swing.GroupLayout btnDefinirExpedienteLayout = new javax.swing.GroupLayout(btnDefinirExpediente);
        btnDefinirExpediente.setLayout(btnDefinirExpedienteLayout);
        btnDefinirExpedienteLayout.setHorizontalGroup(
            btnDefinirExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDefinirExpedienteLayout.createSequentialGroup()
                .addGroup(btnDefinirExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconDefinirExpediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(definirexpediente, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnDefinirExpedienteLayout.setVerticalGroup(
            btnDefinirExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDefinirExpedienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconDefinirExpediente)
                .addGap(40, 40, 40)
                .addComponent(definirexpediente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        consultaragenda.setText("Consultar Agenda");

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

        btnDefinirServico.setBackground(new java.awt.Color(0, 51, 102));
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
        iconDefinirServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tesoura.png"))); // NOI18N
        iconDefinirServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        defirnirservicos.setBackground(new java.awt.Color(0, 51, 102));
        defirnirservicos.setFont(new java.awt.Font("Caladea", 0, 36)); // NOI18N
        defirnirservicos.setForeground(new java.awt.Color(255, 255, 255));
        defirnirservicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defirnirservicos.setText("Definir Serviços");

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
                .addGap(38, 38, 38)
                .addComponent(defirnirservicos)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnAlterarExpediente.setBackground(new java.awt.Color(0, 51, 102));
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
        iconAlterarExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        iconAlterarExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        alterarexpediente.setBackground(new java.awt.Color(0, 51, 102));
        alterarexpediente.setFont(new java.awt.Font("Caladea", 0, 36)); // NOI18N
        alterarexpediente.setForeground(new java.awt.Color(255, 255, 255));
        alterarexpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alterarexpediente.setText("Alterar Expediente");

        javax.swing.GroupLayout btnAlterarExpedienteLayout = new javax.swing.GroupLayout(btnAlterarExpediente);
        btnAlterarExpediente.setLayout(btnAlterarExpedienteLayout);
        btnAlterarExpedienteLayout.setHorizontalGroup(
            btnAlterarExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(alterarexpediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconAlterarExpediente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnAlterarExpedienteLayout.setVerticalGroup(
            btnAlterarExpedienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAlterarExpedienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconAlterarExpediente)
                .addGap(40, 40, 40)
                .addComponent(alterarexpediente)
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
                        .addComponent(ola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnDefinirExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnConsultarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnDefinirServico, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnAlterarExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(ola, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnConsultarAgenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnDefinirExpediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDefinirServico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAlterarExpediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        new TelaLoginBarbearia().setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCadastroActionPerformed
        TCB.atualizarCadastro(CODBARBEARIA);
        TCB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAlterarCadastroActionPerformed

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
    private javax.swing.JPanel btnAlterarExpediente;
    private javax.swing.JPanel btnConsultarAgenda;
    private javax.swing.JPanel btnDefinirExpediente;
    private javax.swing.JPanel btnDefinirServico;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel consultaragenda;
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
