package controller;

import dao.ExpedienteDAO;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Expediente;
import java.time.LocalTime;

public class ExpedienteController {
    ExpedienteDAO expedienteDao = new ExpedienteDAO();
    ImageIcon iconConfirmar = AgendamentoController.createIcon("../images/confirmar.png");
    
    /*=========================================CADASTRO DE EXPEDIENTE==============================================================*/
    
    public boolean controller(Expediente e){
        if(e.getPeriodo()==2){
            return verificarDiferencaEntreDatas(e);
        }else{
            return verificarDiferencaEntreHoras(e);
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
        if(e.getHoraInicial().before(e.getHoraFinal())){
            return consultarNoBanco(e);
        }else{
            JOptionPane.showMessageDialog(null, "Hora Inicial maior que a Hora Final", "Mensagem", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
    public boolean consultarNoBanco(Expediente e){
        if(e.getPeriodo()==2){
            if(expedienteDao.consultarPeriodoExpediente(e)){
                return adicionarExpediente(e);
            }else{
                JOptionPane.showMessageDialog(null, "Expediente já cadastrado", "Mensagem", JOptionPane.ERROR_MESSAGE);        
                return false;
            }
        }else{
            if(expedienteDao.consultarDataExpediente(e)){
                return adicionarExpediente(e);
            }else{
                JOptionPane.showMessageDialog(null, "Expediente já cadastrado", "Mensagem", JOptionPane.ERROR_MESSAGE);        
                return false;
            }
        }
        
    }
    
    public boolean adicionarExpediente(Expediente e){
        if(e.getPeriodo()==2){
            if(expedienteDao.adicionarPeriodoExpediente(e)){
                JOptionPane.showMessageDialog(null, "Período de expediente cadastrado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar periodo de expediente", "Mensagem", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
        }else{
            if(expedienteDao.adicionarDataExpediente(e)){
                JOptionPane.showMessageDialog(null, "Expediente cadastrado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar expediente", "Mensagem", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
        }
    }
    
    /*=========================================ALTERAÇÃO DE CADASTRO DE EXPEDIENTE==============================================================*/
    
    public boolean controllerUpdate(Expediente e){
        return verificarDiferencaEntreHorasUpdate(e);
    }
    
    public boolean verificarDiferencaEntreHorasUpdate(Expediente e){
        LocalTime horaInicial = e.getHoraInicial().toLocalTime();
        LocalTime horaFinal = e.getHoraFinal().toLocalTime();
        
        if(horaInicial.isBefore(horaFinal)){
            return consultarNoBancoUpdate(e);
        }else{
            JOptionPane.showMessageDialog(null, "Hora Inicial maior que a Hora Final", "Mensagem", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
    public boolean consultarNoBancoUpdate(Expediente e){
        if(expedienteDao.verificarDataBarbearia(e)){
            return alterarExpediente(e);
        }else{
            JOptionPane.showMessageDialog(null, "Esse dia não está cadastrado", "Mensagem", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
    public boolean alterarExpediente(Expediente e){

            if(expedienteDao.alterarExpediente(e)){
                JOptionPane.showMessageDialog(null, "Expediente alterado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o expediente", "Mensagem", JOptionPane.ERROR_MESSAGE);   
                return false;
            }
    }
    
    public static ImageIcon createIcon(String path) { //CRIANDO O ICONE DE CONFIRMAÇÃO PARA O JOPTIONPANE
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(AgendamentoController.class.getResource(path)));
    }
}
