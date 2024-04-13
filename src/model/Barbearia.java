package model;

import dao.BarbeariaDAO;

public class Barbearia {
    private int id;
    private String cnpj;
    private String nome;
    private String endereco;
    private String email;
    private String telefone1;
    private String telefone2;
    private String login;
    private String senha;
    private String descricao;
    private String regra1;
    private String regra2;
    private String regra3;
    private String regra4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }
    
    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
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
    
    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getRegra1(){
        return regra1;
    }

    public void setRegra1(String regra1) {
        this.regra1 = regra1;
    }
    
    public String getRegra2(){
        return regra2;
    }

    public void setRegra2(String regra2) {
        this.regra2 = regra2;
    }
    
    public String getRegra3(){
        return regra3;
    }

    public void setRegra3(String regra3) {
        this.regra3 = regra3;
    }
    
    public String getRegra4(){
        return regra4;
    }

    public void setRegra4(String regra4) {
        this.regra4 = regra4;
    }
    
    public Barbearia(){
    }

    public Barbearia(String nome, String cnpj, String endereco, String email, String telefone, String login, String senha, String descricao, String regra1, String regra2, String regra3, String regra4) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone1 = telefone1;
        //this.telefone2 = telefone2;
        this.login = login;
        this.senha = senha;
        this.descricao = descricao;
        this.regra1 = regra1;
        this.regra2 = regra2;
        this.regra3 = regra3;
        this.regra4 = regra4;
    }
     
    public void cadastrarBarbearia(Barbearia c){
        BarbeariaDAO dao = new BarbeariaDAO();
        dao.create(c);
    }
}
