package dataProvider;

import org.example.dataProvider.AcessoDadosDataProvider;
import org.example.entity.ContasSaldoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcessoDadosDataProviderTest {

    AcessoDadosDataProvider dataProvider;
    @BeforeEach
    public void setUp() {
        dataProvider = new AcessoDadosDataProvider();
    }

    @Test
    public void testGetSaldoExistente() {
        ContasSaldoEntity saldo = dataProvider.getSaldo(ContasSaldoEntity.class, 938485762);
        assertEquals(180.0, saldo.getSaldo());
    }

    @Test
    public void testGetSaldoInexistente() {
        ContasSaldoEntity saldo = dataProvider.getSaldo(ContasSaldoEntity.class, 123456789);
        assertNull(saldo);
    }

    @Test
    public void testAtualizarSucesso() {
        ContasSaldoEntity novoSaldo = new ContasSaldoEntity(938485762, 200.0);
        assertTrue(dataProvider.atualizar(novoSaldo));

        ContasSaldoEntity saldoAtualizado = dataProvider.getSaldo(ContasSaldoEntity.class, 938485762);
        assertEquals(200.0, saldoAtualizado.getSaldo());
    }
}