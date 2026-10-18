package Lista04;

abstract class Pagamento {
    public abstract void processar(double valor);
}

class CartaoCredito extends Pagamento {
    @Override
    public void processar(double valor) {
        double valorComTaxa = valor + (valor * 0.05);
        System.out.println("Processando pagamento por Cartão de Crédito. Valor total com taxa: " + valorComTaxa);
    }
}

class Boleto extends Pagamento {
    @Override
    public void processar(double valor) {
        double valorComTaxaFixa = valor + 1.50;
        System.out.println("Processando pagamento por Boleto. Valor total: " + valorComTaxaFixa);
    }
}

class Pix extends Pagamento {
    @Override
    public void processar(double valor) {
        double valorComDesconto = valor - (valor * 0.10);
        System.out.println("Processando pagamento por Pix. Valor total com desconto: " + valorComDesconto);
    }
}

public class MainPagamento {
    public static void main(String[] args) {
        Pagamento[] pagamentos = { new CartaoCredito(), new Boleto(), new Pix() };
        double valorCompra = 100.0;
        System.out.println("Simulação de pagamentos para o valor base de " + valorCompra + ":");
        for (Pagamento p : pagamentos) {
            p.processar(valorCompra);
        }
    }
}
