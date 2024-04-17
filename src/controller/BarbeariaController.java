package controller;

import dao.BarbeariaDAO;
import javax.swing.JOptionPane;
import model.Barbearia;

public class BarbeariaController {
    public boolean verificarBarbearia(Barbearia b){
        boolean check;
        //VERIFICAR PREENCHIMENTO DOS CAMPOS
        if(b.getNome()!=null && b.getNome().length()>0 && 
                b.getCnpj()!=null && b.getNome().length()>0 && 
                b.getEmail()!=null && b.getEmail().length()>0 &&
                b.getTelefone1()!=null && b.getTelefone1().length()>0 && 
                b.getTelefone2()!=null && b.getTelefone2().length()>0 && 
                b.getLogin()!=null && b.getLogin().length()>0 && 
                b.getSenha()!=null && b.getSenha().length()>0 &&
                b.getDescricao()!=null && b.getDescricao().length()>0 && 
                b.getRua()!=null && b.getRua().length()>0 &&
                b.getNumero()!=null && b.getNumero().length()>0 && 
                b.getBairro()!=null && b.getBairro().length()>0 && 
                b.getCidade()!=null && b.getCidade().length()>0 && 
                b.getUf()!=null && b.getUf().length()>0 &&
                b.getRegra1()!=null && b.getRegra1().length()>0 && 
                b.getRegra2()!=null && b.getRegra2().length()>0 &&
                b.getRegra3()!=null && b.getRegra3().length()>0 && 
                b.getRegra4()!=null && b.getRegra4().length()>0 
                ){
            check = verificarNoBanco(b);
            return check;
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
        check = false;
        }
        return check;
    }
    
    public boolean verificarNoBanco(Barbearia b){
        BarbeariaDAO dao = new BarbeariaDAO();
        boolean check, valor;
        check = dao.checkInformacoes(b);
        if(check){
            JOptionPane.showMessageDialog(null, "Já existe Barbearia com esse CNPJ/EMAIL/LOGIN", "Mensagem", JOptionPane.ERROR_MESSAGE);
            valor = false;
        }else{
            //Barbearia b = new Barbearia(b);
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
    
    public boolean verificarUpdateBarbearia(Barbearia b){
        boolean check;
        if(b.getId()>0 &&
                b.getNome()!=null && b.getNome().length()>0 && 
                b.getCnpj()!=null && b.getNome().length()>0 && 
                b.getEmail()!=null && b.getEmail().length()>0 &&
                b.getTelefone1()!=null && b.getTelefone1().length()>0 && 
                b.getTelefone2()!=null && b.getTelefone2().length()>0 && 
                b.getLogin()!=null && b.getLogin().length()>0 && 
                b.getSenha()!=null && b.getSenha().length()>0 &&
                b.getDescricao()!=null && b.getDescricao().length()>0 && 
                b.getRua()!=null && b.getRua().length()>0 &&
                b.getNumero()!=null && b.getNumero().length()>0 && 
                b.getBairro()!=null && b.getBairro().length()>0 && 
                b.getCidade()!=null && b.getCidade().length()>0 && 
                b.getUf()!=null && b.getUf().length()>0 &&
                b.getRegra1()!=null && b.getRegra1().length()>0 && 
                b.getRegra2()!=null && b.getRegra2().length()>0 &&
                b.getRegra3()!=null && b.getRegra3().length()>0 && 
                b.getRegra4()!=null && b.getRegra4().length()>0 
                ){
            b.atualizarCadastro(b);
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
            check=true;
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            check = false;
        }
        return check;
    }
}