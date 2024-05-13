package model;
import dao.BarbeariaDAO;
import java.sql.Time;

public class Servico {
    private int codservico;
    private int CODBARBEARIA;
    private String nome;
    private Float valor;
    private int opcao;

    public int getCodservico() {
        return codservico;
    }

    public void setCodservico(int codservico) {
        this.codservico = codservico;
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
    
    public Servico(){
    }
    
    public Servico(int CODBARBEARIA, String nome, Float valor){
        this.CODBARBEARIA = CODBARBEARIA;
        this.nome = nome;
        this.valor = valor;
    }
    
    public void alterarServico(Servico s){
        BarbeariaDAO dao = new BarbeariaDAO();
        dao.alterarServico(s);
    }
    
    public void cadastrarServico(Servico s){
        BarbeariaDAO dao = new BarbeariaDAO();
        dao.cadastrarServico(s);
    }
    
    public void deletarServico(Servico s){
        BarbeariaDAO dao = new BarbeariaDAO();
        dao.deletarServico(s);
    }
}
