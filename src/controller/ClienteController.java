package controller;

import dao.ClienteDAO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteController {
    ImageIcon iconConfirmar = AgendamentoController.createIcon("../images/confirmar.png");
    
    /*=========================================CADASTRO DE CLIENTE==============================================================*/

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
                if(c.getRsenha().equals(c.getSenha())){//VERIFICAR SE AS SENHAS ESTÃO COMPATIVEIS
                    check = verificarNoBanco(c);
                    return check;
                }else{
                    JOptionPane.showMessageDialog(null, "As senhas estão diferentes.", "Mensagem", JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
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
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
            valor = true;
        }
        return valor;
    }
    
    /*=========================================ATUALIZAR CADASTRO DE CLIENTE==============================================================*/
    
    public boolean verificarUpdateCliente(Cliente c, boolean confirmacaoDados){
        boolean check;
        //VERIFICAR SE TODOS OS CAMPOS ESTÃO PREENCHIDOS
        if(c.getNome()!=null && c.getNome().length()>0 && 
                c.getCpf()!=null && c.getCpf().length()>0 && 
                c.getEmail()!=null && c.getEmail().length()>0 &&
                c.getTelefone()!=null && c.getTelefone().length()>0 && 
                c.getLogin()!=null && c.getLogin().length()>0 && 
                c.getSenha()!=null && c.getSenha().length()>0 && 
                c.getRsenha()!=null && c.getRsenha().length()>0 
                ){
            
            if(confirmacaoDados == true){//VERIFICAR SE O CHECKBOX DE CONFIRMAR DADOS CONFIAVEIS ESTÁ SELECIONADO
                if(c.getRsenha().equals(c.getSenha())){//VERIFICAR SE AS SENHAS ESTÃO COMPATIVEIS
                    c.atualizarCadastro(c);
                    JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                    check = true;
                }else{
                    JOptionPane.showMessageDialog(null, "As senhas estão diferentes.", "Mensagem", JOptionPane.ERROR_MESSAGE);
                    check = false;
                }
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
    
    /*=========================================VERIFICAÇÃO DE LOGIN==============================================================*/
    
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