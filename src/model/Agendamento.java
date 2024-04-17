package model;

import dao.AgendamentoDAO;
import java.sql.Time;
import java.sql.Date;

public class Agendamento {
    private int id;
    private int codcliente;
    private int codbarbearia;
    private Date data;
    private Time hora;
    private String nomebarbearia;
    private String nomecliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public Agendamento(Date data, Time hora, int codbarbearia, int codcliente, int id){
        this.id = id;
        this.codbarbearia = codbarbearia;
        this.codcliente = codcliente;
        this.data = data;
        this.hora = hora;
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
