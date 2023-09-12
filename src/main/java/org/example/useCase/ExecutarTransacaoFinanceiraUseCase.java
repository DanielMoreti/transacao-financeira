package org.example.useCase;

import org.example.dataProvider.AcessoDadosDataProvider;
import org.example.entity.ContasSaldoEntity;

public class ExecutarTransacaoFinanceiraUseCase extends AcessoDadosDataProvider {
    public void transferir(int correlation_id, int conta_origem, int conta_destino, double valor) {
        ContasSaldoEntity conta_saldo_origem = getSaldo(ContasSaldoEntity.class, conta_origem);
        if (conta_saldo_origem.getSaldo() < valor) {
            System.out.println("entity.Transacao numero " + correlation_id + " foi cancelada por falta de saldo");
        } else {
            ContasSaldoEntity conta_saldo_destino = getSaldo(ContasSaldoEntity.class, conta_destino);
            conta_saldo_origem.setSaldo(conta_saldo_origem.getSaldo() - valor);
            conta_saldo_destino.setSaldo(conta_saldo_destino.getSaldo() + valor);
            System.out.println("entity.Transacao numero " + correlation_id + " foi efetivada com sucesso! Novos saldos: Conta Origem: " + conta_saldo_origem.getSaldo() + " | Conta Destino: " + conta_saldo_destino.getSaldo());
        }
    }
}
