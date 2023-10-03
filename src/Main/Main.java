package Main;

import Desktop.Views.Register;
import Entities.Usuario;
import Repositories.Hibernate.HibernateUsuarioRepository;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {

    public static Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) {
        new Register().setVisible(true);        
    }

}
