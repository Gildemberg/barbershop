package view.barbearia;

import controller.BarbeariaController;
import css.BordaArredondada;
import dao.BarbeariaDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Servico;

public class TelaServicos extends javax.swing.JFrame {
    int CODBARBEARIA, opcao=1;
    boolean check;
    Servico modelServico = new Servico();
    BarbeariaController barbeariaController = new BarbeariaController();
    List<Servico> servicos = new ArrayList();
    String Servico;
    float Valor;
    int codservico;
    
    
    public TelaServicos() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
        
        jTableDiario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Verifica se foi um clique duplo (ou apenas um clique simples)
                if (e.getClickCount() == 1) {
                    txtServico.setText("");
                    txtValor.setText("");
                    
                    int row = jTableDiario.getSelectedRow(); // Índice da linha selecionada

                    // Obter os dados da linha selecionada
                    codservico = (int) jTableDiario.getValueAt(row, 0);
                    Servico = (String) jTableDiario.getValueAt(row, 1);
                    Valor = (float) jTableDiario.getValueAt(row, 2);
                }
            }
        });
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){
        this.CODBARBEARIA = CODBARBEARIA;
        listarServicos();
    }
    
    public void listarServicos(){
        BarbeariaDAO barberDao = new BarbeariaDAO();
        servicos = barberDao.readServico(CODBARBEARIA);
        
        String[] colunas = {"#","Serviço", "Valor"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        
        for (Servico s : servicos) {
            Object[] row = {
                s.getCodservico(),
                s.getNome(),
                s.getValor()
            };
            tableModel.addRow(row);
        }
        jTableDiario.setModel(tableModel);
    }
    
    public void cadastrarServico(){
        modelServico.setNome(txtServico.getText());
        modelServico.setValor(Float.valueOf(txtValor.getText()));
        modelServico.setCODBARBEARIA(CODBARBEARIA);
        modelServico.setOpcao(opcao);
        check=barbeariaController.verificarServico(modelServico);
        if(check){
            txtServico.setText("");
            txtValor.setText("");
            listarServicos();
        }
    }
    
    public void alterarServico(){
        modelServico.setNome(txtServico.getText());
        modelServico.setValor(Float.valueOf(txtValor.getText()));
        modelServico.setCODBARBEARIA(CODBARBEARIA);
        modelServico.setOpcao(opcao);
        modelServico.setCodservico(codservico);
        check=barbeariaController.verificarServico(modelServico);
        if(check){
            txtServico.setText("");
            txtValor.setText("");
            listarServicos();
        }
    }
    
    public void deletarServico(){
        modelServico.setNome(Servico);
        modelServico.setValor(Valor);
        modelServico.setCODBARBEARIA(CODBARBEARIA);
        modelServico.setOpcao(opcao);
        modelServico.setCodservico(codservico);
        check=barbeariaController.verificarServico(modelServico);
        if(check){
            txtServico.setText("");
            txtValor.setText("");
            listarServicos();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        Centro = new javax.swing.JPanel();
        Esquerda = new javax.swing.JPanel();
        labelExtratos = new javax.swing.JLabel();
        jScrollPaneDiario = new css.ScrollPaneWin11();
        jTableDiario = new css.TableDark();
        btnAlterar = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JLabel();
        labelFunServico = new javax.swing.JLabel();
        labelServico = new javax.swing.JLabel();
        txtServico = new javax.swing.JTextField();
        labelValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Cadastro de Serviços");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 150));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));
        Cima.setPreferredSize(new java.awt.Dimension(1920, 150));

        titulo.setFont(new java.awt.Font("Caladea", 1, 90)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Serviço");

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

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
                .addComponent(icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addComponent(icon)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(CimaLayout.createSequentialGroup()
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(titulo))
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Centro.setBackground(new java.awt.Color(0, 102, 153));
        Centro.setMaximumSize(new java.awt.Dimension(1920, 930));
        Centro.setMinimumSize(new java.awt.Dimension(1920, 930));

        Esquerda.setBackground(new java.awt.Color(255, 255, 255));

        labelExtratos.setFont(new java.awt.Font("Caladea", 1, 48)); // NOI18N
        labelExtratos.setForeground(new java.awt.Color(0, 51, 102));
        labelExtratos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExtratos.setText("Meus Serviços");
        labelExtratos.setBorder(new javax.swing.border.MatteBorder(null));

        jScrollPaneDiario.setBackground(new java.awt.Color(102, 153, 255));

        jTableDiario.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
        jTableDiario.setForeground(new java.awt.Color(255, 255, 255));
        jTableDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Serviço", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneDiario.setViewportView(jTableDiario);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modificar.png"))); // NOI18N
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adicionar.png"))); // NOI18N
        btnAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarMouseClicked(evt);
            }
        });

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deletar.png"))); // NOI18N
        btnDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(labelExtratos, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(EsquerdaLayout.createSequentialGroup()
                                .addComponent(btnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionar))
                            .addComponent(jScrollPaneDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelExtratos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPaneDiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar)
                    .addComponent(btnDeletar)
                    .addComponent(btnAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneDiario.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

        labelFunServico.setFont(new java.awt.Font("Caladea", 1, 48)); // NOI18N
        labelFunServico.setForeground(new java.awt.Color(255, 255, 255));
        labelFunServico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFunServico.setText("Cadastrar");
        labelFunServico.setBorder(new javax.swing.border.MatteBorder(null));

        labelServico.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        labelServico.setForeground(new java.awt.Color(255, 255, 255));
        labelServico.setText("Serviço");

        txtServico.setBackground(new java.awt.Color(255, 255, 255));
        txtServico.setFont(new java.awt.Font("DejaVu Sans Light", 0, 24)); // NOI18N
        txtServico.setForeground(new java.awt.Color(0, 51, 102));
        BordaArredondada borda = new BordaArredondada(new Color(0, 51, 102), 3, 10);
        Border bordaInterna = BorderFactory.createEmptyBorder(0, 10, 0, 0);
        Border bordaComposta = BorderFactory.createCompoundBorder(borda, bordaInterna);
        txtServico.setBackground(new Color(222, 222, 222, 222));
        txtServico.setBorder(bordaComposta);

        labelValor.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        labelValor.setForeground(new java.awt.Color(255, 255, 255));
        labelValor.setText("Valor (R$)");

        txtValor.setBackground(new java.awt.Color(255, 255, 255));
        txtValor.setFont(new java.awt.Font("DejaVu Sans Light", 0, 24)); // NOI18N
        txtValor.setForeground(new java.awt.Color(0, 51, 102));
        txtValor.setBackground(new Color(222, 222, 222, 222));
        txtValor.setBorder(bordaComposta);

        btnCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setFont(new java.awt.Font("Caladea", 0, 36)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(0, 51, 102));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(labelFunServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelServico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtServico, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(231, 231, 231))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(316, 316, 316))))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(labelFunServico, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(labelServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(labelValor)
                .addGap(18, 18, 18)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Centro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, 1925, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        switch (opcao) {
            case 1 -> cadastrarServico();
            case 2 -> alterarServico();
            default -> deletarServico();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TP.receberCodBarbearia(CODBARBEARIA);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        int linhaSelecionada = jTableDiario.getSelectedRow();
        if(linhaSelecionada==-1){
            JOptionPane.showMessageDialog(null, "Selecione um serviço.");
        }else{
            opcao=2;
            labelFunServico.setText("Alterar Serviço");
            btnCadastrar.setText("Alterar");
            txtServico.setText(Servico);
            String valor = String.valueOf(Valor);
            txtValor.setText(valor);
            txtServico.setEditable(true);
            txtValor.setEditable(true);
        }
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletarMouseClicked
        int linhaSelecionada = jTableDiario.getSelectedRow();
        if(linhaSelecionada==-1){
            JOptionPane.showMessageDialog(null, "Selecione um serviço.");
        }else{
            opcao=3;
            labelFunServico.setText("Deletar Serviço");
            btnCadastrar.setText("Deletar");
            txtServico.setText(Servico);
            String valor = String.valueOf(Valor);
            txtValor.setText(valor);
            txtServico.setEditable(false);
            txtValor.setEditable(false);
        }
    }//GEN-LAST:event_btnDeletarMouseClicked

    private void btnAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarMouseClicked
        labelFunServico.setText("Cadastrar Serviço");
        btnCadastrar.setText("Cadastrar");
        opcao=1;
        txtServico.setText("");
        txtValor.setText("");
        txtServico.setEditable(true);
        txtValor.setEditable(true);
    }//GEN-LAST:event_btnAdicionarMouseClicked

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> {
            new TelaServicos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JLabel btnAdicionar;
    private javax.swing.JLabel btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel btnDeletar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel icon;
    private javax.swing.JScrollPane jScrollPaneDiario;
    private javax.swing.JTable jTableDiario;
    private javax.swing.JLabel labelExtratos;
    private javax.swing.JLabel labelFunServico;
    private javax.swing.JLabel labelServico;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtServico;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
