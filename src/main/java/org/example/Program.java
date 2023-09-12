package org.example;

import org.example.entity.TransacaoEntity;
import org.example.useCase.ExecutarTransacaoFinanceiraUseCase;

public class Program {
    public static void main(String[] args) {
        TransacaoEntity[] TRANSACOES = {
                new TransacaoEntity(1, "09/09/2023 14:15:00", 938485762, 214748364, 150),
                new TransacaoEntity(2, "09/09/2023 14:15:05", 214748364, 210385733, 149),
                new TransacaoEntity(3, "09/09/2023 14:15:29", 347586970, 238596054, 1100),
                new TransacaoEntity(4, "09/09/2023 14:17:00", 675869708, 210385733, 5300),
                new TransacaoEntity(5, "09/09/2023 14:18:00", 238596054, 674038564, 1489),
                new TransacaoEntity(6, "09/09/2023 14:18:20", 573659065, 563856300, 49),
                new TransacaoEntity(7, "09/09/2023 14:19:00", 938485762, 214748364, 44),
                new TransacaoEntity(8, "09/09/2023 14:19:01", 573659065, 675869708, 150)
        };

      //  ExecutorService executorService = Executors.newFixedThreadPool(TRANSACOES.length);
        ExecutarTransacaoFinanceiraUseCase executor = new ExecutarTransacaoFinanceiraUseCase();

        for (TransacaoEntity item : TRANSACOES) {
          //  executorService.execute(() -> {
                executor.transferir(item.getCorrelationId(), item.getContaOrigem(), item.getContaDestino(), item.getValor());
           // });
        }



      //  executorService.shutdown();
    }
}

