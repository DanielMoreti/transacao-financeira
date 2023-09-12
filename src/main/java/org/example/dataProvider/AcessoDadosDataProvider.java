package org.example.dataProvider;

import org.example.entity.ContasSaldoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class AcessoDadosDataProvider {
    private Map<Integer, Double> SALDOS;
    public List<ContasSaldoEntity> TABELA_SALDOS;

    public AcessoDadosDataProvider() {
        TABELA_SALDOS = new ArrayList<>();
        TABELA_SALDOS.add(new ContasSaldoEntity(938485762, 180));
        TABELA_SALDOS.add(new ContasSaldoEntity(347586970, 1200));
        TABELA_SALDOS.add(new ContasSaldoEntity(214748364, 0));
        TABELA_SALDOS.add(new ContasSaldoEntity(675869708, 4900));
        TABELA_SALDOS.add(new ContasSaldoEntity(238596054, 478));
        TABELA_SALDOS.add(new ContasSaldoEntity(573659065, 787));
        TABELA_SALDOS.add(new ContasSaldoEntity(210385733, 10));
        TABELA_SALDOS.add(new ContasSaldoEntity(674038564, 400));
        TABELA_SALDOS.add(new ContasSaldoEntity(563856300, 1200));

        SALDOS = new ConcurrentHashMap<>();
        SALDOS.put(938485762, 180.0);
    }

    public <T> T getSaldo(Class<T> type, int id) {
        return type.cast(TABELA_SALDOS.stream()
                .filter(x -> x.getConta() == id)
                .findFirst()
                .orElse(null));
    }

    public boolean atualizar(Object dado) {
        try {
            ContasSaldoEntity item = (ContasSaldoEntity) dado;
            TABELA_SALDOS.removeIf(x -> x.getConta() == item.getConta());
            TABELA_SALDOS.add((ContasSaldoEntity) dado);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
