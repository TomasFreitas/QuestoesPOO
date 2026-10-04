package Lista01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Questão 3
 * Peça ao usuário um número inteiro positivo N. Em seguida, imprima todos os
 * números primos entre 2 e N.
 */
public class Questao3 {

    public static void resolver(Scanner in) {
        System.out.print("Informe N (inteiro positivo): ");
        int n = in.nextInt();
        in.nextLine();

        if (n < 2) {
            System.out.println("Não existem primos menores que 2.");
            return;
        }

        List<Integer> primos = primosAte(n);
        System.out.printf("Primos entre 2 e %d (%d encontrados):%n", n, primos.size());

        for (int i = 0; i < primos.size(); i++) {
            System.out.print(primos.get(i));
            System.out.print((i + 1) % 10 == 0 ? System.lineSeparator() : "\t");
        }
        System.out.println();
    }

    /**
     * Crivo de Eratóstenes: marca os múltiplos de cada primo encontrado, em vez de
     * testar a divisibilidade de cada número separadamente.
     */
    public static List<Integer> primosAte(int n) {
        boolean[] composto = new boolean[n + 1];

        for (int base = 2; (long) base * base <= n; base++) {
            if (composto[base]) {
                continue;
            }
            for (int multiplo = base * base; multiplo <= n; multiplo += base) {
                composto[multiplo] = true;
            }
        }

        List<Integer> primos = new ArrayList<>();
        for (int numero = 2; numero <= n; numero++) {
            if (!composto[numero]) {
                primos.add(numero);
            }
        }
        return primos;
    }
}
