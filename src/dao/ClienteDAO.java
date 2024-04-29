package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteDAO {
        public void create(Cliente c){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            try {
                String sql = "INSERT INTO cliente (NOME, CPF, EMAIL, TELEFONE, LOGIN, SENHA) VALUES(?,?,?,?,?,?)";

                // Obtém o ID gerado automaticamente
                stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getCpf());
                stmt.setString(3, c.getEmail());
                stmt.setString(4, c.getTelefone());
                stmt.setString(5, c.getLogin());
                stmt.setString(6, c.getSenha());

                int affectedRows = stmt.executeUpdate();

                // Verifica se o insert teve sucesso e obtém o ID gerado
                if (affectedRows == 0) {
                    throw new SQLException("Inserção falhou, nenhum registro afetado.");
                }

                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int codcliente = rs.getInt(1); // Obtém o ID da barbearia inserida
                    // Agora, vamos inserir nas tabelas relacionadas usando o ID da barbearia

                    // Inserir na tabela endereco
                    sql = "INSERT INTO endereco (RUA, NUMERO, BAIRRO, CIDADE, ESTADO, FK_CODCLIENTE) VALUES(?,?,?,?,?,?)";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, c.getRua());
                    stmt.setString(2, c.getNumero());
                    stmt.setString(3, c.getBairro());
                    stmt.setString(4, c.getCidade());
                    stmt.setString(5, c.getUf());
                    stmt.setInt(6, codcliente); // Usar o ID da barbearia

                    stmt.executeUpdate();
                } else {
                    throw new SQLException("Nenhum ID gerado para a barbearia.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
        
        public List<Cliente> read(int CODCLIENTE){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Cliente> clientes = new ArrayList();
            
            try {
                stmt = con.prepareStatement("SELECT C.CODCLIENTE, C.NOME, C.CPF, C.EMAIL, C.TELEFONE, C.LOGIN, C.SENHA, "
                                            + "E.RUA, E.NUMERO, E.BAIRRO, E.CIDADE, E.ESTADO "
                                            + "FROM CLIENTE C "
                                            + "INNER JOIN ENDERECO E "
                                            + "ON C.CODCLIENTE = E.FK_CODCLIENTE "
                                            + "WHERE C.CODCLIENTE=?");
                stmt.setInt(1, CODCLIENTE);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setCodcliente(rs.getInt(1));
                    cliente.setNome(rs.getString(2));
                    cliente.setCpf(rs.getString(3));
                    cliente.setEmail(rs.getString(4));
                    cliente.setTelefone(rs.getString(5));
                    cliente.setLogin(rs.getString(6));
                    cliente.setSenha(rs.getString(7));
                    cliente.setRua(rs.getString(8));
                    cliente.setNumero(rs.getString(9));
                    cliente.setBairro(rs.getString(10));
                    cliente.setCidade(rs.getString(11));
                    cliente.setUf(rs.getString(12));
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
        
        public void updateCadastroCliente(Cliente c){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            try {
                String sql = "UPDATE cliente SET NOME=?, CPF=?, EMAIL=?, TELEFONE=?, LOGIN=?, SENHA=? WHERE CODCLIENTE=?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getCpf());
                stmt.setString(3, c.getEmail());
                stmt.setString(4, c.getTelefone());
                stmt.setString(5, c.getLogin());
                stmt.setString(6, c.getSenha());
                stmt.setInt(7, c.getCodcliente());
                stmt.executeUpdate();

                String sql1 = "UPDATE endereco SET RUA=?, NUMERO=?, BAIRRO=?, CIDADE=?, ESTADO=? WHERE FK_CODCLIENTE=?";
                stmt = con.prepareStatement(sql1);
                stmt.setString(1, c.getRua());
                stmt.setString(2, c.getNumero());
                stmt.setString(3, c.getBairro());
                stmt.setString(4, c.getCidade());
                stmt.setString(5, c.getUf());
                stmt.setInt(6, c.getCodcliente()); // Usar o ID da barbearia
                stmt.executeUpdate();
                
                
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
        
        public boolean checkInformacoes(Cliente c){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE CPF=? OR EMAIL=? OR TELEFONE=? OR LOGIN = ?");
                stmt.setString(1, c.getCpf());
                stmt.setString(2, c.getEmail());
                stmt.setString(3, c.getTelefone());
                stmt.setString(4, c.getLogin());
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
        
        public int retornoCod(String login, String senha){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            int CODCLIENTE;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE LOGIN=? AND SENHA=?");
                stmt.setString(1, login);
                stmt.setString(2, senha);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    CODCLIENTE = rs.getInt(1);
                    return CODCLIENTE;
                } else{
                    return 0;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return 0;
        }
        
        public String retornoNome(int codcliente){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String nome;
            
            try {
                stmt = con.prepareStatement("SELECT NOME FROM CLIENTE WHERE CODCLIENTE=?");
                stmt.setInt(1, codcliente);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    nome=rs.getString(1);
                    return nome;
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
