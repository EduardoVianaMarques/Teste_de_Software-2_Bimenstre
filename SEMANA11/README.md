# Semana 11 — Testes de integração com Spring Boot e JUnit 5

**Aluno:** Eduardo Viana Marques

## Testes executados

| Caso | Verificação | Resultado |
|---|---|---|
| CT01 — Cadastro válido | Cadastrou Teclado por R$ 150,00, conferiu o ID e recuperou nome e preço pelo repositório. | Passou |
| CT02 — Nome inválido | Tentou cadastrar nome em branco por R$ 80,00, esperou `IllegalArgumentException` e verificou que a contagem permaneceu igual. | Passou |
| CT03 — Atualização (desafio) | Cadastrou Mouse por R$ 80,00, atualizou para R$ 95,00 e consultou novamente o registro. | Passou |
| CT04 — Cadastro via API | Enviou o JSON do Mouse em `POST /produtos` e verificou HTTP 200, ID numérico, nome e preço. | Passou |
| CT05 — Consulta via API | Cadastrou via POST, extraiu o ID com Jackson, consultou `GET /produtos/{id}` e verificou HTTP 200 e todos os dados. | Passou |

**Evidência:** [saída do Maven](mvn-clean-test.txt), obtida em 22/11/2026 com Java 17.0.17 e Maven 3.9.11. Resultado: **5 testes, 0 falhas, 0 erros e 0 ignorados**.

## Persistência e isolamento

O objeto devolvido por `cadastrar()` ou `atualizarPreco()` reflete o estado da entidade dentro da aplicação. Em CT01 e CT03, `EntityManager.flush()` envia as mudanças pendentes ao H2 e `clear()` remove as entidades gerenciadas do contexto JPA. Assim, `repository.findById()` lê o registro do banco. CT05 também limpa o contexto entre POST e GET para que a consulta HTTP recupere o produto persistido.

Em cada método com `@Transactional`, o Spring reverte a transação de teste ao final. Isso inclui as gravações feitas pelo fluxo MockMvc, tratado na mesma aplicação de teste. Dessa forma, os registros criados por um método não ficam disponíveis para os seguintes.

## Integração HTTP

O MockMvc cria requisições servlet simuladas e as encaminha ao `DispatcherServlet` do contexto Spring, sem abrir uma porta HTTP. O teste exercita o mapeamento das rotas, a conversão do JSON, o Controller, o Service, o Repository, o JPA e o banco H2. Um teste unitário com dependências simuladas consegue conferir o comportamento isolado do Controller, mas não comprova a integração com a persistência real.

A configuração em `src/test/resources/mockito-extensions/` seleciona o modo de inicialização do Mockito que dispensa anexar um agente à JVM. O Spring Boot carrega essa dependência no contexto de testes mesmo sem mocks no código. Controller, Service e Repository foram usados com suas implementações reais.

[Projeto-base e enunciado](https://github.com/JoaoChoma/teste_software_2026/tree/main/aulas/SEMANA11/exercicios_integracao_springboot).
