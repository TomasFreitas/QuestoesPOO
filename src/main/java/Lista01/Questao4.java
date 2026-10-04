package Lista01;

import java.util.Scanner;

/*
 * Questão 4
 * Uma aplicação interessante dos computadores é exibir diagramas e gráficos de barras.
 * Escreva um aplicativo que leia cinco números entre 1 e 30. Para cada número que é
 * lido, seu programa deve exibir o mesmo número de asteriscos adjacentes. Por exemplo,
 * se seu programa lê o número 7, ele deve exibir *******. Exiba as barras dos
 * asteriscos depois de ler os cinco números.
 */
public class Questao4 {

    private static final int QUANTIDADE = 5;
    private static final int MINIMO = 1;
    private static final int MAXIMO = 30;

    public static void resolver(Scanner in) {
        int[] valores = new int[QUANTIDADE];

        System.out.printf("Informe %d números entre %d e %d.%n", QUANTIDADE, MINIMO, MAXIMO);
        for (int i = 0; i < QUANTIDADE; i++) {
            valores[i] = lerNoIntervalo(in, i + 1);
        }

        System.out.println();
        System.out.println("Gráfico de barras:");
        exibirGrafico(valores);
    }

    /** Repete a leitura até o usuário informar um valor dentro do intervalo permitido. */
    private static int lerNoIntervalo(Scanner in, int posicao) {
        while (true) {
            System.out.printf("%do número: ", posicao);
            int valor = in.nextInt();
            in.nextLine();

            if (valor >= MINIMO && valor <= MAXIMO) {
                return valor;
            }
            System.out.printf("Valor fora do intervalo [%d, %d]. Tente novamente.%n", MINIMO, MAXIMO);
        }
    }

    public static void exibirGrafico(int[] valores) {
        for (int valor : valores) {
            System.out.printf("%2d | %s%n", valor, "*".repeat(valor));
        }
    }
}
