package controller;

import model.Usuario;

public class UsuarioController {
    public boolean cadastrarCliente(String nome, String cpf, String login, String senha, String tel, String email){
        if(nome!=null && nome.length()>0 && cpf!=null && cpf.length()>0 && login!=null && login.length()>0 && senha!=null && senha.length()>0 && tel!=null && tel.length()>0 && email!=null && email.length()>0 ){
            Usuario c = new Usuario(nome, cpf, login, senha, tel, email);
            c.cadastrarCliente(c);
            return true;
        }
        
        return false;
    }
}