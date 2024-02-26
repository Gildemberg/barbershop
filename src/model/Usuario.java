
package model;

import dao.UsuarioDAO;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String tel;
    private String email;
    private String cpf;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Usuario(){
    }
    
    public Usuario(String nome, String cpf, String login, String senha, String tel, String email){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tel = tel;
        this.email = email;
        this.cpf = cpf;
    }
    
    public void cadastrarCliente(Usuario c){
        UsuarioDAO dao = new UsuarioDAO();
        dao.create(c);
    }
}
