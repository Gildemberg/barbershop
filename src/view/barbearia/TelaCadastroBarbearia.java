package view.barbearia;

import controller.BarbeariaController;
import javax.swing.JOptionPane;
import model.Barbearia;

public class TelaCadastroBarbearia extends javax.swing.JFrame {

    public TelaCadastroBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new css.FundoGradiente(0, 51, 102, 0, 0, 0, 0, 0, 1500, 100);
        Logo = new javax.swing.JLabel();
        Nome1 = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Direita = new css.FundoGradiente(0, 191, 255, 65, 105, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        nome_social = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cnpj = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JFormattedTextField();
        login = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        senha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        telefone1 = new javax.swing.JLabel();
        txtTelefone1 = new javax.swing.JFormattedTextField();
        telefone2 = new javax.swing.JLabel();
        txtTelefone2 = new javax.swing.JFormattedTextField();
        email = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rua = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        numero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        bairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        cidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        uf = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        regra1 = new javax.swing.JLabel();
        txtRegra1 = new javax.swing.JTextField();
        confirmarDados = new javax.swing.JLabel();
        regra2 = new javax.swing.JLabel();
        txtRegra2 = new javax.swing.JTextField();
        regra3 = new javax.swing.JLabel();
        txtRegra3 = new javax.swing.JTextField();
        regra4 = new javax.swing.JLabel();
        txtRegra4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        btnCadastrar = new javax.swing.JButton();
        descricao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));
        Esquerda.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Esquerda.setPreferredSize(new java.awt.Dimension(720, 1080));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon1-removebg-preview.png"))); // NOI18N

        Nome1.setBackground(new java.awt.Color(255, 255, 255));
        Nome1.setFont(new java.awt.Font("Caladea", 0, 80)); // NOI18N
        Nome1.setForeground(new java.awt.Color(255, 255, 255));
        Nome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nome1.setText("BARBER");

        Nome.setBackground(new java.awt.Color(255, 255, 255));
        Nome.setFont(new java.awt.Font("Caladea", 0, 80)); // NOI18N
        Nome.setForeground(new java.awt.Color(255, 255, 255));
        Nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nome.setText("SHOP");

        jLabel2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Transformando estilo em praticidade.");

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel2)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(Nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(0, 153, 255));
        Direita.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Direita.setPreferredSize(new java.awt.Dimension(1200, 1080));
        Direita.setRequestFocusEnabled(false);

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sair2.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Arial", 0, 70)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CADASTRE SUA BARBEARIA");

        nome_social.setBackground(new java.awt.Color(255, 255, 255));
        nome_social.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        nome_social.setForeground(new java.awt.Color(255, 255, 255));
        nome_social.setText("NOME SOCIAL:");

        txtNome.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        cnpj.setBackground(new java.awt.Color(255, 255, 255));
        cnpj.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        cnpj.setForeground(new java.awt.Color(255, 255, 255));
        cnpj.setText("CNPJ:");

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## ### ###/####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCNPJ.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        login.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGIN:");

        txtLogin.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        senha.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        senha.setForeground(new java.awt.Color(255, 255, 255));
        senha.setText("SENHA:");

        txtSenha.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        telefone1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        telefone1.setForeground(new java.awt.Color(255, 255, 255));
        telefone1.setText("CELULAR:");

        try {
            txtTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone1.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        telefone2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        telefone2.setForeground(new java.awt.Color(255, 255, 255));
        telefone2.setText("TELEFONE:");

        try {
            txtTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone2.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        email.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("EMAIL:");

        txtEmail.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        rua.setBackground(new java.awt.Color(255, 255, 255));
        rua.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        rua.setForeground(new java.awt.Color(255, 255, 255));
        rua.setText("RUA:");

        txtRua.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        numero.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        numero.setForeground(new java.awt.Color(255, 255, 255));
        numero.setText("Nº:");

        txtNumero.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        bairro.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        bairro.setForeground(new java.awt.Color(255, 255, 255));
        bairro.setText("BAIRRO:");

        txtBairro.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        cidade.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        cidade.setForeground(new java.awt.Color(255, 255, 255));
        cidade.setText("CIDADE:");

        txtCidade.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        uf.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        uf.setForeground(new java.awt.Color(255, 255, 255));
        uf.setText("UF:");

        txtUf.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        regra1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        regra1.setForeground(new java.awt.Color(255, 255, 255));
        regra1.setText("REGRA 1:");

        txtRegra1.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        confirmarDados.setFont(new java.awt.Font("Microsoft JhengHei Light", 2, 18)); // NOI18N
        confirmarDados.setForeground(new java.awt.Color(255, 255, 255));
        confirmarDados.setText("Confirmo que os dados fornecidos são confiáveis e verdadeiros.");

        regra2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        regra2.setForeground(new java.awt.Color(255, 255, 255));
        regra2.setText("REGRA 2:");

        txtRegra2.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        regra3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        regra3.setForeground(new java.awt.Color(255, 255, 255));
        regra3.setText("REGRA 3:");

        txtRegra3.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        regra4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        regra4.setForeground(new java.awt.Color(255, 255, 255));
        regra4.setText("REGRA 4:");

        txtRegra4.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(0, 51, 102));
        btnCadastrar.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        descricao.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 36)); // NOI18N
        descricao.setForeground(new java.awt.Color(255, 255, 255));
        descricao.setText("DESCRIÇÃO DA BARBEARIA:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addComponent(descricao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(137, 137, 137))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sair))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(regra3)
                                            .addComponent(txtRegra3, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(DireitaLayout.createSequentialGroup()
                                                .addComponent(regra4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(txtRegra4)))
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(regra1)
                                            .addComponent(txtRegra1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(DireitaLayout.createSequentialGroup()
                                                .addComponent(regra2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtRegra2)))
                                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(DireitaLayout.createSequentialGroup()
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(DireitaLayout.createSequentialGroup()
                                                    .addComponent(rua)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(txtRua))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(numero)
                                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(bairro)
                                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cidade)
                                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(DireitaLayout.createSequentialGroup()
                                                    .addComponent(uf)
                                                    .addGap(19, 19, 19))
                                                .addComponent(txtUf)))
                                        .addGroup(DireitaLayout.createSequentialGroup()
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nome_social)
                                                .addGroup(DireitaLayout.createSequentialGroup()
                                                    .addComponent(login)
                                                    .addGap(365, 365, 365)
                                                    .addComponent(senha))
                                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cnpj)
                                                .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(DireitaLayout.createSequentialGroup()
                                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(DireitaLayout.createSequentialGroup()
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(telefone1))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(telefone2))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(email)
                                                .addComponent(txtEmail)))))
                                .addGap(131, 131, 131)))
                        .addContainerGap())
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sair))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome_social, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(telefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(telefone1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regra1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regra2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegra1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegra2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regra3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regra4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegra3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegra4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(confirmarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        boolean check;
        String nome = txtNome.getText();
        String cnpj = txtCNPJ.getText();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        String telefone1 = txtTelefone1.getText();
        String telefone2 = txtTelefone2.getText();
        String email = txtEmail.getText();
        String rua = txtRua.getText();
        String numero = txtNumero.getText();
        String bairro = txtBairro.getText();
        String cidade = txtCidade.getText();
        String uf = txtUf.getText();
        String regra1 = txtRegra1.getText();
        String regra2 = txtRegra2.getText();
        String regra3 = txtRegra3.getText();
        String regra4 = txtRegra4.getText();
        String descricao = txtDescricao.getText();

        BarbeariaController barbeariaController = new BarbeariaController();
        check = barbeariaController.verificarBarbearia(nome, cnpj, email, telefone1, telefone2, login, senha, descricao, rua, numero, bairro, cidade, uf, regra1, regra2, regra3, regra4);
        if(check){ // LIMPANDO OS CAMPOS EM CASO DE CADASTRO REALIZADO
            txtNome.setText("");
            txtCNPJ.setText("");
            txtLogin.setText("");
            txtSenha.setText("");
            txtTelefone1.setText("");
            txtEmail.setText("");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        this.setVisible(false);
        new TelaLoginBarbearia().setVisible(true);
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
            java.util.logging.Logger.getLogger(TelaCadastroBarbearia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaCadastroBarbearia().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Nome1;
    private javax.swing.JLabel bairro;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel cnpj;
    private javax.swing.JLabel confirmarDados;
    private javax.swing.JLabel descricao;
    private javax.swing.JLabel email;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel login;
    private javax.swing.JLabel nome_social;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel regra1;
    private javax.swing.JLabel regra2;
    private javax.swing.JLabel regra3;
    private javax.swing.JLabel regra4;
    private javax.swing.JLabel rua;
    private javax.swing.JLabel sair;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel telefone1;
    private javax.swing.JLabel telefone2;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRegra1;
    private javax.swing.JTextField txtRegra2;
    private javax.swing.JTextField txtRegra3;
    private javax.swing.JTextField txtRegra4;
    private javax.swing.JTextField txtRua;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone1;
    private javax.swing.JFormattedTextField txtTelefone2;
    private javax.swing.JTextField txtUf;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
}
