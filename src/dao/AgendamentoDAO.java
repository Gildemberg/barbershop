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


public class AgendamentoDAO {
    public void create(Agendamento a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO agendamento (DATA, HORARIO, FK_CODBARBEARIA, FK_CODCLIENTE) VALUES(?,?,?,?)");
            stmt.setString(1, a.getData());
            stmt.setString(2, a.getHora());
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
        
    public List<Agendamento> read(int codcliente){
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
                agendamento.setData(rs.getString("DATA"));
                agendamento.setHora(rs.getString("HORARIO"));
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
    
    public boolean checkInformacoes(String data, String hora){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM AGENDAMENTO WHERE (DATA=? AND HORARIO=?)");
                stmt.setString(1, data);
                stmt.setString(2, hora);
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
    
    public List<Agendamento> readEmp(int codbarbearia){
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
                agendamento.setNomecliente(rs.getString("USR_NOME"));
                agendamento.setData(rs.getString("AGEND_DATA"));
                agendamento.setHora(rs.getString("AGEND_HORA"));
                agendamento.setCodcliente(rs.getInt("AGEND_USR_COD"));
                agendamento.setId(rs.getInt("AGEND_COD"));
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
    
    public void update(Agendamento a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE agendamento SET DATA=?, HORARIO=? WHERE CODAGENDAMENTO=?");
            stmt.setString(1, a.getData());
            stmt.setString(2, a.getHora());
            stmt.setInt(3, a.getId()); 
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(int CODAGENDAMENTO) {
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
