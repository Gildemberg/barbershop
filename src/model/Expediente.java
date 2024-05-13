package model;
import dao.ExpedienteDAO;
import java.sql.Date;
import java.sql.Time;

public class Expediente {
    private int codexpediente;
    private int codbarbearia;
    private Date dataInicial;
    private Date dataFinal;
    private Time horaInicial;
    private Time horaFinal;
    private int periodo;

    public int getCodexpediente() {
        return codexpediente;
    }

    public void setCodexpediente(int codexpediente) {
        this.codexpediente = codexpediente;
    }

    public int getCodbarbearia() {
        return codbarbearia;
    }

    public void setCodbarbearia(int codbarbearia) {
        this.codbarbearia = codbarbearia;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Time getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Expediente(){
    }
    
    public Expediente(int codbarbearia, Date dataInicial, Date dataFinal, Time horaInicial, Time horaFinal){
        this.codbarbearia = codbarbearia;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }
    
    public void adicionarExpediente(Expediente e){
        
    }
    
    public void removerExpediente(Expediente e){
        ExpedienteDAO dao = new ExpedienteDAO();
        dao.removeExpediente(e);
    }
}
