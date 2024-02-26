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
            stmt = con.prepareStatement("INSERT INTO agendamento (AGEND_COD_USR,AGEND_COD_FUN,AGEND_DIA,AGEND_MES,AGEND_HORA) VALUES(?,?,?,?,?)");
            stmt.setInt(1, a.getCod_usr());
            stmt.setInt(2, a.getCod_fun());
            stmt.setInt(3, a.getDia());
            stmt.setInt(4, a.getMes());
            stmt.setString(5, a.getHora());
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
            stmt = con.prepareStatement("SELECT * FROM agendamento WHERE AGEND_COD_FUN = ?");
            stmt.setInt(1, i);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setId(rs.getInt("AGEND_COD"));
                agendamento.setCod_usr(rs.getInt("AGEND_COD_USR"));
                agendamento.setCod_fun(rs.getInt("AGEND_COD_FUN"));
                agendamento.setDia(rs.getInt("AGEND_DIA"));
                agendamento.setMes(rs.getInt("AGEND_MES"));
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
        
    public List<Agendamento> diaDisponivel(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> horario = new ArrayList();
        String[] hora = {"07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        
        try {
            for(int x=1; x<32; x++){
                stmt = con.prepareStatement("SELECT * FROM agendamento WHERE AGEND_DIA = ? AND AGEND_HORA = ?");            
                stmt.setInt(1,x);
                for(int y=0; y<=11; y++){
                    stmt.setString(2,hora[y]);
                    rs = stmt.executeQuery();
                    while(rs.next()){
                        Agendamento horarioAgendado = new Agendamento();
                        horarioAgendado.setDia(rs.getInt("AGEND_DIA"));
                        horarioAgendado.setHora(rs.getString("AGEND_HORA"));
                        horarioAgendado.setCod_fun(rs.getInt("AGEND_COD_FUN"));
                        horario.add(horarioAgendado);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return horario;
    }
}
