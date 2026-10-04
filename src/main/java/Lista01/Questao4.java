package Lista01;

import java.util.Scanner;
import util.Entrada;

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
            valores[i] = Entrada.lerInteiro(in, String.format("%do número: ", i + 1), MINIMO, MAXIMO);
        }

        System.out.println();
        System.out.println("Gráfico de barras:");
        exibirGrafico(valores);
    }


    public static void exibirGrafico(int[] valores) {
        for (int valor : valores) {
            System.out.printf("%2d | %s%n", valor, "*".repeat(valor));
        }
    }
}
