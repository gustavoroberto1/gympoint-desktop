package Main;

import Entities.Usuario;
import Repositories.Hibernate.HibernateUsuarioRepository;
import Repositories.InMemory.InMemoryUsuarioRepository;
import Repositories.UsuarioRepository;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {

    public static Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) {
        UsuarioRepository repository = new InMemoryUsuarioRepository();
        Usuario u = repository.buscarPorEmail("gustavo@gmail.com");
        System.out.println(u.getNome());
    }

}
