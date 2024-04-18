package controller;

import dao.ClienteDAO;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteController {
    public boolean verificarCliente(Cliente c, boolean confirmacaoDados){
        boolean check;
        //VERIFICAR SE TODOS OS CAMPOS ESTÃO PREENCHIDOS
        if(c.getNome()!=null && c.getNome().length()>0 && 
                c.getCpf()!=null && c.getCpf().length()>0 && 
                c.getEmail()!=null && c.getEmail().length()>0 &&
                c.getTelefone()!=null && c.getTelefone().length()>0 && 
                c.getLogin()!=null && c.getLogin().length()>0 && 
                c.getSenha()!=null && c.getSenha().length()>0 
                ){
            if(confirmacaoDados == true){//VERIFICAR SE O CHECKBOX DE CONFIRMAR DADOS CONFIAVEIS ESTÁ SELECIONADO
                check = verificarNoBanco(c);
                return check;
            }else{
                JOptionPane.showMessageDialog(null, "Porfavor, confirme que os dados fornecidos são confiáveis e verdadeiros.", "Mensagem", JOptionPane.ERROR_MESSAGE);
                check = false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            check = false;
        }
        return check;
    }
    
    public boolean verificarNoBanco(Cliente c){
        ClienteDAO dao = new ClienteDAO();
        boolean check, valor;
        check = dao.checkInformacoes(c);
        if(check){
            JOptionPane.showMessageDialog(null, "Já existe usuário com esse CPF/EMAIL/LOGIN", "Mensagem", JOptionPane.ERROR_MESSAGE);
            valor = false;
        }else{
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
    
    public boolean verificarUpdateCliente(Cliente c){
        boolean check;
        //VERIFICAR SE TODOS OS CAMPOS ESTÃO PREENCHIDOS
        if(c.getNome()!=null && c.getNome().length()>0 && 
                c.getCpf()!=null && c.getCpf().length()>0 && 
                c.getEmail()!=null && c.getEmail().length()>0 &&
                c.getTelefone()!=null && c.getTelefone().length()>0 && 
                c.getLogin()!=null && c.getLogin().length()>0 && 
                c.getSenha()!=null && c.getSenha().length()>0 
                ){
            c.atualizarCadastro(c);
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            check = true;
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            check = false;
        }
        return check;
    }
}