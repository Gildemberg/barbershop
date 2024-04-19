package model;

import dao.AgendamentoDAO;
import java.sql.Time;
import java.sql.Date;

public class Agendamento {
    private int codagendamento;
    private int codcliente;
    private int codbarbearia;
    private Date data;
    private Time hora;
    private String nomebarbearia;
    private String nomecliente;
    private int servico;
    private String nomeservico;
    private int status;

    public int getCodagendamento() {
        return codagendamento;
    }

    public void setCodagendamento(int codagendamento) {
        this.codagendamento = codagendamento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public String getNomeservico() {
        return nomeservico;
    }

    public void setNomeservico(String nomeservico) {
        this.nomeservico = nomeservico;
    }
    
    

    public int getCodbarbearia() {
        return codbarbearia;
    }

    public void setCodbarbearia(int codbarbearia) {
        this.codbarbearia = codbarbearia;
    }

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNomebarbearia() {
        return nomebarbearia;
    }

    public void setNomebarbearia(String nomebarbearia) {
        this.nomebarbearia = nomebarbearia;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }
    
    
    public Agendamento(){
    }
    
    public Agendamento(int servico, Date data, Time hora, int codbarbearia, int codcliente, int codagendamento, int status){
        this.codagendamento = codagendamento;
        this.codbarbearia = codbarbearia;
        this.codcliente = codcliente;
        this.data = data;
        this.hora = hora;
        this.servico = servico;
        this.status = status;
    }
    
    public void alterarAgendamento(Agendamento a){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.updateAgendamentoCliente(a);
    }
    
    public void agendarHorario(Agendamento a){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.create(a);
    }
}
