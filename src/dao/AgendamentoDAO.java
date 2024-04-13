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
            stmt = con.prepareStatement("INSERT INTO agendamento (AGEND_USR_COD,AGEND_EMP_COD,AGEND_DATA,AGEND_HORA) VALUES(?,?,?,?)");
            stmt.setInt(1, a.getCod_usr());
            stmt.setInt(2, a.getCod_emp());
            stmt.setString(3, a.getData());
            stmt.setString(4, a.getHora());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
    public List<Agendamento> read(int cod_usr){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT agendamento.AGEND_EMP_COD, agendamento.AGEND_COD, agendamento.AGEND_USR_COD, agendamento.AGEND_DATA, agendamento.AGEND_HORA, empresa.EMP_NOME"
                    + " FROM empresa"
                    + " JOIN agendamento ON empresa.EMP_COD = agendamento.AGEND_EMP_COD"
                    + " WHERE agendamento.AGEND_USR_COD=?");
            stmt.setInt(1, cod_usr);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setNome_emp(rs.getString("EMP_NOME"));
                agendamento.setData(rs.getString("AGEND_DATA"));
                agendamento.setHora(rs.getString("AGEND_HORA"));
                agendamento.setCod_usr(rs.getInt("AGEND_USR_COD"));
                agendamento.setCod_emp(rs.getInt("AGEND_EMP_COD"));
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
    
    public List<Agendamento> readEmp(int cod_emp){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT agendamento.AGEND_COD, agendamento.AGEND_USR_COD, agendamento.AGEND_DATA, agendamento.AGEND_HORA, usuario.USR_NOME"
                    + " FROM usuario"
                    + " JOIN agendamento ON usuario.USR_COD = agendamento.AGEND_USR_COD"
                    + " WHERE agendamento.AGEND_EMP_COD=?");
            stmt.setInt(1, cod_emp);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setNome_usr(rs.getString("USR_NOME"));
                agendamento.setData(rs.getString("AGEND_DATA"));
                agendamento.setHora(rs.getString("AGEND_HORA"));
                agendamento.setCod_usr(rs.getInt("AGEND_USR_COD"));
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
            stmt = con.prepareStatement("UPDATE agendamento SET AGEND_DATA=?, AGEND_HORA=? WHERE AGEND_COD=?");
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
    
    public void delete(int AGEND_COD) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM agendamento WHERE AGEND_COD = ?");
            stmt.setInt(1, AGEND_COD);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
