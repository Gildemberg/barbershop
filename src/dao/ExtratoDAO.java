
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Extrato;

public class ExtratoDAO {
    
    public void create(Extrato e){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try {
                String sql = "INSERT INTO extrato (FK_CODBARBEARIA, FK_CODAGENDAMENTO, DATA, HORARIO, VALOR_PAGO) VALUES(?,?,?,?,?)";

                // Obtém o ID gerado automaticamente
                stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, e.getCodbarbearia());
                stmt.setInt(2, e.getCodagendamento());
                stmt.setDate(3, e.getData());
                stmt.setTime(4, e.getHora());
                stmt.setFloat(5, e.getValorPago());

                stmt.executeUpdate();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: "+ex);
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
    
    public List<Extrato> read(int CODBARBEARIA, Date dataIni, Date dataFin){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Extrato> extratos = new ArrayList();
        
        try {
            stmt = con.prepareStatement("SELECT E.CODEXTRATO, E.DATA, E.HORARIO, E.VALOR_PAGO, S.NOME, S.VALOR, C.NOME "
                                        + "FROM EXTRATO E "
                                        + "INNER JOIN AGENDAMENTO A ON A.CODAGENDAMENTO = E.FK_CODAGENDAMENTO "
                                        + "INNER JOIN SERVICO S ON A.FK_CODSERVICO = S.CODSERVICO "
                                        + "INNER JOIN CLIENTE C ON A.FK_CODCLIENTE = C.CODCLIENTE "
                                        + "WHERE E.FK_CODBARBEARIA=? AND E.DATA BETWEEN ? AND ? "
                                        + "ORDER BY 2");
            stmt.setInt(1, CODBARBEARIA);
            stmt.setDate(2, dataIni);
            stmt.setDate(3, dataFin);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                    Extrato extrato = new Extrato();
                    extrato.setCodextrato(rs.getInt(1));
                    extrato.setData(rs.getDate(2));
                    extrato.setHora(rs.getTime(3));
                    extrato.setValorPago(rs.getFloat(4));
                    extrato.setServico(rs.getString(5));
                    extrato.setValorServico(rs.getFloat(6));
                    extrato.setCliente(rs.getString(7));
                    extratos.add(extrato);
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return extratos;
    }
}
