
package controller;

import dao.ExpedienteDAO;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Expediente;
import java.sql.Date;



public class ExpedienteController {
    public static ImageIcon createIcon(String path) { //CRIANDO O ICONE DE CONFIRMAÇÃO PARA O JOPTIONPANE
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(AgendamentoController.class.getResource(path)));
    }
    
    public void verificarExpedienteNoBanco(Date data, int CODBARBEARIA){
        ImageIcon iconConfirmar = ExpedienteController.createIcon("../images/confirmar.png");
        ExpedienteDAO dao = new ExpedienteDAO();
        boolean verificacao;
        verificacao = dao.verificarHorarioBarbearia(data, CODBARBEARIA);
        if(verificacao){
            JOptionPane.showMessageDialog(null, "Você já removeu esse dia de expediente.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }else{
            Expediente e = new Expediente(data, CODBARBEARIA);   
            e.removerExpediente(e);
            JOptionPane.showMessageDialog(null, "Expediente removido!", "Mensagem", JOptionPane.PLAIN_MESSAGE, (Icon) iconConfirmar);
        }
    }
}
