package Desktop.Controllers;

import DTO.RegistrarUsuarioDTO;
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
}
