
package controller;

import dao.AgendamentoDAO;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Agendamento;



public class AgendamentoController {
        public boolean verificarAgendamento(String data, String hora, int CODBARBEARIA, int CODCLIENTE, int CODAGENDAMENTO){
        boolean check;
        //VERIFICAR PREENCHIMENTO DOS CAMPOS
        if(data!=null && data.length()>0 && 
                hora!=null && hora.length()>0 && 
                CODBARBEARIA>0 && CODCLIENTE>0
                ){
            check = verificarNoBanco(data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO);
            return check;
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
        check = false;
        }
        return check;
    }
    
    public boolean verificarNoBanco(String data, String hora, int CODBARBEARIA, int CODCLIENTE, int CODAGENDAMENTO){
        ImageIcon iconConfirmar = AgendamentoController.createIcon("../images/confirmar.png");
        AgendamentoDAO dao = new AgendamentoDAO();
        boolean check, valor;
        check = dao.checkInformacoes(data, hora);
        if(check){
            JOptionPane.showMessageDialog(null, "Esse horário não está disponível.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            valor = false;
        }else{
            if(CODAGENDAMENTO != 0){// ALTERARANDO O AGENDAMENTO
                Agendamento a = new Agendamento(data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO);   
                a.alterarAgendamento(a);
                JOptionPane.showMessageDialog(null, "Agendamento Alterado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                valor = true;
            }else{ //AGENDANDO PELA PRIMEIRA VEZ
                Agendamento a = new Agendamento(data, hora, CODBARBEARIA, CODCLIENTE, 0);   
                a.agendarHorario(a);
                JOptionPane.showMessageDialog(null, "Agendamento Realizado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                valor = true;
            }
        }
        return valor;
    }
    
    public static ImageIcon createIcon(String path) { //CRIANDO O ICONE DE CONFIRMAÇÃO PARA O JOPTIONPANE
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(AgendamentoController.class.getResource(path)));
    }
}
