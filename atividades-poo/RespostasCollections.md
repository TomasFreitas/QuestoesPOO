1. Java Collections Framework e Arrays
O Collections Framework é uma arquitetura unificada em Java para representar e manipular grupos de objetos (coleções). 
Principais benefícios sobre arrays: 
- Tamanho dinâmico: coleções crescem e diminuem automaticamente, enquanto arrays têm tamanho fixo.
- Métodos prontos: já vêm com funções de busca, ordenação, inserção e remoção, evitando ter que fazer na mão.
- Tipos de dados avançados: oferecem listas encadeadas, árvores, tabelas hash, etc.

2. List, Set e Map
- List: Mantém a ordem de inserção e permite elementos duplicados. Útil para: histórico de transações ou uma fila de reprodução de músicas.
- Set: Não garante ordem (na maioria das implementações) e NÃO permite elementos duplicados. Útil para: guardar uma lista de CPFs únicos ou CPFs de alunos matriculados sem repetição.
- Map: Trabalha com chave-valor. As chaves não podem se repetir, os valores sim. Útil para: um dicionário de palavras ou associar uma matrícula (chave) a um objeto Aluno (valor).

3. HashSet vs LinkedHashSet vs TreeSet
- HashSet: Nenhuma ordem. Inserção, busca e remoção muito rápidas (O(1)). Gasta menos memória.
- LinkedHashSet: Mantém a ordem em que os elementos foram inseridos. Desempenho rápido (O(1)), mas gasta um pouco mais de memória por causa dos ponteiros que ligam os elementos.
- TreeSet: Mantém os elementos ordenados (ordem alfabética, numérica ou customizada). Mais lento nas operações (O(log n)) e consome mais memória pela estrutura de árvore.
