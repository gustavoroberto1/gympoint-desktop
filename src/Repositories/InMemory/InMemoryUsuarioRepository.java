package Repositories.InMemory;

import Entities.Usuario;
import Repositories.UsuarioRepository;
import java.util.ArrayList;

public class InMemoryUsuarioRepository implements UsuarioRepository {

    private final ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario create(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario buscarPorEmail(String emai) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getEmail().equals(emai)) {
                return usuario;
            }
        }
        return null;
    }

}
