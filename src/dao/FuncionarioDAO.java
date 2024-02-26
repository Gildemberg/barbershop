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
import model.Funcionario;
import model.TransfCodFun;

public class FuncionarioDAO {
        public void create(Funcionario f){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                stmt = con.prepareStatement("INSERT INTO funcionario (FUN_COD_EMP, FUN_CPF, FUN_NOME, FUN_EMAIL, FUN_CEL, FUN_LOGIN, FUN_SENHA) VALUES(?,?,?,?,?,?,?)");
                stmt.setInt(1, f.getEmp_cod());
                stmt.setString(2, f.getCpf());
                stmt.setString(3, f.getNome());
                stmt.setString(4, f.getEmail());
                stmt.setString(5, f.getTel());
                stmt.setString(6, f.getLogin());
                stmt.setString(7, f.getSenha());
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionario: "+ex);
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
        
        public List<Funcionario> read(){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Funcionario> funcionarios = new ArrayList();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM funcionario");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(rs.getInt("FUN_COD"));
                    funcionario.setNome(rs.getString("FUN_NOME"));
                    funcionario.setLogin(rs.getString("FUN_LOGIN"));
                    funcionario.setSenha(rs.getString("FUN_SENHA"));
                    funcionario.setTel(rs.getString("FUN_CEL"));
                    funcionario.setEmail(rs.getString("FUN_EMAIL"));
                    funcionario.setCpf(rs.getString("FUN_CPF"));
                    funcionarios.add(funcionario);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            
            return funcionarios;
        }
        
        public boolean checkLogin(String login, String senha){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM funcionario WHERE FUN_LOGIN = ? and FUN_SENHA = ?");
                stmt.setString(1, login);
                stmt.setString(2, senha);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    check = true;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            
            return check;
        }
        
   public TransfCodFun retornoCodFun(String login){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            TransfCodFun TCF = new TransfCodFun();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM funcionario WHERE FUN_LOGIN = ?");
                stmt.setString(1, login);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    TCF.setCod_fun(rs.getInt(1));
                    return TCF;
                } else{
                    return null;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return null;
        }
}
