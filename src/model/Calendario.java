package model;
import dao.CalendarioDAO;

public class Calendario {
    private String hora, dia, mes, ano;
    private int id, cod_emp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(int cod_emp) {
        this.cod_emp = cod_emp;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    public Calendario(){
    }
    
    public Calendario(int cod_emp, String hora, String dia, String mes, String ano){
        this.cod_emp = cod_emp;
        this.hora = hora;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public void criarCalendario(Calendario c){
        CalendarioDAO cdao = new CalendarioDAO();
        cdao.create(c);
    }
}
