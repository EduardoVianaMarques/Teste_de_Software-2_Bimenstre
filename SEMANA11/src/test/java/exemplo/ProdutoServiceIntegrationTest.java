package exemplo;

import exemplo.model.Produto;
import exemplo.repository.ProdutoRepository;
import exemplo.service.ProdutoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {

    @Autowired ProdutoService service;
    @Autowired ProdutoRepository repository;
    @Autowired EntityManager entityManager;

    @Test
    void deveCadastrarERecuperarProduto() {
        Produto produto = service.cadastrar("Teclado", 150.0);
        assertNotNull(produto.getId());

        entityManager.flush();
        entityManager.clear();

        Produto persistido = repository.findById(produto.getId()).orElseThrow();
        assertEquals("Teclado", persistido.getNome());
        assertEquals(150.0, persistido.getPreco());
    }

    @Test
    void naoDevePersistirProdutoComNomeEmBranco() {
        long totalAntes = repository.count();

        assertThrows(IllegalArgumentException.class, () -> service.cadastrar("   ", 80.0));

        assertEquals(totalAntes, repository.count());
    }

    @Test
    void deveAtualizarPrecoPersistido() {
        Long id = service.cadastrar("Mouse", 80.0).getId();
        entityManager.flush();
        entityManager.clear();

        service.atualizarPreco(id, 95.0);
        entityManager.flush();
        entityManager.clear();

        Produto persistido = repository.findById(id).orElseThrow();
        assertEquals(95.0, persistido.getPreco());
    }
}
