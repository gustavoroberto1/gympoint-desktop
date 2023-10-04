package UseCases;

import DTO.LoginDTO;
import Entities.Usuario;
import Repositories.UsuarioRepository;
import org.mindrot.jbcrypt.BCrypt;

public class LoginUseCase {
    private final UsuarioRepository usuarioRepository;
    
    public LoginUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    public Usuario executar(LoginDTO loginDto) throws Exception {
        Usuario u = this.usuarioRepository.buscarPorEmail(loginDto.getEmail());
        if(u == null){
            throw new Exception("USUÁRIO NÃO CADASTRO");
        }
        
        boolean ehValido = BCrypt.checkpw(loginDto.getSenha(), u.getSenha_hash());
        if(!ehValido){
            throw new Exception("SENHA ERRADA MALUCO");
        }
        
        return u;
    }
}
