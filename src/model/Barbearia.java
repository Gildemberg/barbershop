package model;

import dao.BarbeariaDAO;

public class Barbearia {
    private int codbarbearia;
    private String cnpj;
    private String nome;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
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
        return codbarbearia;
    }

    public void setId(int id) {
        this.codbarbearia = id;
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

    public Barbearia(String nome, String cnpj, String email, String telefone1, String telefone2, String login, String senha, String descricao, String rua, String numero, String bairro, String cidade, String uf, String regra1, String regra2, String regra3, String regra4) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.login = login;
        this.senha = senha;
        this.descricao = descricao;
        this.regra1 = regra1;
        this.regra2 = regra2;
        this.regra3 = regra3;
        this.regra4 = regra4;
    }
     
    public void cadastrarBarbearia(Barbearia b){
        BarbeariaDAO dao = new BarbeariaDAO();
        dao.create(b);
    }
    
    public void atualizarCadastro(Barbearia b){
        BarbeariaDAO dao = new BarbeariaDAO();
        dao.updateCadastro(b);
    }
}
