package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Agendamento;
import java.sql.Time;
import java.sql.Date;
//import java.util.Date;


public class AgendamentoDAO {
    public void create(Agendamento a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO agendamento (DATA, HORARIO, FK_CODBARBEARIA, FK_CODCLIENTE) VALUES(?,?,?,?)");
            stmt.setDate(1, a.getData());
            stmt.setTime(2, a.getHora());
            stmt.setInt(3, a.getCodbarbearia());
            stmt.setInt(4, a.getCodcliente());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
    public List<Agendamento> consultarAgendamentosCliente(int codcliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT a.FK_CODBARBEARIA, a.CODAGENDAMENTO, a.FK_CODCLIENTE, a.DATA, a.HORARIO, b.NOMESOCIAL"
                    + " FROM barbearia b"
                    + " JOIN agendamento a ON b.CODBARBEARIA = a.FK_CODBARBEARIA"
                    + " WHERE a.FK_CODCLIENTE=?");
            stmt.setInt(1, codcliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setNomebarbearia(rs.getString("NOMESOCIAL"));
                agendamento.setData(rs.getDate("DATA"));
                agendamento.setHora(rs.getTime("HORARIO"));
                agendamento.setCodcliente(rs.getInt("FK_CODCLIENTE"));
                agendamento.setCodbarbearia(rs.getInt("FK_CODBARBEARIA"));
                agendamento.setId(rs.getInt("CODAGENDAMENTO"));
                agendamentos.add(agendamento);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return agendamentos;
    }
    
    public boolean checkInformacoes(Date data, Time hora){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM AGENDAMENTO WHERE (DATA=? AND HORARIO=?)");
                stmt.setDate(1, data);
                stmt.setTime(2, hora);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    check = true;
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return check;  
        }
    
    public List<Agendamento> consultarAgendamentosBarbearia(int codbarbearia){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT a.CODAGENDAMENTO, a.FK_CODCLIENTE, a.DATA, a.HORARIO, c.NOME"
                    + " FROM cliente c"
                    + " JOIN agendamento a ON c.CODCLIENTE = a.FK_CODCLIENTE"
                    + " WHERE a.FK_CODBARBEARIA=?");
            stmt.setInt(1, codbarbearia);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setNomecliente(rs.getString("c.NOME"));
                agendamento.setData(rs.getDate("a.DATA"));
                agendamento.setHora(rs.getTime("a.HORARIO"));
                agendamento.setCodcliente(rs.getInt("a.FK_CODCLIENTE"));
                agendamento.setId(rs.getInt("a.CODAGENDAMENTO"));
                agendamentos.add(agendamento);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return agendamentos;
    }
    
    public void updateAgendamentoCliente(Agendamento a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE agendamento SET DATA=?, HORARIO=? WHERE CODAGENDAMENTO=?");
            stmt.setDate(1, a.getData());
            stmt.setTime(2, a.getHora());
            stmt.setInt(3, a.getId()); 
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void deleteAgendamentoCliente(int CODAGENDAMENTO) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM agendamento WHERE CODAGENDAMENTO = ?");
            stmt.setInt(1, CODAGENDAMENTO);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
