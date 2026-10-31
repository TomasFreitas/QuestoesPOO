interface AparelhoTelefonico {
    void ligar();
    void atender();
}

interface NavegadorInternet {
    void exibirPagina();
    void adicionarNovaAba();
}

interface ReprodutorMusical {
    void tocar();
    void pausar();
}

public class Smartphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    public void ligar() { System.out.println("Ligando..."); }
    public void atender() { System.out.println("Alô?"); }
    public void exibirPagina() { System.out.println("Carregando site..."); }
    public void adicionarNovaAba() { System.out.println("Nova aba aberta"); }
    public void tocar() { System.out.println("Tocando música"); }
    public void pausar() { System.out.println("Música pausada"); }

    public static void main(String[] args) {
        Smartphone cel = new Smartphone();
        cel.ligar();
        cel.adicionarNovaAba();
        cel.tocar();
    }
}
