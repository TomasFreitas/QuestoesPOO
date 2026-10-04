# Questões de POO

Resoluções das listas da disciplina de Programação Orientada a Objetos.

| Lista | Conteúdo |
|-------|----------|
| [Lista 01](src/main/java/Lista01) | Entrada/saída, condicionais, laços, vetores. Questões teóricas abaixo. |
| [Lista 02](src/main/java/Lista02) | Classes, encapsulamento, abstração. Questões teóricas em [`Lista-02.md`](src/main/java/Lista02/Lista-02.md). |
| [util](src/main/java/util) | [`Entrada`](src/main/java/util/Entrada.java): leitura de teclado com validação, usada pelas duas listas. |

## Como executar

```bash
# Lista 01 (menu com as questões 1 a 4)
mvn -q compile exec:java -Dexec.mainClass=Lista01.Main

# Lista 02 (conta corrente e produto)
mvn -q compile exec:java -Dexec.mainClass=Lista02.Main
```

Sem Maven:

```bash
javac -encoding UTF-8 -d target/classes $(find src/main/java -name '*.java')
java -cp target/classes Lista01.Main
```

Projeto compila com `--release 21`.

> **Separador decimal:** `Scanner.nextDouble()` segue o locale do sistema. Em
> `pt_BR` digite `349,90` (vírgula); em `en_US`, `349.90` (ponto).

---

# Lista 01 — Questões teóricas

## Questão 5 — `Scanner` e `System.out.printf`

As duas classes ficam em lados opostos do fluxo de dados do programa: `Scanner` é
**entrada**, `System.out.printf` é **saída**.

### `Scanner` — leitura

`Scanner` envolve uma fonte de dados e a quebra em pedaços tipados. Criado com
`new Scanner(System.in)`, lê o que o usuário digita no teclado:

```java
Scanner in = new Scanner(System.in);

String nome = in.nextLine();   // lê até o fim da linha
int idade = in.nextInt();      // lê um inteiro
double altura = in.nextDouble(); // lê um número real
```

Dois cuidados práticos que aparecem em quase todo exercício:

1. **`nextInt()` não consome a quebra de linha.** Depois de ler um número, o `\n`
   continua no buffer, e o `nextLine()` seguinte retorna string vazia. A solução é
   chamar um `nextLine()` extra para descartar o resto da linha — é o que os
   exercícios deste repositório fazem.
2. **Um `Scanner` por fonte.** Criar vários `Scanner` sobre `System.in` dá problema:
   cada um tem seu próprio buffer interno, e um acaba consumindo dados que o outro
   esperava. Por isso o `Main` de cada lista cria um único `Scanner` e o repassa como
   parâmetro para as questões.

### `System.out.printf` — escrita formatada

`println` só concatena e imprime. `printf` recebe um *template* com marcadores e os
valores que entram em cada marcador, no estilo do `printf` do C:

```java
System.out.printf("%s tem %d anos e %.2f de altura.%n", nome, idade, altura);
```

| Marcador | Serve para |
|----------|------------|
| `%s` | texto |
| `%d` | inteiro |
| `%f` | número real |
| `%.2f` | real com exatamente 2 casas decimais |
| `%n` | quebra de linha independente do sistema operacional |

O controle de casas decimais é o uso mais comum em exercícios:

```java
double valor = 34.356;
System.out.printf("Preço: R$ %.2f%n", valor);  // Preço: R$ 34,36
```

O valor não é truncado — é **arredondado** (34.356 → 34,36). E, em locale pt-BR,
o separador decimal impresso é a vírgula, não o ponto.

Vale usar `%n` em vez de `\n`: `%n` emite a quebra de linha da plataforma, enquanto
`\n` é sempre LF.

## Questão 6 — Erros no código a seguir

Código original:

```java
import java.util.Scanner;

public class Contador {
    public static void main(String args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        while (contador <= 5) {
            System.out.println("Contador: " + contador)
        }
    }
}
```

### Erros de compilação

**1. `String args` em vez de `String[] args`**

O método `main` precisa receber um **vetor** de `String`. Sem os colchetes, a JVM não
reconhece o método como ponto de entrada e o programa nem inicia — a mensagem é
`Main method not found in class Contador`. Note que o código *compila*: o erro só
aparece na execução. As duas formas válidas são `String[] args` e `String args[]`
(a primeira é a convencional).

**2. Falta o ponto e vírgula depois do `println`**

Em Java o `;` encerra cada instrução — não é a quebra de linha que faz isso. Sem ele:
`';' expected`.

### Erro de lógica

**3. `contador` nunca é incrementado**

A variável é inicializada em 0 e nada dentro do `while` a altera. A condição
`contador <= 5` é testada sempre com o mesmo valor, nunca se torna falsa, e o
programa imprime `Contador: 0` para sempre — **laço infinito**. É o erro mais grave
dos três, porque não é apontado pelo compilador.

### Problemas adicionais

**4. O `Scanner` é criado e nunca usado**

`sc` não é lido em nenhum ponto. Além de ser código morto, mantém um recurso aberto
sem necessidade. Como nada é lido do teclado, o certo é simplesmente remover a linha.

**5. A condição provavelmente erra o número de iterações**

`contador <= 5` partindo de 0 executa **6** vezes (0, 1, 2, 3, 4, 5). Se a intenção
era contar cinco vezes, a condição deveria ser `contador < 5`, ou o contador deveria
partir de 1.

### Código corrigido

```java
public class Contador {
    public static void main(String[] args) {
        for (int contador = 0; contador <= 5; contador++) {
            System.out.println("Contador: " + contador);
        }
    }
}
```

O `for` foi preferido ao `while` porque inicialização, condição e incremento ficam
na mesma linha — é mais difícil esquecer o incremento, que foi exatamente o erro do
código original. Com `while`, a correção mínima seria:

```java
int contador = 0;
while (contador <= 5) {
    System.out.println("Contador: " + contador);
    contador++;
}
```
