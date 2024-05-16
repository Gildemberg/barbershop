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
import java.time.LocalDate;
import java.time.LocalTime;


public class AgendamentoDAO {
    /*----------------------------------------CRUD--------------------------------------------------*/

        LocalDate today = LocalDate.now();
        Date hoje = Date.valueOf(today);
        LocalTime now = LocalTime.now();
        Time agora = Time.valueOf(now);
        
    public void create(Agendamento a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            String sql = "INSERT INTO agendamento (DATA, HORARIO, STATUS, FK_CODBARBEARIA, FK_CODCLIENTE, FK_CODSERVICO, DESCRICAO) VALUES(?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, a.getData());
            stmt.setTime(2, a.getHora());
            stmt.setInt(3, a.getStatus());
            stmt.setInt(4, a.getCodbarbearia());
            stmt.setInt(5, a.getCodcliente());
            stmt.setInt(6, a.getServico());
            stmt.setString(7, "Agendado");
            stmt.executeUpdate();
            
            sql = "UPDATE expediente SET STATUS=1 WHERE HORA=? AND FK_CODBARBEARIA=? AND DATA=?";
            stmt = con.prepareStatement(sql);
            stmt.setTime(1, a.getHora());
            stmt.setInt(2, a.getCodbarbearia());
            stmt.setDate(3, a.getData());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void updateAgendamentoCliente(Agendamento a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE agendamento SET DATA=?, HORARIO=?, FK_CODSERVICO=?, STATUS=?, DESCRICAO=? WHERE CODAGENDAMENTO=?");
            stmt.setDate(1, a.getData());
            stmt.setTime(2, a.getHora());
            stmt.setInt(3, a.getServico());
            stmt.setInt(4, a.getStatus()); 
            stmt.setString(5, a.getDescricao()); 
            stmt.setInt(6, a.getCodagendamento()); 
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deleteAgendamentoCliente(Agendamento a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            System.out.println(a.getHora());
            String sql = "UPDATE agendamento SET STATUS=?, DESCRICAO=? WHERE CODAGENDAMENTO=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, a.getStatus()); 
            stmt.setString(2, a.getDescricao());
            stmt.setInt(3, a.getCodagendamento()); 
            stmt.executeUpdate();
            sql = "UPDATE expediente SET STATUS=0 WHERE FK_CODBARBEARIA=? AND HORA=? AND DATA=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, a.getCodbarbearia()); 
            stmt.setTime(2, a.getHora());
            stmt.setDate(3, a.getData());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }
    
    public void confirmarAgendamentoCliente(int CODAGENDAMENTO, int status, String Descricao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE agendamento SET STATUS=?, DESCRICAO=? WHERE CODAGENDAMENTO = ?");
            stmt.setInt(1, status);
            stmt.setString(2, Descricao);
            stmt.setInt(3, CODAGENDAMENTO);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(AgendamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    /*----------------------------------------VERIFICAÇÃO--------------------------------------------------*/
    
    public boolean verificarDataBarbearia(Date DATA, int CODBARBEARIA){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM expediente WHERE DATA=? AND FK_CODBARBEARIA=?");
            stmt.setDate(1, DATA);
            stmt.setInt(2, CODBARBEARIA);
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
    
    public boolean verificarHorarioBarbearia(Date DATA, Time hora, int CODBARBEARIA){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM expediente WHERE DATA=? AND FK_CODBARBEARIA=? AND ? BETWEEN HORAINICIO AND HORAFIM");
            stmt.setDate(1, DATA);
            stmt.setInt(2, CODBARBEARIA);
            stmt.setTime(3, hora);
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
    
    public boolean checkInformacoes(Date data, Time hora, int CODBARBEARIA){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM AGENDAMENTO WHERE (DATA=? AND HORARIO=?) AND FK_CODBARBEARIA=? AND (STATUS!=? && STATUS!=?)");
                stmt.setDate(1, data);
                stmt.setTime(2, hora);
                stmt.setInt(3, CODBARBEARIA);
                stmt.setInt(4, 2);
                stmt.setInt(5, 3);
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
    
    /*-----------------------------------------CONSULTAS---------------------------------------------------*/
    
    public List<Agendamento> consultarAgendamentosCliente(int codcliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT a.FK_CODBARBEARIA, a.CODAGENDAMENTO, a.FK_CODCLIENTE, a.DATA, a.HORARIO, b.NOMESOCIAL, s.NOME"
                    + " FROM agendamento a"
                    + " JOIN barbearia b ON a.FK_CODBARBEARIA = b.CODBARBEARIA"
                    + " JOIN servico s ON a.FK_CODSERVICO = s.CODSERVICO"
                    + " WHERE a.FK_CODCLIENTE=? AND (STATUS!=? AND STATUS!=?) AND ((a.HORARIO > ? && a.DATA=?) || a.DATA>?)"
                    + " ORDER BY a.DATA, a.HORARIO");
            stmt.setInt(1, codcliente);
            stmt.setInt(2, 2);
            stmt.setInt(3, 3);
            stmt.setTime(4, agora);
            stmt.setDate(5, hoje);
            stmt.setDate(6, hoje);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setNomebarbearia(rs.getString("NOMESOCIAL"));
                agendamento.setData(rs.getDate("DATA"));
                agendamento.setHora(rs.getTime("HORARIO"));
                agendamento.setCodcliente(rs.getInt("FK_CODCLIENTE"));
                agendamento.setCodbarbearia(rs.getInt("FK_CODBARBEARIA"));
                agendamento.setCodagendamento(rs.getInt("CODAGENDAMENTO"));
                agendamento.setNomeservico(rs.getString("s.NOME"));
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
    
    public List<Agendamento> consultarAgendamentosAbertoBarbearia(int codbarbearia, int status){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT a.CODAGENDAMENTO, a.FK_CODCLIENTE, a.DATA, a.HORARIO, c.NOME, s.NOME, a.STATUS"
                    + " FROM agendamento a"
                    + " JOIN cliente c ON a.FK_CODCLIENTE = c.CODCLIENTE"
                    + " JOIN servico s ON a.FK_CODSERVICO = s.CODSERVICO"
                    + " WHERE a.FK_CODBARBEARIA=? AND (a.STATUS=? || a.STATUS=?) AND ((a.HORARIO > ? && a.DATA=?) || a.DATA>?)"
                    + " ORDER BY a.STATUS ASC, a.DATA, a.HORARIO");
            stmt.setInt(1, codbarbearia);
            stmt.setInt(2, status);
            stmt.setInt(3, 0);
            stmt.setTime(4, agora);
            stmt.setDate(5, hoje);
            stmt.setDate(6, hoje);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setNomecliente(rs.getString("c.NOME"));
                agendamento.setData(rs.getDate("a.DATA"));
                agendamento.setHora(rs.getTime("a.HORARIO"));
                agendamento.setCodcliente(rs.getInt("a.FK_CODCLIENTE"));
                agendamento.setCodagendamento(rs.getInt("a.CODAGENDAMENTO"));
                agendamento.setNomeservico(rs.getString("s.NOME"));
                agendamento.setStatus(rs.getInt("a.STATUS"));
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
    
    public List<Agendamento> consultarAgendamentosPendentes(int codbarbearia){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT a.CODAGENDAMENTO, a.FK_CODCLIENTE, a.DATA, a.HORARIO, c.NOME, s.NOME, a.STATUS"
                    + " FROM agendamento a"
                    + " JOIN cliente c ON a.FK_CODCLIENTE = c.CODCLIENTE"
                    + " JOIN servico s ON a.FK_CODSERVICO = s.CODSERVICO"
                    + " WHERE a.FK_CODBARBEARIA=? AND ((a.HORARIO < ? && a.DATA=?) || a.DATA<?) AND (a.STATUS=? || a.STATUS=?)"
                    + " ORDER BY a.STATUS ASC, a.DATA, a.HORARIO");
            stmt.setInt(1, codbarbearia);
            stmt.setTime(2, agora);
            stmt.setDate(3, hoje);
            stmt.setDate(4, hoje);
            stmt.setInt(5, 0);
            stmt.setInt(6, 1);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setNomecliente(rs.getString("c.NOME"));
                agendamento.setData(rs.getDate("a.DATA"));
                agendamento.setHora(rs.getTime("a.HORARIO"));
                agendamento.setCodcliente(rs.getInt("a.FK_CODCLIENTE"));
                agendamento.setCodagendamento(rs.getInt("a.CODAGENDAMENTO"));
                agendamento.setNomeservico(rs.getString("s.NOME"));
                agendamento.setStatus(rs.getInt("a.STATUS"));
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
    
    public List<Agendamento> consultarAgendamentosBarbearia(int codbarbearia, int status){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamento> agendamentos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT a.CODAGENDAMENTO, a.FK_CODCLIENTE, a.DATA, a.HORARIO, c.NOME, s.NOME, a.STATUS"
                    + " FROM agendamento a"
                    + " JOIN cliente c ON a.FK_CODCLIENTE = c.CODCLIENTE"
                    + " JOIN servico s ON a.FK_CODSERVICO = s.CODSERVICO"
                    + " WHERE a.FK_CODBARBEARIA=? AND a.STATUS=?"
                    + " ORDER BY a.STATUS ASC, a.DATA, a.HORARIO");
            stmt.setInt(1, codbarbearia);
            stmt.setInt(2, status);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setNomecliente(rs.getString("c.NOME"));
                agendamento.setData(rs.getDate("a.DATA"));
                agendamento.setHora(rs.getTime("a.HORARIO"));
                agendamento.setCodcliente(rs.getInt("a.FK_CODCLIENTE"));
                agendamento.setCodagendamento(rs.getInt("a.CODAGENDAMENTO"));
                agendamento.setNomeservico(rs.getString("s.NOME"));
                agendamento.setStatus(rs.getInt("a.STATUS"));
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
}
