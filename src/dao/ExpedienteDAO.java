
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Expediente;

public class ExpedienteDAO {
    public boolean consultarDataExpediente(Expediente e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check=true;
        
        try {
            stmt = con.prepareStatement("SELECT DATA, FK_CODBARBEARIA "
                                        + "FROM EXPEDIENTE  "
                                        + "WHERE FK_CODBARBEARIA=? "
                                        + "AND DATA BETWEEN ? AND ? ");
            stmt.setInt(1, e.getCodbarbearia());
            stmt.setDate(2, e.getDataInicial());
            stmt.setDate(3, e.getDataFinal());
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = false;
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
    
    public boolean adicionarDataExpediente(Expediente e) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            con = ConnectionFactory.getConnection();

            // Inicia uma transação
            con.setAutoCommit(false); // desativa auto-commit para garantir atomicidade

            LocalDate localDate = e.getDataInicial().toLocalDate();
            LocalDate localDateFim = e.getDataFinal().toLocalDate();

            // Prepare o comando SQL fora do loop
            String insertSQL = "INSERT INTO expediente (DATA, HORAINICIO, HORAFIM, FK_CODBARBEARIA) VALUES (?,?,?,?)";
            stmt = con.prepareStatement(insertSQL);

            while (!localDate.isAfter(localDateFim)) { // Ajustar condição para evitar loop infinito
                stmt.setDate(1, Date.valueOf(localDate));
                stmt.setTime(2, e.getHoraInicial());
                stmt.setTime(3, e.getHoraFinal());
                stmt.setInt(4, e.getCodbarbearia());

                stmt.addBatch(); // Acumula as operações para processamento em lote
                
                localDate = localDate.plusDays(1); // Avança para o próximo dia
            }

            stmt.executeBatch(); // Executa todas as operações em lote
            con.commit(); // Comita a transação
            check = true;
        } catch (SQLException ex) {
            // Em caso de erro, reverte a transação
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackEx) {
                    Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, rollbackEx);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, null);
        }
        
        return check;
    }
    
    /*------------------------------------------------------------------------------------*/
    
    public boolean verificarDataBarbearia(Expediente e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT DATA, FK_CODBARBEARIA "
                    + "FROM EXPEDIENTE  "
                    + "WHERE DATA=? AND FK_CODBARBEARIA=?");
                stmt.setDate(1, e.getDataInicial());
                stmt.setInt(2, e.getCodbarbearia());
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    return true;
                }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return false;
    }
    
    
    public boolean removeExpediente(Expediente e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM expediente WHERE DATA=? AND FK_CODBARBEARIA=?");
            stmt.setDate(1, e.getDataInicial());
            stmt.setInt(2, e.getCodbarbearia());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
    public boolean alterarExpediente(Expediente e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE expediente SET HORAINICIO=?, HORAFIM=? WHERE DATA=? AND FK_CODBARBEARIA=?");
            stmt.setTime(1, e.getHoraInicial());
            stmt.setTime(2, e.getHoraFinal());
            stmt.setDate(3, e.getDataInicial());
            stmt.setInt(4, e.getCodbarbearia());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
}