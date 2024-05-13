package model;

import java.sql.Date;
import java.sql.Time;

public class Extrato {
    private int codextrato, codagendamento, codbarbearia;
    private Date data;
    private Time hora;
    private float valorPago, valorServico;
    private String servico, cliente;

    public int getCodextrato() {
        return codextrato;
    }

    public void setCodextrato(int codextrato) {
        this.codextrato = codextrato;
    }

    public int getCodagendamento() {
        return codagendamento;
    }

    public void setCodagendamento(int codagendamento) {
        this.codagendamento = codagendamento;
    }

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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public float getValorServico() {
        return valorServico;
    }

    public void setValorServico(float valorServico) {
        this.valorServico = valorServico;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public Extrato(){
    }
    
    public Extrato(int codextrato, int codbarbearia, int codagendamento, String cliente, String servico, Date data, Time hora, float valorServico, float valorPago){
        this.codextrato = codextrato;
        this.codagendamento = codagendamento;
        this.codbarbearia = codbarbearia;
        this.data = data;
        this.hora = hora;
        this.valorPago = valorPago;
    }
}