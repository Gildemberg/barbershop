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
                stmt = con.prepareStatement("INSERT INTO cliente (NOME, CPF, EMAIL, TELEFONE, LOGIN, SENHA) VALUES(?,?,?,?,?,?)");
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getCpf());
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
            List<Cliente> clientes = new ArrayList();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM CLIENTE");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt(1));
                    cliente.setCpf(rs.getString(2));
                    cliente.setNome(rs.getString(3));
                    cliente.setEmail(rs.getString(4));
                    cliente.setTelefone(rs.getString(5));
                    cliente.setLogin(rs.getString(6));
                    cliente.setSenha(rs.getString(7));
                    clientes.add(cliente);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return clientes;
        }
        
        public boolean checkInformacoes(String cpf, String email, String telefone, String login){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE CPF=? OR EMAIL=? OR TELEFONE=? OR LOGIN = ?");
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
                stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE LOGIN=? AND SENHA=?");
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
                stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE LOGIN=? AND SENHA=?");
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
        
        public ConsultarNome retornoNome(int codcliente){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            ConsultarNome CNU = new ConsultarNome();
            
            try {
                stmt = con.prepareStatement("SELECT NOME FROM CLIENTE WHERE CODCLIENTE=?");
                stmt.setInt(1, codcliente);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    CNU.setNome(rs.getString(1));
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
