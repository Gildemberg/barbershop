package controller;

import model.Funcionario;

public class FuncionarioController {
    public boolean cadastrarFuncionario(String nome, String login, String senha, String cpf, String email, String cel, int emp_cod){
        if(nome!=null && nome.length()>0 && login!=null && login.length()>0 && senha!=null && senha.length()>0 && cpf!=null && cpf.length()>0 && email!=null && email.length()>0 && cel!=null && cel.length()>0 && emp_cod>0){
            Funcionario f = new Funcionario(nome, login, senha, cpf, email, cpf, emp_cod);
            f.cadastrarFuncionario(f);
            return true;
        }
        return false;
    }
}
