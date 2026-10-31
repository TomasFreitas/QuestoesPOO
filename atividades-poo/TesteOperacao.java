@FunctionalInterface
interface OperacaoMatematica {
    double executar(double a, double b);
}

public class TesteOperacao {
    public static void main(String[] args) {
        OperacaoMatematica soma = (a, b) -> a + b;
        OperacaoMatematica sub = (a, b) -> a - b;
        OperacaoMatematica mult = (a, b) -> a * b;
        OperacaoMatematica div = (a, b) -> a / b;

        System.out.println("Soma: " + soma.executar(10, 5));
        System.out.println("Sub: " + sub.executar(10, 5));
        System.out.println("Mult: " + mult.executar(10, 5));
        System.out.println("Div: " + div.executar(10, 5));
    }
}
