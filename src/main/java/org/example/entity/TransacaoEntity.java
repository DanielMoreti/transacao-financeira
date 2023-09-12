package org.example.entity;

public class TransacaoEntity {
    private int correlation_id;
    private String date_time;
    private int conta_origem;
    private int conta_destino;
    private double valor;

    public TransacaoEntity(int correlation_id, String date_time, int conta_origem, int conta_destino, double valor) {
        this.correlation_id = correlation_id;
        this.date_time = date_time;
        this.conta_origem = conta_origem;
        this.conta_destino = conta_destino;
        this.valor = valor;
    }

    public int getCorrelationId() {
        return correlation_id;
    }

    public int getContaOrigem() {
        return conta_origem;
    }

    public int getContaDestino() {
        return conta_destino;
    }

    public double getValor() {
        return valor;
    }
}
