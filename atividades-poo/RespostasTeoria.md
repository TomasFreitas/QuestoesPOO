1. Métodos default e static nas interfaces (Java 8)
A partir do Java 8, deu para colocar métodos com corpo nas interfaces usando `default` ou `static`. 
- O `default` é muito útil para adicionar métodos novos em uma interface sem quebrar o código das classes antigas que já a implementavam. 
- O `static` funciona como um método utilitário direto da interface, sem precisar instanciar nada.

2. Desacoplamento e manutenção
As interfaces ajudam a definir só o "contrato" do que precisa ser feito, sem amarrar o sistema a uma classe específica. Isso diminui o acoplamento.
Exemplo prático: Em um sistema de loja, a classe de Checkout pode depender de uma interface `MetodoPagamento` em vez de depender direto de uma classe `CartaoCredito`. Se amanhã a loja quiser aceitar Pix, é só criar a classe do Pix implementando a interface, sem precisar alterar nada no código do Checkout.
