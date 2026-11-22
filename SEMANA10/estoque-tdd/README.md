# Estoque — Exemplo de TDD

Projeto Maven com Java 17 e JUnit 5 para demonstração de TDD.

## Executar

```bash
mvn test
```

## Casos de teste

1. Produto inicia com estoque zero.
2. Adicionar unidades ao estoque.
3. Acumular várias entradas.
4. Retirar unidades do estoque.
5. Não permitir retirada maior que o estoque disponível.
6. Não permitir entrada com quantidade negativa.
7. Preservar o estoque ao receber entrada de zero unidades.

A proposta didática é construir a implementação incrementalmente, executando
os testes durante os ciclos RED → GREEN → REFACTOR.

A suíte final passou com 7 testes. Os registros estão em `ciclos-tdd.txt`.

A verificação de cobertura incluiu os testes complementares. O resultado de `mvn verify` foi de 9 testes aprovados e 100% de cobertura.
