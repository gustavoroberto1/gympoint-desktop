package UseCases.Factories;

import Repositories.Hibernate.HibernateUsuarioRepository;
import Repositories.UsuarioRepository;
import UseCases.LoginUseCase;

public class MakeLoginUseCase {
    public static LoginUseCase make() {
        UsuarioRepository usuarioRepository = new HibernateUsuarioRepository();
        return new LoginUseCase(usuarioRepository);
    }
}
