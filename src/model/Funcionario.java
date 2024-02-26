
package model;

import dao.FuncionarioDAO;

public class Funcionario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String tel;
    private String email;
    private String cpf;
    private int emp_cod;

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

    public int getEmp_cod() {
        return emp_cod;
    }

    public void setEmp_cod(int emp_cod) {
        this.emp_cod = emp_cod;
    }
    
    public Funcionario(){
        
    }
    
    public Funcionario(String nome, String login, String senha, String cpf, String email, String cel, int emp_cod){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.tel = cel;
        this.emp_cod = emp_cod;
    }
    
    public void cadastrarFuncionario(Funcionario f){
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.create(f);
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
