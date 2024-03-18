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
                stmt = con.prepareStatement("INSERT INTO empresa (EMP_CNPJ, EMP_NOME, EMP_END, EMP_EMAIL, EMP_TEL, EMP_LOGIN, USR_SENHA) VALUES(?,?,?,?,?,?,?)");
                stmt.setString(1, c.getCnpj());
                stmt.setString(2, c.getNome());
                stmt.setString(3, c.getEndereco());
                stmt.setString(4, c.getEmail());
                stmt.setString(5, c.getTelefone());
                stmt.setString(6, c.getLogin());
                stmt.setString(7, c.getSenha());
                
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
                    barbearia.setEndereco(rs.getString(5));
                    barbearia.setEmail(rs.getString(5));
                    barbearia.setTelefone(rs.getString(5));
                    barbearia.setLogin(rs.getString(6));
                    barbearia.setSenha(rs.getString(7));
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
                Logger.getLogger(BarbeariaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(BarbeariaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return null;
        }
        
}
