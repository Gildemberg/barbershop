package model;

import dao.AgendamentoDAO;

public class Agendamento {
    private int id;
    private int cod_usr;
    private int cod_emp;
    private String data;
    private String hora;
    private String nome_emp;
    private String nome_usr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_usr() {
        return cod_usr;
    }

    public void setCod_usr(int cod_usr) {
        this.cod_usr = cod_usr;
    }

    public int getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(int cod_emp) {
        this.cod_emp = cod_emp;
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

    public String getNome_emp() {
        return nome_emp;
    }
    
    public void setNome_emp(String nome_emp) {
        this.nome_emp = nome_emp;
    }
    
    public String getNome_usr() {
        return nome_usr;
    }

    public void setNome_usr(String nome_usr) {
        this.nome_usr = nome_usr;
    }
    
    
    public Agendamento(){
    }
    
    public Agendamento(int cod_emp, int cod_usr, String data, String hora, String nome_emp, int id){
        this.id = id;
        this.cod_emp = cod_emp;
        this.cod_usr = cod_usr;
        this.data = data;
        this.hora = hora;
        this.nome_emp = nome_emp;
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
