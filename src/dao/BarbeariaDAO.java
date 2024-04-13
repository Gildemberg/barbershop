package dao;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Barbearia;
import model.ConsultarNome;
import model.TransfCod;

public class BarbeariaDAO {
    public void create(Barbearia c){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("INSERT INTO empresa (EMP_CNPJ, EMP_NOME, EMP_END, EMP_EMAIL, EMP_TEL, EMP_LOGIN, EMP_SENHA, EMP_DESC, EMP_REG1, EMP_REG2, EMP_REG3, EMP_REG4) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, c.getCnpj());
                stmt.setString(2, c.getNome());
                stmt.setString(3, c.getEndereco());
                stmt.setString(4, c.getEmail());
                stmt.setString(5, c.getTelefone1());
                stmt.setString(6, c.getLogin());
                stmt.setString(7, c.getSenha());
                stmt.setString(8, c.getDescricao());
                stmt.setString(9, c.getRegra1());
                stmt.setString(10, c.getRegra2());
                stmt.setString(11, c.getRegra3());
                stmt.setString(12, c.getRegra4());
                
                stmt.executeUpdate();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(BarbeariaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
    
    public List<Barbearia> read(){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Barbearia> barbearias = new ArrayList();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM empresa");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Barbearia barbearia = new Barbearia();
                    barbearia.setId(rs.getInt(1));
                    barbearia.setCnpj(rs.getString(2));
                    barbearia.setNome(rs.getString(3));
                    barbearia.setEndereco(rs.getString(4));
                    barbearia.setEmail(rs.getString(5));
                    barbearia.setTelefone1(rs.getString(6));
                    barbearia.setLogin(rs.getString(7));
                    barbearia.setSenha(rs.getString(8));
                    barbearia.setDescricao(rs.getString(9));
                    barbearia.setRegra1(rs.getString(10));
                    barbearia.setRegra2(rs.getString(11));
                    barbearia.setRegra3(rs.getString(12));
                    barbearia.setRegra4(rs.getString(13));
                    barbearias.add(barbearia);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(BarbeariaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            
            return barbearias;
        }
    
            public boolean checkInformacoes(String cnpj, String email, String telefone1, String login){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM empresa WHERE EMP_CNPJ=? OR EMP_EMAIL=? OR EMP_TEL=? OR EMP_LOGIN = ?");
                stmt.setString(1, cnpj);
                stmt.setString(2, email);
                stmt.setString(3, telefone1);
                stmt.setString(4, login);
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
        
        public boolean checkLogin(String login, String senha){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM empresa WHERE EMP_LOGIN = ? and EMP_SENHA = ?");
                stmt.setString(1, login);
                stmt.setString(2, senha);
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
    
    
        public TransfCod retornoCod(String login, String senha){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            TransfCod TCU = new TransfCod();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM empresa WHERE EMP_LOGIN = ? AND EMP_SENHA = ?");
                stmt.setString(1, login);
                stmt.setString(2, senha);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    TCU.setCod(rs.getInt(1));
                    return TCU;
                } else{
                    return null;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(BarbeariaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return null;
        }
        
        public ConsultarNome retornoNome(int cod_emp){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            ConsultarNome CNE = new ConsultarNome();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM empresa WHERE EMP_COD = ?");
                stmt.setInt(1, cod_emp);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    CNE.setNome(rs.getString(3));
                    return CNE;
                } else{
                    return null;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return null;
        }
        
}
