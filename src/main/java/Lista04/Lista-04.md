# Lista 04 — Questões teóricas

## Questão 1 — Verdadeiro ou falso

* **a)** Verdadeira. Os construtores pertencem à classe em que são declarados e não são herdados pelas subclasses.
* **b)** Falsa. O relacionamento "tem um" (composição ou agregação) é implementado declarando variáveis de instância de outras classes dentro da classe. A herança, por sua vez, implementa o relacionamento "é um".
* **c)** Falsa. Quando uma subclasse redefine um método com a mesma assinatura, diz-se que a subclasse **sobrescreve** (override) esse método. A sobrecarga (overload) ocorre quando existem métodos com o mesmo nome, mas com assinaturas diferentes (parâmetros diferentes) dentro da mesma classe.

## Questão 2 — Acesso `protected` versus acesso `private`

O acesso `private` garante um encapsulamento estrito, o que significa que as variáveis de instância só podem ser modificadas e lidas pelos métodos da própria classe. Isso protege o estado da superclasse e reduz o acoplamento, mas exige que as subclasses utilizem métodos *getter* e *setter* para interagir com esses dados, o que pode aumentar a verbosidade do código.

O acesso `protected`, por outro lado, permite que as subclasses (e classes do mesmo pacote) acessem diretamente os membros da superclasse. Isso facilita a programação nas subclasses, evitando chamadas excessivas a métodos, mas quebra parcialmente o encapsulamento, uma vez que a superclasse perde o controle exclusivo sobre como o seu estado é alterado pelas subclasses.

## Questão 3 — Chamada de construtores em hierarquias de herança

Quando uma subclasse é instanciada, o seu construtor é chamado. No entanto, antes de executar o corpo do construtor da subclasse, o construtor da superclasse é invocado (seja por uma chamada explícita a `super()` ou por uma chamada implícita inserida pelo compilador). Isso cria uma cadeia de chamadas de construtores que vai até a classe base `Object`.

Essa chamada é obrigatória porque a subclasse herda o estado (variáveis) da superclasse. O construtor da superclasse tem a responsabilidade de inicializar corretamente esse estado fundamental antes que a subclasse possa operar sobre ele ou adicionar o seu próprio estado específico.
