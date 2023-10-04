package Desktop.Controllers;

import DTO.LoginDTO;
import DTO.RegistrarUsuarioDTO;
import Entities.Usuario;
import UseCases.Errors.UsuarioJaExiste;
import UseCases.Factories.MakeLoginUseCase;
import static UseCases.Factories.MakeRegistrarUsuarioUseCase.make;
import javax.swing.JOptionPane;

public class UsuarioController {
    public void CriarUsuario(RegistrarUsuarioDTO usuario) {
        try {
            make().executar(usuario);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não conseguimos cadastrar o usuário");
        }
    }
    
    public Usuario AutenticarUsuario(LoginDTO dto){
        try{
            return MakeLoginUseCase.make().executar(dto);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "NÃO FOI POSSÍVEL AUTENTICAR");
            return null;
        }
    }
}
