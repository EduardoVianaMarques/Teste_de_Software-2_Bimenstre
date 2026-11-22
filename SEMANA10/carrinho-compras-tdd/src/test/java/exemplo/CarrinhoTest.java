package exemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarrinhoTest {
    @Test
    void deveTerTotalZeroQuandoVazio() {
        Carrinho carrinho = new Carrinho();

        assertEquals(0.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveAdicionarUmProduto() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100.0));

        assertEquals(100.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveSomarVariosProdutos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100.0));
        carrinho.adicionar(new Produto("Mouse", 50.0));

        assertEquals(150.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveRemoverProduto() {
        Carrinho carrinho = new Carrinho();
        Produto mouse = new Produto("Mouse", 50.0);
        carrinho.adicionar(new Produto("Teclado", 100.0));
        carrinho.adicionar(mouse);

        carrinho.remover(mouse);

        assertEquals(100.0, carrinho.getTotal(), 0.001);
    }

    @Test
    void deveRejeitarPrecoNegativo() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Mouse", 50.0));
        Produto teclado = new Produto("Teclado", -100.0);

        assertThrows(IllegalArgumentException.class, () -> carrinho.adicionar(teclado));
        assertEquals(50.0, carrinho.getTotal(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({"600.00, 540.00", "499.99, 499.99", "500.00, 450.00", "500.01, 450.01"})
    void deveAplicarDescontoAPartirDeQuinhentos(double subtotal, double totalEsperado) {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Monitor", 300.00));
        carrinho.adicionar(new Produto("Acessório", subtotal - 300.00));

        assertEquals(totalEsperado, carrinho.getTotal(), 0.001);
    }
}
