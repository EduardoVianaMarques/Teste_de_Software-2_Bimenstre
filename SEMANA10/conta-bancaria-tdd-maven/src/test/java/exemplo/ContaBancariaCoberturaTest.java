package exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaCoberturaTest {

    @Test
    void deveIgnorarDepositoNegativo() {
        ContaBancaria conta = new ContaBancaria();

        conta.depositar(-10);

        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    void deveIgnorarDepositoInfinito() {
        ContaBancaria conta = new ContaBancaria();

        conta.depositar(Double.POSITIVE_INFINITY);

        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    void deveIgnorarSaqueNegativo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(50);

        conta.sacar(-10);

        assertEquals(50.0, conta.getSaldo());
    }
}
