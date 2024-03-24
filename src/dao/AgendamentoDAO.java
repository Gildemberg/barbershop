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
        
    public List<Agendamento> read(int i){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM agendamento WHERE AGEND_COD_USR = ?");
            stmt.setInt(1, i);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setId(rs.getInt("AGEND_COD"));
                agendamento.setCod_usr(rs.getInt("AGEND_USR_COD"));
                agendamento.setCod_emp(rs.getInt("AGEND_EMP_COD"));
                agendamento.setData(rs.getString("AGEND_DATA"));
                agendamento.setHora(rs.getString("AGEND_HORA"));
                agendamentos.add(agendamento);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return agendamentos;
    }
}
