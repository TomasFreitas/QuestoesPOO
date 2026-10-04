package Lista02;

/**
 * Conta corrente com saldo encapsulado.
 *
 * O saldo não tem setter público: ele só muda através de sacar() e depositar(),
 * que validam a operação antes de alterar o estado do objeto.
 */
public class ContaCorrente {

    /** Valor máximo permitido em uma única operação. */
    public static final double LIMITE_POR_OPERACAO = 10_000.00;

    /** Tipos de operação aceitos pela conta. */
    private enum Operacao {
        SAQUE("saque"),
        DEPOSITO("depósito");

        private final String descricao;

        Operacao(String descricao) {
            this.descricao = descricao;
        }

        String descricao() {
            return descricao;
        }
    }

    private final int numero;
    private final String titular;
    private double saldo;

    public ContaCorrente(int numero, String titular) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número da conta deve ser positivo.");
        }
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular não pode ser vazio.");
        }

        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double consultarSaldo() {
        return getSaldo();
    }

    public boolean sacar(double valor) {
        if (!validar(valor, Operacao.SAQUE)) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean depositar(double valor) {
        if (!validar(valor, Operacao.DEPOSITO)) {
            return false;
        }
        saldo += valor;
        return true;
    }

    /**
     * Valida o valor para o tipo de operação informado e explica o motivo da recusa.
     * A comparação é feita sobre um enum, e não sobre texto: o compilador garante
     * que só existem os casos previstos.
     */
    private boolean validar(double valor, Operacao operacao) {
        if (valor <= 0) {
            System.out.printf("Valor de %s deve ser maior que zero.%n", operacao.descricao());
            return false;
        }
        if (valor > LIMITE_POR_OPERACAO) {
            System.out.printf("Valor de %s acima do limite de R$ %.2f por operação.%n",
                    operacao.descricao(), LIMITE_POR_OPERACAO);
            return false;
        }
        if (operacao == Operacao.SAQUE && valor > saldo) {
            System.out.printf("Saldo insuficiente: disponível R$ %.2f.%n", saldo);
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Conta %d - %s - saldo R$ %.2f", numero, titular, saldo);
    }
}
