package model;

import dao.ClienteDAO;

public class Cliente {
    private int codcliente;
    private String nome;
    private String login;
    private String senha;
    private String telefone;
    private String email;
    private String cpf;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return codcliente;
    }

    public void setId(int id) {
        this.codcliente = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
