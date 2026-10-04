package Lista01;

import java.util.Scanner;

/**
 * Menu da Lista 01.
 *
 * Um único Scanner é criado aqui e repassado às questões: abrir vários Scanner
 * sobre System.in faz com que um consuma o buffer do outro.
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            boolean executando = true;

            while (executando) {
                exibirMenu();

                if (!in.hasNextInt()) {
                    System.out.println("Informe um número inteiro.");
                    in.nextLine();
                    continue;
                }

                int opcao = in.nextInt();
                in.nextLine();
                System.out.println();

                switch (opcao) {
                    case 1 -> Questao1.resolver(in);
                    case 2 -> Questao2.resolver(in);
                    case 3 -> Questao3.resolver(in);
                    case 4 -> Questao4.resolver(in);
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

    private static void exibirMenu() {
        System.out.println("=== Lista 01 ===");
        System.out.println("1 - Média ponderada de notas");
        System.out.println("2 - Múltiplos de 3 e de 5");
        System.out.println("3 - Números primos até N");
        System.out.println("4 - Gráfico de barras com asteriscos");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }
}
