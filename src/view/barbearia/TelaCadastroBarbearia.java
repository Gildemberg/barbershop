package view.barbearia;

import API.ViaCEP;
import controller.BarbeariaController;
import dao.BarbeariaDAO;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Barbearia;
import javax.swing.text.*;
import API.Endereco;

public class TelaCadastroBarbearia extends javax.swing.JFrame {
    boolean update=false;
    int CODBARBEARIA;
    Barbearia b = new Barbearia();
    BarbeariaController barbeariaController = new BarbeariaController();
    BarbeariaDAO barbeariaDao = new BarbeariaDAO();
    List<Barbearia> InfoBarbearia = new ArrayList();
    
    
    public TelaCadastroBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }
    
    public void atualizarCadastro(int CODBARBEARIA){
        update=true;
        this.CODBARBEARIA = CODBARBEARIA;
        InfoBarbearia = barbeariaDao.readUpdateCadastro(CODBARBEARIA);
        
        btnCadastrar.setText("ATUALIZAR");
        titulo.setText("ATUALIZAR CADASTRO");
        txtNome.setText(InfoBarbearia.get(0).getNome());
        txtCNPJ.setText(InfoBarbearia.get(0).getCnpj());
        txtLogin.setText(InfoBarbearia.get(0).getLogin());
        txtSenha.setText(InfoBarbearia.get(0).getSenha());
        txtEmail.setText(InfoBarbearia.get(0).getEmail());
        txtTelefone1.setText(InfoBarbearia.get(0).getTelefone1());
        txtTelefone2.setText(InfoBarbearia.get(0).getTelefone2());
        txtRua.setText(InfoBarbearia.get(0).getRua());
        txtNumero.setText(InfoBarbearia.get(0).getNumero());
        txtBairro.setText(InfoBarbearia.get(0).getBairro());
        txtCidade.setText(InfoBarbearia.get(0).getCidade());
        txtUf.setText(InfoBarbearia.get(0).getUf());
        txtRegra1.setText(InfoBarbearia.get(0).getRegra1());
        txtRegra2.setText(InfoBarbearia.get(0).getRegra2());
        txtRegra3.setText(InfoBarbearia.get(0).getRegra3());
        txtRegra4.setText(InfoBarbearia.get(0).getRegra4());
        txtDescricao.setText(InfoBarbearia.get(0).getDescricao());
    }
    
    public void recadastrar(int CODBARBEARIA){
        boolean check;
        b.setId(CODBARBEARIA);
        b.setNome(txtNome.getText());
        b.setCnpj(txtCNPJ.getText());
        b.setLogin(txtLogin.getText());
        b.setSenha(txtSenha.getText());
        b.setRsenha(txtRSenha.getText());
        b.setTelefone1(txtTelefone1.getText());
        b.setTelefone2(txtTelefone2.getText());
        b.setEmail(txtEmail.getText());
        b.setRua(txtRua.getText());
        b.setNumero(txtNumero.getText());
        b.setBairro(txtBairro.getText());
        b.setCidade(txtCidade.getText());
        b.setUf(txtUf.getText());
        b.setRegra1(txtRegra1.getText());
        b.setRegra2(txtRegra2.getText());
        b.setRegra3(txtRegra3.getText());
        b.setRegra4(txtRegra4.getText());
        b.setDescricao(txtDescricao.getText());

        barbeariaController.verificarUpdateBarbearia(b);
    }
      
    public void cadastrar(){
        boolean check;
        b.setNome(txtNome.getText());
        b.setCnpj(txtCNPJ.getText());
        b.setLogin(txtLogin.getText());
        b.setSenha(txtSenha.getText());
        b.setRsenha(txtRSenha.getText());
        b.setTelefone1(txtTelefone1.getText());
        b.setTelefone2(txtTelefone2.getText());
        b.setEmail(txtEmail.getText());
        b.setRua(txtRua.getText());
        b.setNumero(txtNumero.getText());
        b.setBairro(txtBairro.getText());
        b.setCidade(txtCidade.getText());
        b.setUf(txtUf.getText());
        b.setRegra1(txtRegra1.getText());
        b.setRegra2(txtRegra2.getText());
        b.setRegra3(txtRegra3.getText());
        b.setRegra4(txtRegra4.getText());
        b.setDescricao(txtDescricao.getText());

        check = barbeariaController.verificarBarbearia(b);
        if(check){ 
            limparCampos();
        }
    }
    
    public void limparCampos(){
        txtNome.setText("");
        txtCNPJ.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtTelefone1.setText("");
        txtTelefone2.setText("");
        txtEmail.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtUf.setText("");
        txtRegra1.setText("");
        txtRegra2.setText("");
        txtRegra3.setText("");
        txtRegra4.setText("");
        txtDescricao.setText("");
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
        rsenha = new javax.swing.JLabel();
        txtRSenha = new javax.swing.JPasswordField();
        telefone1 = new javax.swing.JLabel();
        txtTelefone1 = new javax.swing.JFormattedTextField();
        telefone2 = new javax.swing.JLabel();
        txtTelefone2 = new javax.swing.JFormattedTextField();
        email = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rua = new javax.swing.JLabel();
        cep = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
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
        setTitle("Tela Cadastro de Barbearia");
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
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addContainerGap(110, Short.MAX_VALUE)
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EsquerdaLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel2))
                            .addComponent(Logo))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Nome1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))))
                .addContainerGap())
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
        );

        Direita.setBackground(new java.awt.Color(0, 153, 255));
        Direita.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Direita.setPreferredSize(new java.awt.Dimension(1200, 1080));
        Direita.setRequestFocusEnabled(false);

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saida.png"))); // NOI18N
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
        nome_social.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        nome_social.setForeground(new java.awt.Color(255, 255, 255));
        nome_social.setText("NOME SOCIAL:");

        txtNome.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setDocument(new LimitaNroCaracteres(100));

        cnpj.setBackground(new java.awt.Color(255, 255, 255));
        cnpj.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        cnpj.setForeground(new java.awt.Color(255, 255, 255));
        cnpj.setText("CNPJ:");

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## ### ###/####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCNPJ.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        login.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOGIN:");

        txtLogin.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setDocument(new LimitaNroCaracteres(10));

        senha.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        senha.setForeground(new java.awt.Color(255, 255, 255));
        senha.setText("SENHA:");

        txtSenha.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setDocument(new LimitaNroCaracteres(15));

        rsenha.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        rsenha.setForeground(new java.awt.Color(255, 255, 255));
        rsenha.setText("REPITA A SENHA:");

        txtRSenha.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setDocument(new LimitaNroCaracteres(15));

        telefone1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        telefone1.setForeground(new java.awt.Color(255, 255, 255));
        telefone1.setText("CELULAR:");

        try {
            txtTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone1.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        telefone2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        telefone2.setForeground(new java.awt.Color(255, 255, 255));
        telefone2.setText("TELEFONE:");

        try {
            txtTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone2.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        email.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("EMAIL:");

        txtEmail.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        rua.setBackground(new java.awt.Color(255, 255, 255));
        rua.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        rua.setForeground(new java.awt.Color(255, 255, 255));
        rua.setText("RUA:");

        cep.setBackground(new java.awt.Color(255, 255, 255));
        cep.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        cep.setForeground(new java.awt.Color(255, 255, 255));
        cep.setText("CEP:");

        txtCep.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCepFocusLost(evt);
            }
        });
        txtCep.setDocument(new LimitaNroCaracteres(8));

        txtRua.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        numero.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        numero.setForeground(new java.awt.Color(255, 255, 255));
        numero.setText("Nº:");

        txtNumero.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        bairro.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        bairro.setForeground(new java.awt.Color(255, 255, 255));
        bairro.setText("BAIRRO:");

        txtBairro.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        cidade.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        cidade.setForeground(new java.awt.Color(255, 255, 255));
        cidade.setText("CIDADE:");

        txtCidade.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        uf.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        uf.setForeground(new java.awt.Color(255, 255, 255));
        uf.setText("UF:");

        txtUf.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N

        regra1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        regra1.setForeground(new java.awt.Color(255, 255, 255));
        regra1.setText("REGRA 1:");

        txtRegra1.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setDocument(new LimitaNroCaracteres(35));

        confirmarDados.setFont(new java.awt.Font("Microsoft JhengHei Light", 2, 18)); // NOI18N
        confirmarDados.setForeground(new java.awt.Color(255, 255, 255));
        confirmarDados.setText("Confirmo que os dados fornecidos são confiáveis e verdadeiros.");

        regra2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        regra2.setForeground(new java.awt.Color(255, 255, 255));
        regra2.setText("REGRA 2:");

        txtRegra2.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setDocument(new LimitaNroCaracteres(35));

        regra3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        regra3.setForeground(new java.awt.Color(255, 255, 255));
        regra3.setText("REGRA 3:");

        txtRegra3.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setDocument(new LimitaNroCaracteres(35));

        regra4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        regra4.setForeground(new java.awt.Color(255, 255, 255));
        regra4.setText("REGRA 4:");

        txtRegra4.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setDocument(new LimitaNroCaracteres(35));

        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        descricao.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        descricao.setForeground(new java.awt.Color(255, 255, 255));
        descricao.setText("DESCRIÇÃO DA BARBEARIA:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Corbel Light", 0, 27)); // NOI18N
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        txtDescricao.setDocument(new LimitaNroCaracteres(300));
        jScrollPane2.setViewportView(txtDescricao);

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sair))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
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
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(regra3)
                                            .addComponent(txtRegra3, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(regra4)
                                            .addComponent(txtRegra4)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(regra1)
                                            .addComponent(txtRegra1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(regra2)
                                            .addComponent(txtRegra2))))
                                .addGap(137, 137, 137))
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rua)
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
                                            .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nome_social)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cnpj)
                                            .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                            .addComponent(txtEmail)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(DireitaLayout.createSequentialGroup()
                                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(DireitaLayout.createSequentialGroup()
                                                .addComponent(login)
                                                .addGap(192, 192, 192)
                                                .addComponent(senha)
                                                .addGap(222, 222, 222)))
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rsenha)
                                            .addComponent(txtRSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(128, 128, 128))
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cep)
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addGap(362, 362, 362)
                                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addComponent(txtCep, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addGap(844, 844, 844)))))
                .addContainerGap())
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
                    .addComponent(nome_social)
                    .addComponent(cnpj))
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
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
                .addGap(0, 0, 0)
                .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
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
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regra1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regra2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegra1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegra2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regra3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regra4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegra3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegra4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(confirmarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
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
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
            .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(update){
            recadastrar(CODBARBEARIA);
        }else{
            cadastrar();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        if(update){
            TelaPrincipalBarbearia TPB = new TelaPrincipalBarbearia();
            TPB.receberCodBarbearia(CODBARBEARIA);
            TPB.setVisible(true);
            this.dispose();
        }else{
            this.setVisible(false);
            new TelaLoginBarbearia().setVisible(true);
        }
    }//GEN-LAST:event_sairMouseClicked

    private void txtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCepFocusLost
        try {
            Endereco endereco = ViaCEP.buscaEnderecoPelo(txtCep.getText());
            txtRua.setText(endereco.getLogradouro());
            txtBairro.setText(endereco.getBairro());
            txtCidade.setText(endereco.getLocalidade());
            txtUf.setText(endereco.getUf());
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroBarbearia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCepFocusLost

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

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
    
    public class LimitaNroCaracteres extends PlainDocument {
        private final int iMaxLength;
        public LimitaNroCaracteres(int maxlen) {
            super();
            iMaxLength = maxlen;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (iMaxLength <= 0){
                super.insertString(offset, str, attr);
                return;
            }

            int ilen = (getLength() + str.length());
            if (ilen <= iMaxLength){
                super.insertString(offset, str, attr);   // ...aceita str
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Nome1;
    private javax.swing.JLabel bairro;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel cep;
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
    private javax.swing.JLabel rsenha;
    private javax.swing.JLabel rua;
    private javax.swing.JLabel sair;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel telefone1;
    private javax.swing.JLabel telefone2;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JPasswordField txtRSenha;
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
