
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Expediente;

public class ExpedienteDAO {
    public void removeExpediente(Expediente e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO expediente (DATA, FK_CODBARBEARIA) VALUES(?,?)");
            stmt.setDate(1, e.getData());
            stmt.setInt(2, e.getCodbarbearia());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean verificarHorarioBarbearia(Date data, int CODBARBEARIA){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check=false;
        
        try {
            stmt = con.prepareStatement("SELECT DATA, FK_CODBARBEARIA "
                    + "FROM EXPEDIENTE  "
                    + "WHERE DATA=? AND FK_CODBARBEARIA=?");
                stmt.setDate(1, data);
                stmt.setInt(2, CODBARBEARIA);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    check = true;
                }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
}
