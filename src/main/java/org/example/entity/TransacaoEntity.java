package org.example.entity;

public class TransacaoEntity {
    private int correlation_id;
    private String datetime;
    private int conta_origem;
    private int conta_destino;
    private double VALOR;

    public TransacaoEntity(int correlation_id, String datetime, int conta_origem, int conta_destino, double VALOR) {
        this.correlation_id = correlation_id;
        this.datetime = datetime;
        this.conta_origem = conta_origem;
        this.conta_destino = conta_destino;
        this.VALOR = VALOR;
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
        return VALOR;
    }
}
