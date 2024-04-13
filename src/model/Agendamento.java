package model;

import dao.AgendamentoDAO;

public class Agendamento {
    private int id;
    private int codcliente;
    private int codbarbearia;
    private String data;
    private String hora;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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
    
    public Agendamento(String data, String hora, int codbarbearia, int codcliente, int id){
        this.id = id;
        this.codbarbearia = codbarbearia;
        this.codcliente = codcliente;
        this.data = data;
        this.hora = hora;
        //this.nomebarbearia = nomebarbearia;
    }
    
    public void alterarAgendamento(Agendamento a){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.update(a);
    }
    
    public void agendarHorario(Agendamento a){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.create(a);
    }
}
