package Lista01;

import java.util.Scanner;
import util.Entrada;

/*
 * Questão 2
 * Peça um número ao usuário. Verifique e imprima:
 *   "Múltiplo de 3", se for múltiplo de 3;
 *   "Múltiplo de 5", se for múltiplo de 5;
 *   "Múltiplo de ambos", se for múltiplo de 3 e 5;
 *   "Não é múltiplo de 3 nem de 5", caso contrário.
 */
public class Questao2 {

    public static void resolver(Scanner in) {
        int numero = Entrada.lerInteiro(in, "Informe um número inteiro: ");
        System.out.println(classificar(numero));
    }

    /** Retorna a classificação do número quanto à divisibilidade por 3 e por 5. */
    public static String classificar(int numero) {
        boolean divPor3 = ehMultiplo(numero, 3);
        boolean divPor5 = ehMultiplo(numero, 5);

        if (divPor3 && divPor5) {
            return "Múltiplo de ambos";
        }
        if (divPor3) {
            return "Múltiplo de 3";
        }
        if (divPor5) {
            return "Múltiplo de 5";
        }
        return "Não é múltiplo de 3 nem de 5";
    }

    public static boolean ehMultiplo(int numero, int divisor) {
        return numero % divisor == 0;
    }
}
