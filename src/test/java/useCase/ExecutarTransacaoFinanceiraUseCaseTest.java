package useCase;

import org.example.entity.ContasSaldoEntity;
import org.example.useCase.ExecutarTransacaoFinanceiraUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutarTransacaoFinanceiraUseCaseTest {

    private ExecutarTransacaoFinanceiraUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new ExecutarTransacaoFinanceiraUseCase();
    }

    @Test
    public void testTransferirComSaldoSuficiente() {
        // Simulando saldo suficiente
        useCase.TABELA_SALDOS = new ArrayList<>();
        useCase.TABELA_SALDOS.add(new ContasSaldoEntity(1, 500.0));
        useCase.TABELA_SALDOS.add(new ContasSaldoEntity(2, 200.0));

        // Executando a transferência
        useCase.transferir(1, 1, 2, 100.0);

        // Verificando se a transferência foi efetivada com sucesso
        assertEquals(400.0, useCase.getSaldo(ContasSaldoEntity.class, 1).getSaldo());
        assertEquals(300.0, useCase.getSaldo(ContasSaldoEntity.class, 2).getSaldo());
    }

    @Test
    public void testTransferirComSaldoInsuficiente() {
        // Simulando saldo insuficiente
        useCase.TABELA_SALDOS = new ArrayList<>();
        useCase.TABELA_SALDOS.add(new ContasSaldoEntity(1, 50.0));
        useCase.TABELA_SALDOS.add(new ContasSaldoEntity(2, 200.0));

        // Executando a transferência
        useCase.transferir(2, 1, 2, 100.0);

        // Verificando se a transferência foi cancelada
        assertEquals(50.0, useCase.getSaldo(ContasSaldoEntity.class, 1).getSaldo());
        assertEquals(200.0, useCase.getSaldo(ContasSaldoEntity.class, 2).getSaldo());
    }
}