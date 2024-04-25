
package controller;

import dao.ExpedienteDAO;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Expediente;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;



public class ExpedienteController {
    ExpedienteDAO expedienteDao = new ExpedienteDAO();
    ImageIcon iconConfirmar = AgendamentoController.createIcon("../images/confirmar.png");
    
    public boolean controller(Expediente e){
        return verificandoFormatoData(e);
    }
    
    public boolean verificandoFormatoData(Expediente e){
        LocalDate dataInicial = e.getDataInicial().toLocalDate();
        LocalDate dataFinal = e.getDataFinal().toLocalDate();
        if(dataInicial.getDayOfMonth()>=01 && dataInicial.getDayOfMonth()<=31 
                                            && dataFinal.getDayOfMonth()>=01 && dataFinal.getDayOfMonth()<=31
                                            && dataInicial.getMonthValue()>=01 && dataInicial.getMonthValue()<=12
                                            && dataFinal.getMonthValue()>=01 && dataFinal.getMonthValue()<=12
                                            && dataInicial.getYear()>=2024 
                                            && dataFinal.getYear()>=124)
        {
            return verificarDiferencaEntreDatas(e);
        }else{
            JOptionPane.showMessageDialog(null, "Data informada está fora do padrão", "Mensagem", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
    public boolean verificarDiferencaEntreDatas(Expediente e){
        if(e.getDataInicial().before(e.getDataFinal())){
            return verificarDiferencaEntreHoras(e);
        }else{
            JOptionPane.showMessageDialog(null, "Data Inicial maior que a Data Final", "Mensagem", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
    public boolean verificarDiferencaEntreHoras(Expediente e){
        if(e.getHoraInicial().before(e.getDataFinal())){
            return consultarNoBanco(e);
        }else{
            JOptionPane.showMessageDialog(null, "Hora Inicial maior que a Hora Final", "Mensagem", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
    public boolean consultarNoBanco(Expediente e){
        if(expedienteDao.consultarDataExpediente(e)){
            return adicionarExpediente(e);
        }else{
            JOptionPane.showMessageDialog(null, "O periodo já foi cadastrado", "Mensagem", JOptionPane.ERROR_MESSAGE);        
            return false;
        }
    }
    
    public boolean adicionarExpediente(Expediente e){
        if(expedienteDao.adicionarDataExpediente(e)){
            JOptionPane.showMessageDialog(null, "O periodo cadastrado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar período", "Mensagem", JOptionPane.ERROR_MESSAGE);   
            return false;
        }
    }
    
    /*-----------------------------------------------------------------------------------------------*/
    
    public boolean controllerUpdate(Expediente e, boolean semExpediente){
        if(semExpediente){
            return consultarNoBancoUpdate(e, semExpediente);
        }else{
            return verificarDiferencaEntreHorasUpdate(e, semExpediente);
        }
    }
    
    public boolean verificarDiferencaEntreHorasUpdate(Expediente e, boolean semExpediente){
        LocalTime horaInicial = e.getHoraInicial().toLocalTime();
        LocalTime horaFinal = e.getHoraFinal().toLocalTime();
        
        if(horaInicial.isBefore(horaFinal)){
            return consultarNoBancoUpdate(e, semExpediente);
        }else{
            JOptionPane.showMessageDialog(null, "Hora Inicial maior que a Hora Final", "Mensagem", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
    public boolean consultarNoBancoUpdate(Expediente e, boolean semExpediente){
        if(expedienteDao.verificarDataBarbearia(e)){
            return alterarExpediente(e, semExpediente);
        }else{
            JOptionPane.showMessageDialog(null, "Esse dia não está cadastrado", "Mensagem", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
    public boolean alterarExpediente(Expediente e, boolean semExpediente){
        if(semExpediente){
            if(expedienteDao.removeExpediente(e)){
                JOptionPane.showMessageDialog(null, "Expediente removido com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar remover o expediente", "Mensagem", JOptionPane.ERROR_MESSAGE);   
                return false;
            }   
        }else{
            if(expedienteDao.alterarExpediente(e)){
                JOptionPane.showMessageDialog(null, "Expediente alterado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o expediente", "Mensagem", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
        }
    }
    
    
    
    
    /*
    public void verificarHorarioNoBanco(Time horaIni, Time horaFim){
        boolean verificacao;
        verificacao = expedienteDao.definirHorarioExpediente(horaIni, horaFim);
        if(verificacao){
            JOptionPane.showMessageDialog(null, "Você já removeu esse dia de expediente.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }else{
            Expediente e = new Expediente(data, CODBARBEARIA);   
            e.removerExpediente(e);
            JOptionPane.showMessageDialog(null, "Expediente removido!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
        }
    }
*/
    
    public static ImageIcon createIcon(String path) { //CRIANDO O ICONE DE CONFIRMAÇÃO PARA O JOPTIONPANE
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(AgendamentoController.class.getResource(path)));
    }
}
