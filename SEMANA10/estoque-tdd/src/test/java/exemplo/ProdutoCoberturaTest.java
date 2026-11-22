package exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoCoberturaTest {

    @Test
    void deveManterNomeInformado() {
        Produto produto = new Produto("Teclado");

        assertEquals("Teclado", produto.getNome());
    }

    @Test
    void naoDeveAlterarEstoqueAoRetirarQuantidadeNegativa() {
        Produto produto = new Produto("Teclado");
        produto.adicionarEstoque(10);

        produto.retirarEstoque(-3);

        assertEquals(10, produto.getQuantidade());
    }
}
