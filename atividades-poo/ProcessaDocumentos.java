import java.util.ArrayList;
import java.util.List;

interface Imprimivel {
    void imprimir();
}

interface EnviavelPorEmail {
    void enviar(String email);
}

class RelatorioFinanceiro implements Imprimivel, EnviavelPorEmail {
    public void imprimir() {
        System.out.println("Imprimindo relatorio financeiro...");
    }
    public void enviar(String email) {
        System.out.println("Enviando relatorio para " + email);
    }
}

class Contrato implements Imprimivel {
    public void imprimir() {
        System.out.println("Imprimindo contrato...");
    }
}

public class ProcessaDocumentos {
    public static void main(String[] args) {
        List<Imprimivel> docs = new ArrayList<>();
        docs.add(new RelatorioFinanceiro());
        docs.add(new Contrato());

        for (Imprimivel d : docs) {
            d.imprimir();
            
            if (d instanceof EnviavelPorEmail enviavel) {
                enviavel.enviar("chefe@empresa.com");
            }
            System.out.println("---");
        }
    }
}
