package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ConsultarNome;
import model.TransfCod;
import model.Cliente;

public class ClienteDAO {
        public void create(Cliente c){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("INSERT INTO usuario (USR_CPF, USR_NOME, USR_EMAIL, USR_CEL, USR_LOGIN, USR_SENHA) VALUES(?,?,?,?,?,?)");
                stmt.setString(1, c.getCpf());
                stmt.setString(2, c.getNome());
                stmt.setString(3, c.getEmail());
                stmt.setString(4, c.getTelefone());
                stmt.setString(5, c.getLogin());
                stmt.setString(6, c.getSenha());
                
                stmt.executeUpdate();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
        
        public List<Cliente> read(){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Cliente> usuarios = new ArrayList();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM usuario");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Cliente usuario = new Cliente();
                    usuario.setId(rs.getInt(1));
                    usuario.setCpf(rs.getString(2));
                    usuario.setNome(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setTelefone(rs.getString(5));
                    usuario.setLogin(rs.getString(6));
                    usuario.setSenha(rs.getString(7));
                    usuarios.add(usuario);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return usuarios;
        }
        
        public boolean checkInformacoes(String cpf, String email, String telefone, String login){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM usuario WHERE USR_CPF=? OR USR_EMAIL=? OR USR_CEL=? OR USR_LOGIN = ?");
                stmt.setString(1, cpf);
                stmt.setString(2, email);
                stmt.setString(3, telefone);
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
                stmt = con.prepareStatement("SELECT * FROM usuario WHERE USR_LOGIN = ? and USR_SENHA = ?");
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
                stmt = con.prepareStatement("SELECT * FROM usuario WHERE USR_LOGIN = ? AND USR_SENHA = ?");
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
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return null;
        }
        
        public ConsultarNome retornoNome(int cod_usr){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            ConsultarNome CNU = new ConsultarNome();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM usuario WHERE USR_COD = ?");
                stmt.setInt(1, cod_usr);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    CNU.setNome(rs.getString(3));
                    return CNU;
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
