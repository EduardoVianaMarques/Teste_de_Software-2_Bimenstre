# Semana 10 — Prática de TDD

**Aluno:** Eduardo Viana Marques

Quatro projetos Maven independentes, executados com Java 17. Cada pasta contém o código-fonte, os testes e os registros numerados de execução em `ciclos-tdd.txt`.

| Projeto | Comportamentos verificados | Suíte final | Cobertura |
|---|---|---:|---:|
| [Bubble Sort](bubblesort-tdd/) | Ordenação crescente, vetor já ordenado e valores repetidos. | 4 | 100% |
| [Carrinho de compras](carrinho-compras-tdd/) | Total vazio, adição, soma, remoção, preço inválido e desconto, incluindo os limites de R$ 499,99, R$ 500,00 e R$ 500,01. | 10 | 100% |
| [Conta bancária](conta-bancaria-tdd-maven/) | Depósito, depósitos sucessivos, saque e preservação do saldo em saque superior ao disponível. | 7 | 100% |
| [Estoque](estoque-tdd/) | Estoque inicial, entradas, acúmulo, retirada, quantidade insuficiente e entradas negativas ou iguais a zero. | 9 | 100% |

**Resultado:** 30 testes aprovados, sem falhas ou erros na execução final.

Os registros de cada projeto mostram o RED, o GREEN e a execução após os ajustes finais. Em Conta Bancária e Estoque, os testes já fornecidos foram executados em subconjuntos durante a implementação incremental. Em Estoque, o caso de entrada zero foi acrescentado porque a lista de requisitos pede essa situação. Em Carrinho, os testes foram escritos na ordem dos seis requisitos e o relatório final conta separadamente as quatro entradas do teste parametrizado de desconto.

Em cada pasta de projeto, onde está o `pom.xml`, execute `mvn test` para rodar os testes. O comando `mvn clean verify` também gera o relatório e verifica, com JaCoCo, 100% de cobertura de instruções, desvios, linhas, métodos e classes. As evidências finais são `cobertura-mvn-verify.txt` e `jacoco.xml` em cada projeto. O [repositório da disciplina](https://github.com/JoaoChoma/teste_software_2026/tree/main/aulas/SEMANA10) contém os projetos-base e os enunciados.
