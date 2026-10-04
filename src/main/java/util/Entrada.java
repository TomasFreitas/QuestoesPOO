package util;

import java.util.Scanner;

/**
 * Leitura de dados do teclado com validação.
 *
 * Centraliza dois problemas que apareceriam repetidos em cada questão:
 * descartar o resto da linha depois de ler um número (senão o próximo
 * nextLine() volta vazio) e repetir a pergunta quando o usuário digita
 * algo que não é número (senão o programa quebra com InputMismatchException).
 */
public final class Entrada {

    /** Classe só de métodos estáticos: não deve ser instanciada. */
    private Entrada() {
    }

    public static String lerTexto(Scanner in, String rotulo) {
        while (true) {
            System.out.print(rotulo);
            String texto = in.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Valor não pode ser vazio.");
        }
    }

    public static int lerInteiro(Scanner in, String rotulo) {
        while (true) {
            System.out.print(rotulo);

            if (in.hasNextInt()) {
                int valor = in.nextInt();
                in.nextLine();
                return valor;
            }

            System.out.printf("\"%s\" não é um número inteiro.%n", in.nextLine());
        }
    }

    /** Repete a pergunta até o valor cair no intervalo fechado [minimo, maximo]. */
    public static int lerInteiro(Scanner in, String rotulo, int minimo, int maximo) {
        while (true) {
            int valor = lerInteiro(in, rotulo);

            if (valor >= minimo && valor <= maximo) {
                return valor;
            }
            System.out.printf("Valor fora do intervalo [%d, %d]. Tente novamente.%n", minimo, maximo);
        }
    }

    public static double lerDecimal(Scanner in, String rotulo) {
        while (true) {
            System.out.print(rotulo);

            if (in.hasNextDouble()) {
                double valor = in.nextDouble();
                in.nextLine();
                return valor;
            }

            System.out.printf("\"%s\" não é um número. Use %s como separador decimal.%n",
                    in.nextLine(), separadorDecimal());
        }
    }

    /** Separador decimal do locale atual, para orientar o usuário na mensagem de erro. */
    private static String separadorDecimal() {
        char separador = new java.text.DecimalFormatSymbols().getDecimalSeparator();
        return separador == ',' ? "vírgula" : "ponto";
    }
}
