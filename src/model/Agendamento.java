package model;

import dao.AgendamentoDAO;

public class Agendamento {
    private int id;
    private int cod_usr;
    private int cod_emp;
    private String data;
    private String hora;

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
    
    public Agendamento(){
    }
    
    public Agendamento(int cod_emp, int cod_usr, String data, String hora){
        this.cod_emp = cod_emp;
        this.cod_usr = cod_usr;
        this.data = data;
        this.hora = hora;
    }
    
    public void agendarHorario(Agendamento a){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.create(a);
    }
}
