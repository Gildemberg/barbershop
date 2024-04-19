package model;
import java.sql.Date;
import dao.ExpedienteDAO;

public class Expediente {
    private int codexpediente;
    private int codbarbearia;
    private Date data;

    public int getCodbarbearia() {
        return codbarbearia;
    }

    public void setCodbarbearia(int codbarbearia) {
        this.codbarbearia = codbarbearia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return codexpediente;
    }

    public void setId(int id) {
        this.codexpediente = id;
    }

    public Expediente(){
    }
    
    public Expediente(Date data, int codbarbearia){
        this.codbarbearia = codbarbearia;
        this.data = data;
    }
    
    public void removerExpediente(Expediente e){
        ExpedienteDAO dao = new ExpedienteDAO();
        dao.removeExpediente(e);
    }
}
