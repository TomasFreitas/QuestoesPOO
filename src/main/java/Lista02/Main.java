package Lista02;

import java.util.Scanner;
import util.Entrada;

/** Menu da Lista 02: exercita ContaCorrente e Produto. */
public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            ContaCorrente conta = criarConta(in);
            Produto produto = new Produto(1, "Teclado mecânico", 349.90, 12);

            boolean executando = true;

            while (executando) {
                exibirMenu();
                int opcao = Entrada.lerInteiro(in, "Opção: ");

                switch (opcao) {
                    case 1 -> sacar(in, conta);
                    case 2 -> depositar(in, conta);
                    case 3 -> System.out.println(conta);
                    case 4 -> produto.exibirInfo();
                    case 5 -> alterarPreco(in, produto);
                    case 6 -> vender(in, produto);
                    case 0 -> {
                        System.out.println("Encerrando...");
                        executando = false;
                    }
                    default -> System.out.println("Opção inválida!");
                }

                System.out.println();
            }
        }
    }

    private static ContaCorrente criarConta(Scanner in) {
        int numero = Entrada.lerInteiro(in, "Número da nova conta: ");
        String titular = Entrada.lerTexto(in, "Nome do titular: ");

        ContaCorrente conta = new ContaCorrente(numero, titular);
        System.out.println("Conta criada: " + conta);
        System.out.println();

        return conta;
    }

    private static void exibirMenu() {
        System.out.println("=== Lista 02 ===");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - Consultar saldo");
        System.out.println("4 - Exibir produto");
        System.out.println("5 - Alterar preço do produto");
        System.out.println("6 - Vender produto");
        System.out.println("0 - Sair");
    }

    private static void sacar(Scanner in, ContaCorrente conta) {
        double valor = Entrada.lerDecimal(in, "Valor do saque: R$ ");

        if (conta.sacar(valor)) {
            System.out.printf("Saque realizado. Novo saldo: R$ %.2f%n", conta.consultarSaldo());
        }
    }

    private static void depositar(Scanner in, ContaCorrente conta) {
        double valor = Entrada.lerDecimal(in, "Valor do depósito: R$ ");

        if (conta.depositar(valor)) {
            System.out.printf("Depósito realizado. Novo saldo: R$ %.2f%n", conta.consultarSaldo());
        }
    }

    private static void alterarPreco(Scanner in, Produto produto) {
        double preco = Entrada.lerDecimal(in, "Novo preço: R$ ");

        produto.setPreco(preco);
        produto.exibirInfo();
    }

    private static void vender(Scanner in, Produto produto) {
        int quantidade = Entrada.lerInteiro(in, "Quantidade a vender: ");

        if (produto.vender(quantidade)) {
            System.out.printf("Venda registrada. Estoque atual: %d%n", produto.getEstoque());
        }
    }
}
