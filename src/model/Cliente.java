package model;

import dao.ClienteDAO;

public class Cliente {
    private int codcliente;
    private String nome;
    private String login;
    private String senha;
    private String rsenha;
    private String telefone;
    private String email;
    private String cpf;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRsenha() {
        return rsenha;
    }

    public void setRsenha(String rsenha) {
        this.rsenha = rsenha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    
    
    public Cliente(){
    }
    
    public Cliente(String nome, String cpf, String login, String senha, String telefone, String email){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
    
    public void cadastrarCliente(Cliente c){
        ClienteDAO dao = new ClienteDAO();
        dao.create(c);
    }
    
    public void atualizarCadastro(Cliente c){
        ClienteDAO dao = new ClienteDAO();
        dao.updateCadastroCliente(c);
    }
}
