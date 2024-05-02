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
import css.BordaArredondada;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

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
        txtRSenha.setText("");
        txtTelefone1.setText("");
        txtTelefone2.setText("");
        txtEmail.setText("");
        txtCep.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtUf.setText("");
        txtDescricao.setText("");
        btnConfirmarDados.setSelected(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Direita = new javax.swing.JPanel();
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
        txtCep = new javax.swing.JFormattedTextField();
        btnCep = new javax.swing.JButton();
        txtRua = new javax.swing.JTextField();
        numero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        bairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        cidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        uf = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        descricao = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextArea();
        btnConfirmarDados = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Cadastro de Barbearia");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Direita.setBackground(new java.awt.Color(255, 255, 255));
        Direita.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Direita.setMinimumSize(new java.awt.Dimension(1920, 1080));
        Direita.setPreferredSize(new java.awt.Dimension(1920, 1080));
        Direita.setRequestFocusEnabled(false);

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Caladea", 1, 70)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 51, 102));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastre sua Barbearia");

        nome_social.setBackground(new java.awt.Color(255, 255, 255));
        nome_social.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        nome_social.setForeground(new java.awt.Color(0, 51, 102));
        nome_social.setText("Nome Social:");

        txtNome.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 51, 102));
        txtNome.setDocument(new LimitaNroCaracteres(100));
        txtNome.setBackground(new Color(222, 222, 222, 222));

        BordaArredondada borda = new BordaArredondada(new Color(0, 51, 102), 3, 10);
        Border bordaInterna = BorderFactory.createEmptyBorder(0, 10, 0, 0);
        Border bordaComposta = BorderFactory.createCompoundBorder(borda, bordaInterna);

        txtNome.setBorder(bordaComposta);

        cnpj.setBackground(new java.awt.Color(255, 255, 255));
        cnpj.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        cnpj.setForeground(new java.awt.Color(0, 51, 102));
        cnpj.setText("CNPJ:");

        txtCNPJ.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## ### ###/####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCNPJ.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtCNPJ.setBackground(new Color(220, 220, 220, 220));
        txtCNPJ.setBorder(bordaComposta);

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        login.setForeground(new java.awt.Color(0, 51, 102));
        login.setText("Login:");

        txtLogin.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(0, 51, 102));
        txtDescricao.setDocument(new LimitaNroCaracteres(10));
        txtLogin.setBackground(new Color(220, 220, 220, 220));
        txtLogin.setBorder(bordaComposta);

        senha.setBackground(new java.awt.Color(255, 255, 255));
        senha.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        senha.setForeground(new java.awt.Color(0, 51, 102));
        senha.setText("Senha:");

        txtSenha.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 51, 102));
        txtSenha.setBackground(new Color(220, 220, 220, 220));
        txtSenha.setBorder(bordaComposta);

        rsenha.setBackground(new java.awt.Color(255, 255, 255));
        rsenha.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        rsenha.setForeground(new java.awt.Color(0, 51, 102));
        rsenha.setText("Repetir Senha:");

        txtRSenha.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtRSenha.setForeground(new java.awt.Color(0, 51, 102));
        txtRSenha.setBackground(new Color(220, 220, 220, 220));
        txtRSenha.setBorder(bordaComposta);

        telefone1.setBackground(new java.awt.Color(255, 255, 255));
        telefone1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        telefone1.setForeground(new java.awt.Color(0, 51, 102));
        telefone1.setText("Celular");

        txtTelefone1.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone1.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtTelefone1.setBackground(new Color(220, 220, 220, 220));
        txtTelefone1.setBorder(bordaComposta);

        telefone2.setBackground(new java.awt.Color(255, 255, 255));
        telefone2.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        telefone2.setForeground(new java.awt.Color(0, 51, 102));
        telefone2.setText("Telefone:");

        txtTelefone2.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone2.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtTelefone2.setBackground(new Color(220, 220, 220, 220));
        txtTelefone2.setBorder(bordaComposta);

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        email.setForeground(new java.awt.Color(0, 51, 102));
        email.setText("Email:");

        txtEmail.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 51, 102));
        txtEmail.setBackground(new Color(220, 220, 220, 220));
        txtEmail.setBorder(bordaComposta);

        rua.setBackground(new java.awt.Color(255, 255, 255));
        rua.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        rua.setForeground(new java.awt.Color(0, 51, 102));
        rua.setText("Logradouro:");

        cep.setBackground(new java.awt.Color(255, 255, 255));
        cep.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        cep.setForeground(new java.awt.Color(0, 51, 102));
        cep.setText("CEP:");

        txtCep.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtCep.setBackground(new Color(220, 220, 220, 220));
        txtCep.setBorder(bordaComposta);

        btnCep.setBackground(new java.awt.Color(0, 36, 73));
        btnCep.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnCep.setForeground(new java.awt.Color(255, 255, 255));
        btnCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnCep.setBorderPainted(false);
        btnCep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCepActionPerformed(evt);
            }
        });

        txtRua.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtRua.setForeground(new java.awt.Color(0, 51, 102));
        txtRua.setBackground(new Color(220, 220, 220, 220));
        txtRua.setBorder(bordaComposta);

        numero.setBackground(new java.awt.Color(255, 255, 255));
        numero.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        numero.setForeground(new java.awt.Color(0, 51, 102));
        numero.setText("Nº:");

        txtNumero.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(0, 51, 102));
        txtNumero.setBackground(new Color(220, 220, 220, 220));
        txtNumero.setBorder(bordaComposta);

        bairro.setBackground(new java.awt.Color(255, 255, 255));
        bairro.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        bairro.setForeground(new java.awt.Color(0, 51, 102));
        bairro.setText("Bairro:");

        txtBairro.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtBairro.setForeground(new java.awt.Color(0, 51, 102));
        txtBairro.setBackground(new Color(220, 220, 220, 220));
        txtBairro.setBorder(bordaComposta);

        cidade.setBackground(new java.awt.Color(255, 255, 255));
        cidade.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        cidade.setForeground(new java.awt.Color(0, 51, 102));
        cidade.setText("Cidade:");

        txtCidade.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(0, 51, 102));
        txtCidade.setBackground(new Color(220, 220, 220, 220));
        txtCidade.setBorder(bordaComposta);

        uf.setBackground(new java.awt.Color(255, 255, 255));
        uf.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        uf.setForeground(new java.awt.Color(0, 51, 102));
        uf.setText("UF:");

        txtUf.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtUf.setForeground(new java.awt.Color(0, 51, 102));
        txtUf.setBackground(new Color(220, 220, 220, 220));
        txtUf.setBorder(bordaComposta);

        descricao.setBackground(new java.awt.Color(255, 255, 255));
        descricao.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        descricao.setForeground(new java.awt.Color(0, 51, 102));
        descricao.setText("Descrição:");

        btnCadastrar.setBackground(new java.awt.Color(0, 36, 73));
        btnCadastrar.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(0, 36, 73));
        btnVoltar.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar.png"))); // NOI18N
        btnVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVoltar.setBorderPainted(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(0, 51, 102));
        txtDescricao.setRows(5);
        txtDescricao.setWrapStyleWord(true);
        txtDescricao.setLineWrap(true);

        txtDescricao.setDocument(new LimitaNroCaracteres(300));
        txtDescricao.setBackground(new Color(220, 220, 220, 220));

        Border bordaD = BorderFactory.createEmptyBorder(0, 10, 0, 0);
        Border bordaCompostaD = BorderFactory.createCompoundBorder(borda, bordaD);

        txtDescricao.setBorder(bordaCompostaD);

        btnConfirmarDados.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnConfirmarDados.setForeground(new java.awt.Color(0, 51, 102));
        btnConfirmarDados.setText("Confirmo que os dados fornecidos são confiáveis e verdadeiros.");
        btnConfirmarDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(DireitaLayout.createSequentialGroup()
                                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telefone1)
                                        .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telefone2))
                                    .addGap(18, 18, 18)
                                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(email)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DireitaLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(DireitaLayout.createSequentialGroup()
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cep)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnCep, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)))
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(rua))
                                            .addGap(18, 18, 18)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(numero)
                                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DireitaLayout.createSequentialGroup()
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bairro))
                                            .addGap(18, 18, 18)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cidade)
                                                .addGroup(DireitaLayout.createSequentialGroup()
                                                    .addComponent(txtCidade)
                                                    .addGap(18, 18, 18)))
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(uf)))
                                        .addGroup(DireitaLayout.createSequentialGroup()
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(login))
                                            .addGap(18, 18, 18)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtSenha)
                                                .addGroup(DireitaLayout.createSequentialGroup()
                                                    .addComponent(senha)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rsenha)
                                                .addComponent(txtRSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DireitaLayout.createSequentialGroup()
                                            .addComponent(btnConfirmarDados)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nome_social))
                                .addGap(18, 18, 18)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cnpj)
                                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descricao)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1661, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome_social)
                            .addComponent(cnpj))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(telefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCep, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtDescricao))
                        .addGap(5, 5, 5)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(rsenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarDados)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Direita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCepActionPerformed
        try {
            String cepMasc = txtCep.getText();
            String cep = cepMasc.replaceAll("[^\\d]", ""); //remover os caracteres
            Endereco endereco = ViaCEP.buscaEnderecoPelo(cep);
            txtRua.setText(endereco.getLogradouro());
            txtBairro.setText(endereco.getBairro());
            txtCidade.setText(endereco.getLocalidade());
            txtUf.setText(endereco.getUf());
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroBarbearia.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnCepActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if(update){
            TelaPrincipalBarbearia TPB = new TelaPrincipalBarbearia();
            TPB.receberCodBarbearia(CODBARBEARIA);
            TPB.setVisible(true);
            this.dispose();
        }else{
            this.setVisible(false);
            new TelaLoginBarbearia().setVisible(true);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

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
    private javax.swing.JLabel bairro;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCep;
    private javax.swing.JRadioButton btnConfirmarDados;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel cep;
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel cnpj;
    private javax.swing.JLabel descricao;
    private javax.swing.JLabel email;
    private javax.swing.JLabel login;
    private javax.swing.JLabel nome_social;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel rsenha;
    private javax.swing.JLabel rua;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel telefone1;
    private javax.swing.JLabel telefone2;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JPasswordField txtRSenha;
    private javax.swing.JTextField txtRua;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone1;
    private javax.swing.JFormattedTextField txtTelefone2;
    private javax.swing.JTextField txtUf;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
}
