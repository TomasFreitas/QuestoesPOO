package Lista02;

/**
 * Produto de um estoque.
 *
 * Código e nome são imutáveis depois da criação (identificam o produto).
 * Preço e estoque mudam, mas sempre através de métodos que validam o novo valor.
 */
public class Produto {

    private final int codigo;
    private final String nome;
    private double preco;
    private int estoque;

    public Produto(int codigo, String nome, double preco, int estoque) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código deve ser positivo.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.preco = Math.max(preco, 0);
        this.estoque = Math.max(estoque, 0);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    /** Preço negativo é rejeitado; o valor anterior é mantido. */
    public final void setPreco(double preco) {
        if (preco < 0) {
            System.out.println("Preço não pode ser negativo. Valor mantido.");
            return;
        }
        this.preco = preco;
    }

    /** Dá baixa no estoque. Retorna false se a quantidade pedida não estiver disponível. */
    public boolean vender(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade vendida deve ser maior que zero.");
            return false;
        }
        if (quantidade > estoque) {
            System.out.printf("Estoque insuficiente: disponível %d unidade(s).%n", estoque);
            return false;
        }

        estoque -= quantidade;
        return true;
    }

    /** Entrada de mercadoria no estoque. */
    public boolean repor(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade reposta deve ser maior que zero.");
            return false;
        }

        estoque += quantidade;
        return true;
    }

    /** Valor total imobilizado neste produto. */
    public double valorEmEstoque() {
        return preco * estoque;
    }

    public void exibirInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - R$ %.2f - %d em estoque (total R$ %.2f)",
                codigo, nome, preco, estoque, valorEmEstoque());
    }
}
