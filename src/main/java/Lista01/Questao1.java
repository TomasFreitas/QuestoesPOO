package Lista01;

import java.util.Scanner;
import util.Entrada;

/*
 * Questão 1
 * Escreva um programa que leia o nome de um aluno e suas três notas, sendo a terceira
 * nota com peso 2. Calcule e exiba a média ponderada, com duas casas decimais.
 * Depois, exiba se o aluno está "Aprovado" (média >= 7) ou "Reprovado".
 */
public class Questao1 {

    private static final double[] PESOS = {1.0, 1.0, 2.0};
    private static final double MEDIA_APROVACAO = 7.0;

    public static void resolver(Scanner in) {
        String nome = Entrada.lerTexto(in, "Nome do aluno: ");

        double[] notas = new double[PESOS.length];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = Entrada.lerDecimal(in, String.format("Nota %d (peso %.0f): ", i + 1, PESOS[i]));
        }

        double media = mediaPonderada(notas, PESOS);
        String situacao = media >= MEDIA_APROVACAO ? "Aprovado" : "Reprovado";

        System.out.printf("%s - média %.2f - %s%n", nome, media, situacao);
    }

    /** Média ponderada de um vetor de valores por um vetor de pesos de mesmo tamanho. */
    public static double mediaPonderada(double[] valores, double[] pesos) {
        if (valores.length != pesos.length) {
            throw new IllegalArgumentException("Valores e pesos devem ter o mesmo tamanho.");
        }

        double somaProdutos = 0.0;
        double somaPesos = 0.0;

        for (int i = 0; i < valores.length; i++) {
            somaProdutos += valores[i] * pesos[i];
            somaPesos += pesos[i];
        }

        return somaProdutos / somaPesos;
    }
}
