
package controller;

import dao.AgendamentoDAO;
import dao.ExpedienteDAO;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Agendamento;
import java.sql.Time;
import java.sql.Date;
import java.util.Calendar;



public class AgendamentoController {
    public boolean verificarAgendamento(int servico, Date data, Time hora, int CODBARBEARIA, int CODCLIENTE, int CODAGENDAMENTO){
        boolean retorno;
        //VERIFICAR PREENCHIMENTO DOS CAMPOS
        if(hora.getTime()!=0 && CODBARBEARIA>0 && CODCLIENTE>0){
            
            // Extraindo as horas, minutos e segundos da hora fornecida
            Calendar cal = Calendar.getInstance();
            cal.setTime(hora);
            int horario = cal.get(Calendar.HOUR_OF_DAY);
            if(horario < 7 || horario > 18){ //verificando se o horario informado está dentro do range do expediente
                JOptionPane.showMessageDialog(null, "Informe um horário valido. O Expediente é entre 07:00h e 18:00h", "Mensagem", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            if(servico==0){
                JOptionPane.showMessageDialog(null, "Selecione um serviço", "Mensagem", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            retorno = verificarExpedienteNoBanco(servico, data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO);
            return retorno;
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
        retorno = false;
        }
        return retorno;
    }
    
    public boolean verificarExpedienteNoBanco(int servico, Date data, Time hora, int CODBARBEARIA, int CODCLIENTE, int CODAGENDAMENTO){
        boolean verificacao, retorno;
        ExpedienteDAO dao = new ExpedienteDAO();
        
        verificacao = dao.verificarHorarioBarbearia(data, CODBARBEARIA);
        if(verificacao){
            JOptionPane.showMessageDialog(null, "A Barbearia não funcionará neste dia. Selecione outro.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            retorno = false;
        }else{
            retorno = verificarNoBanco(servico, data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO);
        }
        
        return retorno;
    }
    
    public boolean verificarNoBanco(int servico, Date data, Time hora, int CODBARBEARIA, int CODCLIENTE, int CODAGENDAMENTO){
        ImageIcon iconConfirmar = AgendamentoController.createIcon("../images/confirmar.png");
        AgendamentoDAO dao = new AgendamentoDAO();
        boolean verificacao, retorno;
        verificacao = dao.checkInformacoes(data, hora);
        if(verificacao){
            JOptionPane.showMessageDialog(null, "Esse horário não está disponível.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            retorno = false;
        }else{
            if(CODAGENDAMENTO != 0){// ALTERARANDO O AGENDAMENTO
                Agendamento a = new Agendamento(servico, data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO);   
                a.alterarAgendamento(a);
                JOptionPane.showMessageDialog(null, "Agendamento Alterado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                retorno = true;
            }else{ //AGENDANDO PELA PRIMEIRA VEZ
                Agendamento a = new Agendamento(servico, data, hora, CODBARBEARIA, CODCLIENTE, 0);   
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
