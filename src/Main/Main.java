package Main;

import Desktop.Views.Login;
import Entities.Academia;
import Repositories.AcademiaRepository;
import Repositories.Hibernate.HibernateAcademiaRepository;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {

    public static Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) {
        //new Login().setVisible(true);        
        
        Academia a = new Academia("Java", "123", "123", 48.00, 49.00);
        new HibernateAcademiaRepository().create(a);
    }

}
