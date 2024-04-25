

package controller;

import dao.AgendamentoDAO;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Agendamento;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalTime;




public class AgendamentoController {
    ImageIcon iconConfirmar = AgendamentoController.createIcon("../images/confirmar.png");
    AgendamentoDAO AgendamentoDao = new AgendamentoDAO();
    
    public boolean controller(Agendamento agendamento){
        return verificarPreenchimentoCampos(agendamento);
    }
    
    public boolean verificarPreenchimentoCampos(Agendamento agendamento){
        if(agendamento.getHora().getTime()!=0 && agendamento.getCodbarbearia()>0 && agendamento.getCodcliente()>0 && agendamento.getServico()!=0){
            return verificarSeDataAntesDeHoje(agendamento);
        }else{
            JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            return false;
        }
    }
    
    public boolean verificarSeDataAntesDeHoje(Agendamento agendamento){
        LocalDate dataDeHoje = LocalDate.now(); //pega a data de hoje
        LocalDate dataDeOntem = dataDeHoje.minusDays(1); //transforma na data de ontem
        Date dataDeOntemSql = Date.valueOf(dataDeOntem); // converte do tipo time.LocalDate para sql.Date
        Date dataDeHojeSql = Date.valueOf(dataDeHoje); // converte do tipo time.LocalDate para sql.Date

        if(agendamento.getData().after(dataDeOntemSql)){
            if(dataDeHojeSql.equals(agendamento.getData())){
                return verificarHoraAntesDeAgora(agendamento);
            }else{
                return verificarDataDaBarbearia(agendamento);
            }
        }else{
            JOptionPane.showMessageDialog(null, "A data informada é anterior ao dia de hoje. Por favor selecione uma data correta.", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            return false;
        }
    }
    
    public boolean verificarHoraAntesDeAgora(Agendamento agendamento){
        //LocalDate dataDeHoje = LocalDate.now(); //pega a data de hoje
        LocalTime agora = LocalTime.now();
        LocalTime horario = agendamento.getHora().toLocalTime();
        if(horario.isAfter(agora)){
            return verificarDataDaBarbearia(agendamento);
        }else{
            JOptionPane.showMessageDialog(null, "A data informada é anterior ao dia de hoje. Por favor selecione uma data correta.", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            return false;
        }
    }
    
    public boolean verificarDataDaBarbearia(Agendamento agendamento){
        if(AgendamentoDao.verificarDataBarbearia(agendamento.getData(), agendamento.getCodbarbearia())){
            return verificarHorarioDaBarbearia(agendamento);
        }else{
            JOptionPane.showMessageDialog(null, "A Barbearia não funcionará neste dia. Selecione outro.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean verificarHorarioDaBarbearia(Agendamento agendamento){
        if(AgendamentoDao.verificarHorarioBarbearia(agendamento.getData(), agendamento.getHora(), agendamento.getCodbarbearia())){ //verificando se o horario informado está dentro do range do expediente
            return compararAgendamentoNoBanco(agendamento);
        }else{
            JOptionPane.showMessageDialog(null, "A Barbearia não funcionará neste horário. Selecione outro", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean compararAgendamentoNoBanco(Agendamento agendamento){
        if(AgendamentoDao.checkInformacoes(agendamento.getData(), agendamento.getHora(), agendamento.getCodbarbearia())){
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
