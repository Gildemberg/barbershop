package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Expediente;

public class ExpedienteDAO {

    public List<Expediente> read(int CODBARBEARIA) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Expediente> expedientes = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * "
                    + "FROM EXPEDIENTE  "
                    + "WHERE FK_CODBARBEARIA=? "
                    + "ORDER BY 2");
            stmt.setInt(1, CODBARBEARIA);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Expediente expediente = new Expediente();
                expediente.setCodexpediente(rs.getInt(1));
                expediente.setDataInicial(rs.getDate(2));
                expediente.setHoraInicial(rs.getTime(3));
                expediente.setHoraFinal(rs.getTime(4));
                expedientes.add(expediente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return expedientes;
    }

    public boolean consultarPeriodoExpediente(Expediente e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = true;

        try {
            stmt = con.prepareStatement("SELECT DATA, FK_CODBARBEARIA "
                    + "FROM EXPEDIENTE "
                    + "WHERE FK_CODBARBEARIA=? "
                    + "AND DATA BETWEEN ? AND ? ");
            stmt.setInt(1, e.getCodbarbearia());
            stmt.setDate(2, e.getDataInicial());
            stmt.setDate(3, e.getDataFinal());
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public boolean consultarDataExpediente(Expediente e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = true;

        try {
            stmt = con.prepareStatement("SELECT DATA, FK_CODBARBEARIA "
                    + "FROM EXPEDIENTE "
                    + "WHERE FK_CODBARBEARIA=? "
                    + "AND DATA = ? ");
            stmt.setInt(1, e.getCodbarbearia());
            stmt.setDate(2, e.getDataInicial());
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public boolean adicionarPeriodoExpediente(Expediente e) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean check = false;

        try {
            con = ConnectionFactory.getConnection();

            // Inicia uma transação
            con.setAutoCommit(false); // desativa auto-commit para garantir atomicidade

            LocalDate localDate = e.getDataInicial().toLocalDate();
            LocalDate localDateFim = e.getDataFinal().toLocalDate();

            LocalTime localTime = e.getHoraInicial().toLocalTime();
            LocalTime localTimeFim = e.getHoraFinal().toLocalTime();

            String insertSQL = "INSERT INTO expediente (DATA, HORAINICIO, HORAFIM, HORA, FK_CODBARBEARIA, STATUS) VALUES (?,?,?,?,?,0)";
            stmt = con.prepareStatement(insertSQL);

            while (!localDate.isAfter(localDateFim)) {
                LocalTime horaTemp = localTime; // Armazena a hora inicial original
                while (!horaTemp.isAfter(localTimeFim)) {
                    stmt.setDate(1, Date.valueOf(localDate));
                    stmt.setTime(2, e.getHoraInicial());
                    stmt.setTime(3, e.getHoraFinal());
                    stmt.setTime(4, Time.valueOf(horaTemp)); // Utiliza a hora temporária
                    stmt.setInt(5, e.getCodbarbearia());

                    stmt.addBatch(); // Acumula as operações para processamento em lote
                    horaTemp = horaTemp.plusHours(1); // Avança para a próxima hora
                }
                localDate = localDate.plusDays(1); // Avança para o próximo dia
            }

            stmt.executeBatch(); // Executa todas as operações em lote
            con.commit(); // Comita a transação
            check = true;
        } catch (SQLException ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackEx) {
                    Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, rollbackEx);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, null);
        }

        return check;
    }

    public boolean adicionarDataExpediente(Expediente e) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean check = false;

        try {
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false); // desativa auto-commit para garantir atomicidade

            LocalDate localDate = e.getDataInicial().toLocalDate();

            LocalTime localTime = e.getHoraInicial().toLocalTime();
            LocalTime localTimeFim = e.getHoraFinal().toLocalTime();

            String insertSQL = "INSERT INTO expediente (DATA, HORAINICIO, HORAFIM, HORA, FK_CODBARBEARIA, STATUS) VALUES (?,?,?,?,?,0)";
            stmt = con.prepareStatement(insertSQL);

            LocalTime horaTemp = localTime; // Armazena a hora inicial original
            while (!horaTemp.isAfter(localTimeFim)) {
                stmt.setDate(1, Date.valueOf(localDate));
                stmt.setTime(2, e.getHoraInicial());
                stmt.setTime(3, e.getHoraFinal());
                stmt.setTime(4, Time.valueOf(horaTemp)); // Utiliza a hora temporária
                stmt.setInt(5, e.getCodbarbearia());

                stmt.addBatch(); // Acumula as operações para processamento em lote
                horaTemp = horaTemp.plusHours(1); // Avança para a próxima hora
            }

            stmt.executeBatch(); // Executa todas as operações em lote
            con.commit(); // Comita a transação
            check = true;
        } catch (SQLException ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackEx) {
                    Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, rollbackEx);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, null);
        }

        return check;
    }

    /*------------------------------------------------------------------------------------*/
    public boolean verificarDataBarbearia(Expediente e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT DATA, FK_CODBARBEARIA "
                    + "FROM EXPEDIENTE  "
                    + "WHERE DATA=? AND FK_CODBARBEARIA=?");
            stmt.setDate(1, e.getDataInicial());
            stmt.setInt(2, e.getCodbarbearia());
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return false;
    }

    public boolean removeExpediente(Expediente e) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean check = false;

        try {
            con = ConnectionFactory.getConnection();

            // Inicia uma transação
            con.setAutoCommit(false); // desativa auto-commit para garantir atomicidade

            // Prepara a consulta SQL para remover expedientes com base na data, hora de início e hora de fim
            String deleteSQL = "DELETE FROM expediente WHERE DATA = ? AND HORAINICIO = ? AND HORAFIM = ? AND FK_CODBARBEARIA=?";
            stmt = con.prepareStatement(deleteSQL);

            // Define os parâmetros da consulta com os valores fornecidos pelo usuário
            stmt.setDate(1, Date.valueOf(e.getDataInicial().toLocalDate()));
            stmt.setTime(2, Time.valueOf(e.getHoraInicial().toLocalTime()));
            stmt.setTime(3, Time.valueOf(e.getHoraFinal().toLocalTime()));
            stmt.setInt(4, e.getCodbarbearia());

            // Executa a consulta para remover os expedientes
            int rowsAffected = stmt.executeUpdate();

            // Verifica se algum registro foi removido
            if (rowsAffected > 0) {
                check = true;
                con.commit(); // Comita a transação se a remoção for bem-sucedida
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum expediente encontrado com os dados fornecidos.");
            }
        } catch (SQLException ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackEx) {
                    Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, rollbackEx);
                }
            }
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, null);
        }

        return check;
    }

    public boolean alterarExpediente(Expediente e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE expediente SET HORAINICIO=?, HORAFIM=? WHERE DATA=? AND FK_CODBARBEARIA=?");
            stmt.setTime(1, e.getHoraInicial());
            stmt.setTime(2, e.getHoraFinal());
            stmt.setDate(3, e.getDataInicial());
            stmt.setInt(4, e.getCodbarbearia());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    public List<Expediente> readHorarios(int CODBARBEARIA, Date data) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Expediente> expedientes = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT HORA "
                    + "FROM EXPEDIENTE  "
                    + "WHERE FK_CODBARBEARIA=? AND DATA=? AND STATUS=0");
            stmt.setInt(1, CODBARBEARIA);
            stmt.setDate(2, data);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Expediente expediente = new Expediente();
                expediente.setHoraInicial(rs.getTime(1));
                expedientes.add(expediente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            Logger.getLogger(ExpedienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return expedientes;
    }
}
