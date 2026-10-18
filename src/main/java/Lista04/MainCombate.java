package Lista04;

abstract class Personagem {
    public abstract void atacar();
}

class Guerreiro extends Personagem {
    @Override
    public void atacar() {
        System.out.println("O Guerreiro ataca ferozmente com sua espada pesada!");
    }
}

class Mago extends Personagem {
    @Override
    public void atacar() {
        System.out.println("O Mago lança uma poderosa bola de fogo mágica!");
    }
}

class Arqueiro extends Personagem {
    @Override
    public void atacar() {
        System.out.println("O Arqueiro dispara uma flecha perfurante à distância!");
    }
}

public class MainCombate {
    public static void main(String[] args) {
        Personagem[] grupo = { new Guerreiro(), new Mago(), new Arqueiro() };
        System.out.println("=== Início do turno de combate ===");
        for (Personagem p : grupo) {
            p.atacar();
        }
    }
}
