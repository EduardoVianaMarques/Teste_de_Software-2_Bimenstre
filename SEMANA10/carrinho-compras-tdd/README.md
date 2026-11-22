# Carrinho de Compras — TDD

Projeto Maven para prática de TDD com Java 17 e JUnit 5.

## Executar os testes

```bash
mvn test
```

## Resultado

Os seis requisitos foram implementados seguindo os ciclos registrados em `ciclos-tdd.txt`. A suíte passou com 9 execuções, incluindo 4 valores no teste parametrizado de desconto.

A adição de um produto com preço negativo lança `IllegalArgumentException` e preserva o carrinho. Esta foi a opção adotada entre as duas previstas no enunciado. Valores monetários são calculados com `BigDecimal` e arredondados para centavos com `HALF_UP`. O desconto de 10% é aplicado ao subtotal de R$ 500,00 ou mais.

A verificação de cobertura incluiu os testes complementares. O resultado de `mvn verify` foi de 10 testes aprovados e 100% de cobertura.
