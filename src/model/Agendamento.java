package model;

import dao.AgendamentoDAO;

public class Agendamento {
    private int id;
    private int cod_fun;
    private int cod_usr;
    private int dia;
    private int mes;
    private String hora;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getCod_fun() {
        return cod_fun;
    }

    public void setCod_fun(int cod_fun) {
        this.cod_fun = cod_fun;
    }

    public int getCod_usr() {
        return cod_usr;
    }

    public void setCod_usr(int cod_usr) {
        this.cod_usr = cod_usr;
    }
    
    public Agendamento(){
    }
    
    public Agendamento(int dia, int mes, String hora, int cod_fun, int cod_usr){
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
        this.cod_fun = cod_fun;
        this.cod_usr = cod_usr;
    }
    
    public void agendarHorario(Agendamento a){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.create(a);
    }
}
