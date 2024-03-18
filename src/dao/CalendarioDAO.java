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
import model.Calendario;

public class CalendarioDAO {
        public void create(Calendario c){ //CRIANDO ROW PARA TABELA CALENDARIO
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO calendario (CAL_EMP_COD,CAL_HORA,CAL_DIA,CAL_MES,CAL_ANO) VALUES(?,?,?,?,?)");
            stmt.setInt(1, c.getCod_emp());
            stmt.setString(2, c.getHora());
            stmt.setString(3, c.getDia());
            stmt.setString(4, c.getMes());
            stmt.setString(5, c.getAno());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
    public List<Calendario> read(int i){ // LENDO AS ROW DA TABELA CALENDARIO
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Calendario> calendarios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM calendario WHERE CAL_COD_EMP = ?"); // LENDO PELO ID DA EMPRESA
            stmt.setInt(1, i);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Calendario calendario = new Calendario();
                calendario.setCod_emp(rs.getInt("CAL_COD_EMP"));
                calendario.setHora(rs.getString("CAL_HORA"));
                calendario.setDia(rs.getString("CAL_DIA"));
                calendario.setMes(rs.getString("CAL_MES"));
                calendario.setAno(rs.getString("CAL_ANO"));
                calendarios.add(calendario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return calendarios;
    }
        
    public List<Calendario> diaDisponivel(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Calendario> horario = new ArrayList();
        String[] hora = {"07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        
        try {
            for(int x=1; x<32; x++){
                stmt = con.prepareStatement("SELECT * FROM agendamento WHERE AGEND_DIA = ? AND AGEND_HORA = ?");            
                stmt.setInt(1,x);
                for(int y=0; y<=11; y++){
                    stmt.setString(2,hora[y]);
                    rs = stmt.executeQuery();
                    while(rs.next()){
                        Calendario horarioAgendado = new Calendario();
                        horarioAgendado.setDia(rs.getString("CAL_DIA"));
                        horarioAgendado.setHora(rs.getString("CAL_HORA"));
                        horarioAgendado.setCod_emp(rs.getInt("CAL_EMP_COD"));
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
