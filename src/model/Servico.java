package model;
import dao.BarbeariaDAO;
import java.sql.Time;

public class Servico {
    private int codservico;
    private int CODBARBEARIA;
    private String nome;
    private Float valor;
    private Time tempo;

    public int getId() {
        return codservico;
    }

    public void setId(int id) {
        this.codservico = id;
    }

    public int getCODBARBEARIA() {
        return CODBARBEARIA;
    }

    public void setCODBARBEARIA(int CODBARBEARIA) {
        this.CODBARBEARIA = CODBARBEARIA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getTempo() {
        return tempo;
    }

    public void setTempo(Time tempo) {
        this.tempo = tempo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    
    public Servico(){
    }
    
    public Servico(int CODBARBEARIA, String nome, Float valor, Time tempo){
        this.CODBARBEARIA = CODBARBEARIA;
        this.nome = nome;
        this.valor = valor;
        this.tempo = tempo;
    }
    
    public void alterarServico(Servico s){
        BarbeariaDAO dao = new BarbeariaDAO();
        dao.alterarServico(s);
    }
    
    public void cadastrarServico(Servico s){
        BarbeariaDAO dao = new BarbeariaDAO();
        dao.cadastrarServico(s);
    }
}
