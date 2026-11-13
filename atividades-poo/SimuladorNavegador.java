import java.util.Stack;

public class SimuladorNavegador {
    public static void main(String[] args) {
        Stack<String> historico = new Stack<>();

        System.out.println("Navegando...");
        acessarPagina(historico, "google.com");
        acessarPagina(historico, "github.com");
        acessarPagina(historico, "stackoverflow.com");

        System.out.println("\nClicando em voltar...");
        voltar(historico);
        voltar(historico);
        voltar(historico);
        voltar(historico); // Tentando voltar sem histórico
    }

    public static void acessarPagina(Stack<String> pilha, String url) {
        pilha.push(url);
        System.out.println("Página atual: " + url);
    }

    public static void voltar(Stack<String> pilha) {
        if (!pilha.isEmpty()) {
            String paginaRemovida = pilha.pop();
            System.out.println("Saindo de: " + paginaRemovida);
            if (!pilha.isEmpty()) {
                System.out.println("Página atual agora é: " + pilha.peek());
            } else {
                System.out.println("Navegador em aba vazia.");
            }
        } else {
            System.out.println("Não há histórico para voltar.");
        }
    }
}
