import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExerciciosStream {
    public static void main(String[] args) {
        // 1. Remover menores que 0
        List<Integer> numeros = new ArrayList<>(Arrays.asList(10, -5, 3, -1, 0, 8, -9));
        numeros.removeIf(n -> n < 0);
        System.out.println("Números filtrados: " + numeros);

        // 2. Exibir strings que iniciam com P
        List<String> palavras = Arrays.asList("Pato", "Gato", "Porta", "Cachorro", "Ponte");
        System.out.print("Palavras com P: ");
        palavras.stream()
                .filter(p -> p.toUpperCase().startsWith("P"))
                .forEach(p -> System.out.print(p + " "));
        System.out.println();

        // 3. Palavras únicas em um parágrafo
        String paragrafo = "java e bom mas java as vezes e dificil mas eu gosto de java";
        Set<String> palavrasUnicas = Arrays.stream(paragrafo.split(" "))
                .collect(Collectors.toSet());
        
        System.out.println("Palavras únicas no texto: " + palavrasUnicas);
    }
}
