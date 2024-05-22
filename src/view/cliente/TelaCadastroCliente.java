package view.cliente;

import API.Endereco;
import API.ViaCEP;
import controller.ClienteController;
import css.BordaArredondada;
import dao.ClienteDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import model.Cliente;

public class TelaCadastroCliente extends javax.swing.JFrame {
    
    boolean update = false;
    Cliente modelCliente = new Cliente();
    List<Cliente> cliente = new ArrayList();
    ClienteController clienteController = new ClienteController();
    ClienteDAO clientedao = new ClienteDAO();
    
    public TelaCadastroCliente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }

    public void alterarCadastro(int CODCLIENTE){              
        cliente=clientedao.read(CODCLIENTE);
        this.update = true;
        
        titulo.setText("Atualização de Cadastro");
        cadastrar.setText("Atualizar");
        txtCPF.setText(cliente.get(0).getCpf());
        txtNome.setText(cliente.get(0).getNome());
        txtEmail.setText(cliente.get(0).getEmail());
        txtTel.setText(cliente.get(0).getTelefone());
        txtLogin.setText(cliente.get(0).getLogin());
        txtSenha.setText(cliente.get(0).getSenha());
        txtRSenha.setText(cliente.get(0).getRsenha());
        txtRua.setText(cliente.get(0).getRua());
        txtNumero.setText(cliente.get(0).getNumero());
        txtBairro.setText(cliente.get(0).getBairro());
        txtCidade.setText(cliente.get(0).getCidade());
        txtUf.setText(cliente.get(0).getUf());
    }
    
    public void recadastrarCliente(){
        boolean check;
        boolean confirmacaoDados = btnConfirmacaoDados.isSelected();
        
        modelCliente.setCodcliente(cliente.get(0).getCodcliente());
        modelCliente.setCpf(txtCPF.getText());
        modelCliente.setNome(txtNome.getText());
        modelCliente.setEmail(txtEmail.getText());
        modelCliente.setTelefone(txtTel.getText());
        modelCliente.setLogin(txtLogin.getText());
        modelCliente.setSenha(txtSenha.getText());
        modelCliente.setRsenha(txtRSenha.getText());
        modelCliente.setRua(txtRua.getText());
        modelCliente.setNumero(txtNumero.getText());
        modelCliente.setBairro(txtBairro.getText());
        modelCliente.setCidade(txtCidade.getText());
        modelCliente.setUf(txtUf.getText());
        clienteController.verificarUpdateCliente(modelCliente, confirmacaoDados);
    }
    
    public void cadastrarCliente(){
        boolean check;
        boolean confirmacaoDados = btnConfirmacaoDados.isSelected();
        
        modelCliente.setNome(txtNome.getText());
        modelCliente.setCpf(txtCPF.getText());
        modelCliente.setLogin(txtLogin.getText());
        modelCliente.setSenha(txtSenha.getText());
        modelCliente.setRsenha(txtRSenha.getText());
        modelCliente.setTelefone(txtTel.getText());
        modelCliente.setEmail(txtEmail.getText());
        modelCliente.setRua(txtRua.getText());
        modelCliente.setNumero(txtNumero.getText());
        modelCliente.setBairro(txtBairro.getText());
        modelCliente.setCidade(txtCidade.getText());
        modelCliente.setUf(txtUf.getText());

        check = clienteController.verificarCliente(modelCliente, confirmacaoDados);
        if(check){
            TelaLoginCliente TLC = new TelaLoginCliente();
            TLC.setVisible(true);
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Direita = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cpf = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        login = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        senha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        rsenha = new javax.swing.JLabel();
        txtRSenha = new javax.swing.JPasswordField();
        celular = new javax.swing.JLabel();
        txtTel = new javax.swing.JFormattedTextField();
        email = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        confirmarDados = new javax.swing.JLabel();
        btnConfirmacaoDados = new javax.swing.JRadioButton();
        cadastrar = new javax.swing.JButton();
        cep = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        btnCep = new javax.swing.JButton();
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
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Cadastro de Cliente");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Direita.setBackground(new java.awt.Color(255, 255, 255));
        Direita.setMaximumSize(new java.awt.Dimension(1920, 1080));
        Direita.setMinimumSize(new java.awt.Dimension(1920, 1080));
        Direita.setPreferredSize(new java.awt.Dimension(1920, 1080));
        Direita.setRequestFocusEnabled(false);

        titulo.setFont(new java.awt.Font("Caladea", 1, 70)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 51, 102));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CADASTRE-SE");

        nome.setBackground(new java.awt.Color(255, 255, 255));
        nome.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome.setForeground(new java.awt.Color(0, 51, 102));
        nome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 27)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 51, 102));
        txtNome.setBackground(new Color(220, 220, 220, 220));

        BordaArredondada borda = new BordaArredondada(new Color(0, 51, 102), 3, 10);
        Border bordaInterna = BorderFactory.createEmptyBorder(0, 10, 0, 0);
        Border bordaComposta = BorderFactory.createCompoundBorder(borda, bordaInterna);

        txtNome.setBorder(bordaComposta);

        cpf.setBackground(new java.awt.Color(255, 255, 255));
        cpf.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        cpf.setForeground(new java.awt.Color(0, 51, 102));
        cpf.setText("CPF:");

        txtCPF.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 27)); // NOI18N
        txtCPF.setBackground(new Color(220, 220, 220, 220));

        txtCPF.setBorder(bordaComposta);

        login.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        login.setForeground(new java.awt.Color(0, 51, 102));
        login.setText("Login:");

        txtLogin.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 27)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(0, 51, 102));
        txtLogin.setBackground(new Color(220, 220, 220, 220));

        txtLogin.setBorder(bordaComposta);

        senha.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        senha.setForeground(new java.awt.Color(0, 51, 102));
        senha.setText("Senha:");

        txtSenha.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 27)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 51, 102));
        txtSenha.setBackground(new Color(220, 220, 220, 220));

        txtSenha.setBorder(bordaComposta);

        rsenha.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        rsenha.setForeground(new java.awt.Color(0, 51, 102));
        rsenha.setText("Repita a Senha:");

        txtRSenha.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 27)); // NOI18N
        txtRSenha.setForeground(new java.awt.Color(0, 51, 102));
        txtRSenha.setBackground(new Color(220, 220, 220, 220));

        txtRSenha.setBorder(bordaComposta);

        celular.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        celular.setForeground(new java.awt.Color(0, 51, 102));
        celular.setText("Celular:");

        txtTel.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTel.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 27)); // NOI18N
        txtTel.setBackground(new Color(220, 220, 220, 220));

        txtTel.setBorder(bordaComposta);

        email.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        email.setForeground(new java.awt.Color(0, 51, 102));
        email.setText("Email:");

        txtEmail.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 27)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 51, 102));
        txtEmail.setBackground(new Color(220, 220, 220, 220));

        txtEmail.setBorder(bordaComposta);

        confirmarDados.setFont(new java.awt.Font("Microsoft JhengHei Light", 3, 18)); // NOI18N
        confirmarDados.setForeground(new java.awt.Color(0, 51, 102));
        confirmarDados.setText("Confirmo que os dados fornecidos são confiáveis e verdadeiros.");

        btnConfirmacaoDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cadastrar.setBackground(new java.awt.Color(0, 51, 102));
        cadastrar.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        cadastrar.setText("Cadastrar");
        cadastrar.setBorderPainted(false);
        cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        cep.setBackground(new java.awt.Color(255, 255, 255));
        cep.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
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

        rua.setBackground(new java.awt.Color(255, 255, 255));
        rua.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        rua.setForeground(new java.awt.Color(0, 51, 102));
        rua.setText("Logradouro:");

        txtRua.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtRua.setForeground(new java.awt.Color(0, 51, 102));
        txtRua.setBackground(new Color(220, 220, 220, 220));
        txtRua.setBorder(bordaComposta);

        numero.setBackground(new java.awt.Color(255, 255, 255));
        numero.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        numero.setForeground(new java.awt.Color(0, 51, 102));
        numero.setText("Nº:");

        txtNumero.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(0, 51, 102));
        txtNumero.setBackground(new Color(220, 220, 220, 220));
        txtNumero.setBorder(bordaComposta);

        bairro.setBackground(new java.awt.Color(255, 255, 255));
        bairro.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        bairro.setForeground(new java.awt.Color(0, 51, 102));
        bairro.setText("Bairro:");

        txtBairro.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtBairro.setForeground(new java.awt.Color(0, 51, 102));
        txtBairro.setBackground(new Color(220, 220, 220, 220));
        txtBairro.setBorder(bordaComposta);

        cidade.setBackground(new java.awt.Color(255, 255, 255));
        cidade.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        cidade.setForeground(new java.awt.Color(0, 51, 102));
        cidade.setText("Cidade:");

        txtCidade.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(0, 51, 102));
        txtCidade.setBackground(new Color(220, 220, 220, 220));
        txtCidade.setBorder(bordaComposta);

        uf.setBackground(new java.awt.Color(255, 255, 255));
        uf.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        uf.setForeground(new java.awt.Color(0, 51, 102));
        uf.setText("UF:");

        txtUf.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 24)); // NOI18N
        txtUf.setForeground(new java.awt.Color(0, 51, 102));
        txtUf.setBackground(new Color(220, 220, 220, 220));
        txtUf.setBorder(bordaComposta);

        btnVoltar.setBackground(new java.awt.Color(0, 36, 73));
        btnVoltar.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar-branco.png"))); // NOI18N
        btnVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVoltar.setBorderPainted(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(825, 825, 825)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(email)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rsenha))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addComponent(nome)
                                        .addGap(803, 803, 803)
                                        .addComponent(cpf))
                                    .addComponent(celular)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addComponent(btnConfirmacaoDados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(confirmarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(login)
                                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addComponent(senha))
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bairro))
                                        .addGap(18, 18, 18)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cidade)
                                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(uf)))
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(DireitaLayout.createSequentialGroup()
                                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCep, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cep))
                                        .addGap(18, 18, 18)
                                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rua)
                                            .addGroup(DireitaLayout.createSequentialGroup()
                                                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(numero)
                                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(cpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(celular)
                    .addComponent(email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cep)
                    .addComponent(numero)
                    .addComponent(rua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCep, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairro)
                    .addComponent(cidade)
                    .addComponent(uf))
                .addGap(18, 18, 18)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(senha)
                    .addComponent(rsenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirmarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmacaoDados))
                .addGap(34, 34, 34)
                .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        if(update){
            recadastrarCliente();
        }else{
            cadastrarCliente();
        }
    }//GEN-LAST:event_cadastrarActionPerformed

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
            Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCepActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if(update){
            TelaPrincipalCliente TPC = new TelaPrincipalCliente();
            TPC.receberCodCliente(cliente.get(0).getCodcliente());
            TPC.setVisible(true);
            this.dispose();
        }else{   
            this.setVisible(false);
            new TelaLoginCliente().setVisible(true);
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
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaCadastroCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Direita;
    private javax.swing.JLabel bairro;
    private javax.swing.JButton btnCep;
    private javax.swing.JRadioButton btnConfirmacaoDados;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel cep;
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel confirmarDados;
    private javax.swing.JLabel cpf;
    private javax.swing.JLabel email;
    private javax.swing.JLabel login;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel rsenha;
    private javax.swing.JLabel rua;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JPasswordField txtRSenha;
    private javax.swing.JTextField txtRua;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JTextField txtUf;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
