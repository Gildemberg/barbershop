package controller;

import dao.BarbeariaDAO;
import javax.swing.JOptionPane;
import model.Barbearia;

public class BarbeariaController {
    public boolean verificarBarbearia(String nome, String cnpj, String endereco, String email, String telefone1, String telefone2, String login, String senha, String descricao, String regra1, String regra2, String regra3, String regra4){
        boolean check;
        //VERIFICAR PREENCHIMENTO DOS CAMPOS
        if(nome!=null && nome.length()>0 && 
                cnpj!=null && cnpj.length()>0 && 
                email!=null && email.length()>0 &&
                telefone1!=null && telefone1.length()>0 && 
                telefone2!=null && telefone2.length()>0 && 
                login!=null && login.length()>0 && 
                senha!=null && senha.length()>0 
                ){
            check = verificarNoBanco(nome, cnpj, endereco, email, telefone1, login, senha, descricao, regra1, regra2, regra3, regra4);
            return check;
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
        check = false;
        }
        return check;
    }
    
    public boolean verificarNoBanco(String nome, String cnpj, String endereco, String email, String telefone1, String login, String senha, String descricao, String regra1, String regra2, String regra3, String regra4){
        BarbeariaDAO dao = new BarbeariaDAO();
        boolean check, valor;
        check = dao.checkInformacoes(cnpj, email, telefone1, login);
        if(check){
            JOptionPane.showMessageDialog(null, "Já existe Barbearia com esse CNPJ/EMAIL/LOGIN", "Mensagem", JOptionPane.ERROR_MESSAGE);
            valor = false;
        }else{
            Barbearia b = new Barbearia(nome, cnpj, endereco, email, telefone1, login, senha, descricao, regra1, regra2, regra3, regra4);
            b.cadastrarBarbearia(b);
            JOptionPane.showMessageDialog(null, "Barbearia cadastrado com sucesso!");
            valor = true;
        }
        return valor;
    }
    
    public boolean validarLogin(String login, String senha){
        BarbeariaDAO dao = new BarbeariaDAO();
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