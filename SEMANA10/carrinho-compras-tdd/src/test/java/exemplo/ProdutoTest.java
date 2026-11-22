package exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoTest {

    @Test
    void deveExporONomeEOPrecoDoProduto() {
        Produto produto = new Produto("Teclado", 100.0);

        assertEquals("Teclado", produto.getNome());
        assertEquals(100.0, produto.getPreco());
    }
}
