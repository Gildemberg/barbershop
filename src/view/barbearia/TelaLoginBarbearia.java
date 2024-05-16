package view.barbearia;

import controller.BarbeariaController;
import css.BordaArredondada;
import dao.BarbeariaDAO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import view.TelaInicial;

public class TelaLoginBarbearia extends javax.swing.JFrame {

    public TelaLoginBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
    }
    
    public void login(){
        boolean check;
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        
        BarbeariaController barbeariaController = new BarbeariaController();
        check = barbeariaController.validarLogin(login, senha);
        
        if(check){
            BarbeariaDAO BarbeariaDao = new BarbeariaDAO(); //instanciando a classe ClienteDAO
            int CODBARBEARIA = BarbeariaDao.retornoCod(login, senha); //Realizando a consulta do cod usr atravez do login e senha usr
            TelaPrincipalBarbearia TA = new TelaPrincipalBarbearia(); //instanciando a classe Tela Principal
            TA.receberCodBarbearia(CODBARBEARIA); //transferindo o codigo usr pra tela principal
            TA.setVisible(true);
            this.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        Nome1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        Login = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        Senha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        NaoPossuiConta = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JButton();
        Login1 = new javax.swing.JLabel();
        btnVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Login da Barbearia");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));
        Esquerda.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Esquerda.setPreferredSize(new java.awt.Dimension(720, 1080));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon1-removebg-preview.png"))); // NOI18N

        Nome.setBackground(new java.awt.Color(255, 255, 255));
        Nome.setFont(new java.awt.Font("Caladea", 0, 80)); // NOI18N
        Nome.setForeground(new java.awt.Color(255, 255, 255));
        Nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nome.setText("SHOP");

        Nome1.setBackground(new java.awt.Color(255, 255, 255));
        Nome1.setFont(new java.awt.Font("Caladea", 0, 80)); // NOI18N
        Nome1.setForeground(new java.awt.Color(255, 255, 255));
        Nome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nome1.setText("BARBER");

        jLabel2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Transformando estilo em praticidade.");

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(255, 255, 255));
        Direita.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Direita.setName(""); // NOI18N
        Direita.setPreferredSize(new java.awt.Dimension(1200, 1080));
        Direita.setRequestFocusEnabled(false);

        Login.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        Login.setForeground(new java.awt.Color(0, 51, 102));
        Login.setText("Login");

        txtLogin.setFont(new java.awt.Font("DejaVu Sans Light", 0, 24)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(0, 51, 102));
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });
        txtLogin.setBackground(new Color(222, 222, 222, 222));

        BordaArredondada borda = new BordaArredondada(new Color(0, 51, 102), 3, 10);
        Border bordaInterna = BorderFactory.createEmptyBorder(0, 10, 0, 0);
        Border bordaComposta = BorderFactory.createCompoundBorder(borda, bordaInterna);

        txtLogin.setBorder(bordaComposta);

        Senha.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        Senha.setForeground(new java.awt.Color(0, 51, 102));
        Senha.setText("Senha");

        txtSenha.setFont(new java.awt.Font("DejaVu Sans Light", 0, 24)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 51, 102));
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });
        txtSenha.setBackground(new Color(222, 222, 222, 222));
        txtSenha.setBorder(bordaComposta);

        btnEntrar.setBackground(new java.awt.Color(0, 51, 102));
        btnEntrar.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorderPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        NaoPossuiConta.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        NaoPossuiConta.setForeground(new java.awt.Color(0, 51, 102));
        NaoPossuiConta.setText("Ainda não possui uma conta? ");

        btnCadastro.setBackground(new java.awt.Color(0, 153, 255));
        btnCadastro.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(0, 153, 255));
        btnCadastro.setText("Cadastre-se aqui.");
        btnCadastro.setBorder(null);
        btnCadastro.setBorderPainted(false);
        btnCadastro.setContentAreaFilled(false);
        btnCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        Login1.setFont(new java.awt.Font("Caladea", 0, 100)); // NOI18N
        Login1.setForeground(new java.awt.Color(0, 51, 102));
        Login1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login1.setText("Barbearia");

        btnVoltar1.setBackground(new java.awt.Color(0, 36, 73));
        btnVoltar1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnVoltar1.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar-branco.png"))); // NOI18N
        btnVoltar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVoltar1.setBorderPainted(false);
        btnVoltar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addComponent(NaoPossuiConta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastro))
                            .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Login)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Senha)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(Login1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Login1)
                .addGap(106, 106, 106)
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(Senha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NaoPossuiConta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        login();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        new TelaCadastroBarbearia().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_txtLoginKeyPressed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        this.setVisible(false);
        new TelaInicial().setVisible(true);
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginBarbearia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaLoginBarbearia().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Login1;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel NaoPossuiConta;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Nome1;
    private javax.swing.JLabel Senha;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

}
