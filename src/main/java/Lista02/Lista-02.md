# Lista 02 — Questões teóricas

## Questão 1 — Por que usar getters e setters?

Um atributo público pode ser alterado por qualquer ponto do programa, a qualquer
momento, para qualquer valor. Isso significa que a classe perde o controle sobre o
próprio estado: se existe alguma regra sobre o que é um valor válido, não há onde
colocá-la. Getters e setters existem para dar à classe esse ponto único de controle.

Na prática, três ganhos concretos:

1. **Validação em um só lugar.** A regra fica dentro da classe, não espalhada em
   cada ponto que mexe no atributo. Se a regra muda, muda em um arquivo.
2. **Invariantes garantidos.** A classe pode prometer algo sobre si mesma — "o saldo
   nunca é negativo" — e cumprir essa promessa, porque nada externo consegue
   contornar os métodos.
3. **Liberdade para mudar a implementação.** Se `getSaldo()` passar a calcular o
   valor a partir de uma lista de lançamentos em vez de ler um campo, quem usa a
   classe não precisa ser alterado. Com o campo público, toda a base de código que o
   acessa quebra.

Um detalhe importante: gerar automaticamente um getter e um setter para *todo*
atributo não é encapsulamento. Um `setSaldo(double)` público é um campo público com
passos extras — o estado continua podendo ir para qualquer valor. Encapsular é
escolher **quais** operações a classe oferece.

É o que a `ContaCorrente` deste repositório faz: o campo `saldo` é privado e **não
existe** `setSaldo`. O saldo só muda por `sacar()` e `depositar()`, que verificam o
valor, o limite por operação e a disponibilidade antes de alterar o estado. Com isso
não é possível, de fora da classe, zerar a conta de um cliente ou creditar um valor
que não passou pela validação.

## Questão 2 — Classe Livro no sistema de uma biblioteca

### a) Quais informações devem ser armazenadas

Atributos que descrevem o livro em si:

| Atributo    | Tipo      | Observação |
|-------------|-----------|------------|
| `isbn`      | `String`  | **Não é `int`.** O ISBN-13 tem 13 dígitos (estoura `int`), pode conter hífens e o ISBN-10 admite `X` como dígito verificador. Além disso nunca é usado em conta — é identificador, não número. |
| `titulo`    | `String`  | |
| `autores`   | `List<String>` | Um livro pode ter mais de um autor. |
| `disponivel`| `boolean` | Estado atual de disponibilidade para empréstimo. |

As informações do empréstimo em si — quem pegou, quando, prazo de devolução,
quantas renovações já houve — **não** deveriam ficar dentro de `Livro`. Elas
descrevem um evento, não o livro. Guardá-las em `Livro` tem dois problemas:

- só cabe um empréstimo por vez, então o histórico é perdido a cada devolução;
- quando o livro está disponível, todos esses campos ficam nulos ou com valor
  inválido, e todo código que os lê precisa checar isso.

O modelo melhor é uma classe `Emprestimo` separada, com referências para `Livro` e
`Usuario`, e as datas. `Livro` guarda apenas `disponivel` (ou nem isso, se a
disponibilidade for derivada da existência de um `Emprestimo` em aberto).

### b) Por que a classe Livro é uma abstração

Porque ela não representa o livro físico — representa apenas o que o sistema da
biblioteca precisa saber sobre ele. Um livro real tem peso, número de páginas,
editora, estado de conservação, cor da capa, cheiro de papel. A classe guarda ISBN,
título, autor e disponibilidade, e descarta todo o resto.

Abstrair é exatamente isso: escolher, dentro do escopo do problema, quais
características são relevantes e ignorar deliberadamente as demais. A mesma entidade
"livro" teria atributos completamente diferentes em um sistema de uma editora
(custo de impressão, tiragem, royalties) ou de uma transportadora (peso, dimensões).
Não existe a modelagem "certa" de um livro — existe a modelagem adequada ao sistema.

### c) Métodos essenciais

| Método | Papel |
|--------|-------|
| `Livro(isbn, titulo, autores)` | Construtor: nasce com os dados obrigatórios já preenchidos e válidos. |
| `getIsbn()`, `getTitulo()`, `getAutores()` | Leitura dos dados identificadores. Sem setters: esses dados não mudam. |
| `isDisponivel()` | Consulta de estado, usada antes de tentar emprestar. |
| `emprestar()` | Marca o livro como emprestado. Falha se já estiver emprestado. |
| `devolver()` | Marca o livro como disponível de novo. |
| `toString()` | Representação legível para listagens e relatórios. |

A renovação de empréstimo **não** entra aqui: ela mexe na data de devolução, que é
responsabilidade de `Emprestimo`. Colocar `renovar()` em `Livro` seria dar à classe
uma responsabilidade que não é dela.

Um setter para `titulo` ou `autores` só se justificaria para correção de erro de
cadastro — e nesse caso é mais honesto expor um método com esse nome
(`corrigirCadastro(...)`) do que um setter genérico.

## Questões práticas

| Questão | Implementação |
|---------|---------------|
| Classe `Produto` com encapsulamento | [`Produto.java`](Produto.java) |
| Classe `ContaCorrente` com saque e depósito | [`ContaCorrente.java`](ContaCorrente.java) |
| Programa de teste | [`Main.java`](Main.java) |
