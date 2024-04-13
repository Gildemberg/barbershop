
package controller;

import dao.AgendamentoDAO;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Agendamento;
import java.sql.Time;
import java.sql.Date;



public class AgendamentoController {
    public boolean verificarAgendamento(Date data, Time hora, int CODBARBEARIA, int CODCLIENTE, int CODAGENDAMENTO){
        boolean retorno;
        //VERIFICAR PREENCHIMENTO DOS CAMPOS
        if(hora.getTime()!=0 && 
                CODBARBEARIA>0 && CODCLIENTE>0
                ){
            retorno = verificarNoBanco(data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO);
            return retorno;
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
        retorno = false;
        }
        return retorno;
    }
    
    /*public boolean verificarNoBancoBarbearia(String data, String hora, int CODBARBEARIA, int CODCLIENTE, int CODAGENDAMENTO){;;;;;;;
        boolean verificacao, retorno=true;
        AgendamentoDAO dao = new AgendamentoDAO();
        
        verificacao = dao.verificarHorarioBarbearia(data, hora, CODBARBEARIA);
        if(verificacao){
            
        }else{
            
            retorno = verificarNoBanco(data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO);
        }
        
        return retorno;
    }*/
    
    public boolean verificarNoBanco(Date data, Time hora, int CODBARBEARIA, int CODCLIENTE, int CODAGENDAMENTO){
        ImageIcon iconConfirmar = AgendamentoController.createIcon("../images/confirmar.png");
        AgendamentoDAO dao = new AgendamentoDAO();
        boolean verificacao, retorno;
        verificacao = dao.checkInformacoes(data, hora);
        if(verificacao){
            JOptionPane.showMessageDialog(null, "Esse horário não está disponível.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            retorno = false;
        }else{
            if(CODAGENDAMENTO != 0){// ALTERARANDO O AGENDAMENTO
                Agendamento a = new Agendamento(data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO);   
                a.alterarAgendamento(a);
                JOptionPane.showMessageDialog(null, "Agendamento Alterado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                retorno = true;
            }else{ //AGENDANDO PELA PRIMEIRA VEZ
                Agendamento a = new Agendamento(data, hora, CODBARBEARIA, CODCLIENTE, 0);   
                a.agendarHorario(a);
                JOptionPane.showMessageDialog(null, "Agendamento Realizado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                retorno = true;
            }
        }
        return retorno;
    }
    
    public static ImageIcon createIcon(String path) { //CRIANDO O ICONE DE CONFIRMAÇÃO PARA O JOPTIONPANE
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(AgendamentoController.class.getResource(path)));
    }
}
