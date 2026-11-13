import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Usuario {
    String email;
    String nome;
    String senha;

    public Usuario(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    // O equals e hashCode pelo email garantem que o Set não aceite emails repetidos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Email: " + email;
    }
}

public class GerenciadorUsuarios {
    public static void main(String[] args) {
        Set<Usuario> usuarios = new HashSet<>();

        Usuario u1 = new Usuario("tomas@email.com", "Tomas Freitas", "12345");
        Usuario u2 = new Usuario("joao@email.com", "Joao Silva", "senha123");
        Usuario u3 = new Usuario("tomas@email.com", "Tomas Clonado", "9999"); // Email repetido

        usuarios.add(u1);
        usuarios.add(u2);
        
        if (!usuarios.add(u3)) {
            System.out.println("Erro: Já existe um usuário com o email " + u3.email);
        }

        System.out.println("\nLista de usuários cadastrados:");
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
}
