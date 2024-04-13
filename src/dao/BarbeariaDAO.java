package dao;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Barbearia;
import model.ConsultarNome;
import model.TransfCod;

public class BarbeariaDAO {
    public void create(Barbearia b){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO barbearia (NOMESOCIAL, CNPJ, EMAIL, TELEFONE1, TELEFONE2, LOGIN, SENHA, DESCRICAO) VALUES(?,?,?,?,?,?,?,?)";

            // Obtém o ID gerado automaticamente
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, b.getNome());
            stmt.setString(2, b.getCnpj());
            stmt.setString(3, b.getEmail());
            stmt.setString(4, b.getTelefone1());
            stmt.setString(5, b.getTelefone2());
            stmt.setString(6, b.getLogin());
            stmt.setString(7, b.getSenha());
            stmt.setString(8, b.getDescricao());

            int affectedRows = stmt.executeUpdate();

            // Verifica se o insert teve sucesso e obtém o ID gerado
            if (affectedRows == 0) {
                throw new SQLException("Inserção falhou, nenhum registro afetado.");
            }

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int codbarbearia = rs.getInt(1); // Obtém o ID da barbearia inserida
                // Agora, vamos inserir nas tabelas relacionadas usando o ID da barbearia

                // Inserir na tabela endereco
                sql = "INSERT INTO endereco (RUA, NUMERO, BAIRRO, CIDADE, ESTADO, FK_CODBARBEARIA) VALUES(?,?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, b.getRua());
                stmt.setString(2, b.getNumero());
                stmt.setString(3, b.getBairro());
                stmt.setString(4, b.getCidade());
                stmt.setString(5, b.getUf());
                stmt.setInt(6, codbarbearia); // Usar o ID da barbearia

                stmt.executeUpdate();

                // Inserir na tabela regra
                sql = "INSERT INTO regra (REGRA1, REGRA2, REGRA3, REGRA4, FK_CODBARBEARIA) VALUES(?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, b.getRegra1());
                stmt.setString(2, b.getRegra2());
                stmt.setString(3, b.getRegra3());
                stmt.setString(4, b.getRegra4());
                stmt.setInt(5, codbarbearia); // Usar o ID da barbearia

                stmt.executeUpdate();
            } else {
                throw new SQLException("Nenhum ID gerado para a barbearia.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(BarbeariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fechar ResultSet, Statement e conexão
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BarbeariaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Barbearia> read(){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Barbearia> barbearias = new ArrayList();
            
            try {
                stmt = con.prepareStatement("SELECT b.CODBARBEARIA, b.NOMESOCIAL, b.CNPJ, b.EMAIL, b.TELEFONE1, b.TELEFONE2, b.LOGIN, b.SENHA, b.DESCRICAO, "
                                                + "e.RUA, e.NUMERO, e.BAIRRO, e.CIDADE, e.ESTADO, "
                                                + "r.REGRA1, r.REGRA2, r.REGRA3, r.REGRA4 "
                                                + "FROM barbearia b "
                                                + "INNER JOIN endereco e ON b.CODBARBEARIA = e.FK_CODBARBEARIA "
                                                + "INNER JOIN regra r ON b.CODBARBEARIA = r.FK_CODBARBEARIA");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Barbearia barbearia = new Barbearia();
                    barbearia.setId(rs.getInt(1));
                    barbearia.setNome(rs.getString(2));
                    barbearia.setCnpj(rs.getString(3));
                    barbearia.setEmail(rs.getString(4));
                    barbearia.setTelefone1(rs.getString(5));
                    barbearia.setTelefone2(rs.getString(6));
                    barbearia.setLogin(rs.getString(7));
                    barbearia.setSenha(rs.getString(8));
                    barbearia.setDescricao(rs.getString(9));
                    barbearia.setRua(rs.getString(10));
                    barbearia.setNumero(rs.getString(11));
                    barbearia.setBairro(rs.getString(12));
                    barbearia.setCidade(rs.getString(13));
                    barbearia.setUf(rs.getString(14));
                    barbearia.setRegra1(rs.getString(15));
                    barbearia.setRegra2(rs.getString(16));
                    barbearia.setRegra3(rs.getString(17));
                    barbearia.setRegra4(rs.getString(18));
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
    
            public boolean checkInformacoes(String cnpj, String email, String telefone1, String telefone2, String login){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            try {
                stmt = con.prepareStatement("SELECT * FROM barbearia WHERE CNPJ=? OR EMAIL=? OR TELEFONE1=? OR TELEFONE2=? OR LOGIN = ?");
                stmt.setString(1, cnpj);
                stmt.setString(2, email);
                stmt.setString(3, telefone1);
                stmt.setString(4, telefone2);
                stmt.setString(5, login);
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
                stmt = con.prepareStatement("SELECT * FROM barbearia WHERE LOGIN = ? and SENHA = ?");
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
                stmt = con.prepareStatement("SELECT * FROM barbearia WHERE LOGIN = ? AND SENHA = ?");
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
        
        public ConsultarNome retornoNome(int codbarbearia){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            ConsultarNome CNE = new ConsultarNome();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM barbearia WHERE CODBARBEARIA = ?");
                stmt.setInt(1, codbarbearia);
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
