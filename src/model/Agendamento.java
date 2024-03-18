package model;

import dao.AgendamentoDAO;

public class Agendamento {
    private int id;
    private int cod_usr;
    private int cod_cal;

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

    public int getCod_cal() {
        return cod_cal;
    }

    public void setCod_cal(int cod_cal) {
        this.cod_cal = cod_cal;
    }
    
    public Agendamento(){
    }
    
    public Agendamento(int cod_cal, int cod_usr){
        this.cod_cal = cod_cal;
        this.cod_usr = cod_usr;
    }
    
    public void agendarHorario(Agendamento a){
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.create(a);
    }
}
