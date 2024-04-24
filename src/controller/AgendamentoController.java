
package controller;

import dao.AgendamentoDAO;
import dao.ExpedienteDAO;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Agendamento;
import java.util.Calendar;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.Time;




public class AgendamentoController {
    ImageIcon iconConfirmar = AgendamentoController.createIcon("../images/confirmar.png");
    ExpedienteDAO ExpedienteDao = new ExpedienteDAO();
    AgendamentoDAO AgendamentoDao = new AgendamentoDAO();
    
    public boolean controller(Agendamento agendamento){
        return verificarPreenchimentoCampos(agendamento);
    }
    
    public boolean verificarPreenchimentoCampos(Agendamento agendamento){
        if(agendamento.getHora().getTime()!=0 && agendamento.getCodbarbearia()>0 && agendamento.getCodcliente()>0 && agendamento.getServico()!=0){
            return verificarData(agendamento);
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            return false;
        }
    }
    
    public boolean verificarData(Agendamento agendamento){
        LocalDate dataDeHoje = LocalDate.now(); //pega a data de hoje
        LocalDate dataDeOntem = dataDeHoje.minusDays(1); //transforma na data de ontem
        Date dataDeOntemSql = Date.valueOf(dataDeOntem); // converte do tipo time.LocalDate para sql.Date
        if(agendamento.getData().after(dataDeOntemSql)){
            return verificarHorario(agendamento);
        }else{
            JOptionPane.showMessageDialog(null, "A data informada é anterior ao dia de hoje. Por favor selecione uma data correta.", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            return false;
        }
    }
    
    public boolean verificarHorario(Agendamento agendamento){
        Time inicioExpediente = Time.valueOf("07:00:00");
        Time fimExpediente = Time.valueOf("18:00:00");
        if(agendamento.getHora().after(inicioExpediente) && agendamento.getHora().before(fimExpediente)){ //verificando se o horario informado está dentro do range do expediente
            return verificarExpedienteNoBanco(agendamento);
        }else{
            JOptionPane.showMessageDialog(null, "Informe um horário valido. O Expediente é entre 07:00h e 18:00h", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean verificarExpedienteNoBanco(Agendamento agendamento){
        if(ExpedienteDao.verificarHorarioBarbearia(agendamento.getData(), agendamento.getCodbarbearia())){
            JOptionPane.showMessageDialog(null, "A Barbearia não funcionará neste dia. Selecione outro.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return compararAgendamentoNoBanco(agendamento);
        }
    }
    
    public boolean compararAgendamentoNoBanco(Agendamento agendamento){
        if(AgendamentoDao.checkInformacoes(agendamento.getData(), agendamento.getHora())){
            JOptionPane.showMessageDialog(null, "Esse horário não está disponível.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            if(agendamento.getCodagendamento() != 0){// ALTERARANDO O AGENDAMENTO
                agendamento.alterarAgendamento(agendamento);
                JOptionPane.showMessageDialog(null, "Agendamento Alterado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                return true;
            }else{ //AGENDANDO PELA PRIMEIRA VEZ
                agendamento.setCodagendamento(0); 
                agendamento.agendarHorario(agendamento);
                JOptionPane.showMessageDialog(null, "Agendamento Realizado!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                return true;
            }
        }
    }
    
    public static ImageIcon createIcon(String path) { //CRIANDO O ICONE DE CONFIRMAÇÃO PARA O JOPTIONPANE
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(AgendamentoController.class.getResource(path)));
    }
}
