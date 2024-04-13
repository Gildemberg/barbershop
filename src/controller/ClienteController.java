package controller;

import dao.ClienteDAO;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteController {
    public boolean verificarCliente(String nome, String cpf, String email, String telefone, String login, String senha){
        boolean check;
        //VERIFICAR PREENCHIMENTO DOS CAMPOS
        if(nome!=null && nome.length()>0 && 
                cpf!=null && cpf.length()>0 && 
                email!=null && email.length()>0 &&
                telefone!=null && telefone.length()>0 && 
                login!=null && login.length()>0 && 
                senha!=null && senha.length()>0 
                ){
            check = verificarNoBanco(nome, cpf, email, telefone, login, senha);
            return check;
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
        check = false;
        }
        return check;
    }
    
    public boolean verificarNoBanco(String nome, String cpf, String email, String telefone, String login, String senha){
        ClienteDAO dao = new ClienteDAO();
        boolean check, valor;
        check = dao.checkInformacoes(cpf, email, telefone, login);
        if(check){
            JOptionPane.showMessageDialog(null, "Já existe usuário com esse CPF/EMAIL/LOGIN", "Mensagem", JOptionPane.ERROR_MESSAGE);
            valor = false;
        }else{
            Cliente c = new Cliente(nome, cpf, login, senha, telefone, email);
            c.cadastrarCliente(c);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            valor = true;
        }
        return valor;
    }
    
    public boolean validarLogin(String login, String senha){
        ClienteDAO dao = new ClienteDAO();
        boolean check;
        check = dao.checkLogin(login, senha);
        if(check){
            return check;
        }else{
            JOptionPane.showMessageDialog(null, "Dados inseridos incorretamente!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return check;
        }
    }
}