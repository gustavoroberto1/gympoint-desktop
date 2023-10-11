package Desktop.Controllers;

import DTO.CriarAcademiaDTO;
import Entities.Academia;
import UseCases.Factories.MakeBuscarAcademiasUseCase;
import UseCases.Factories.MakeCriarAcademiaUseCase;
import java.util.List;
import javax.swing.JOptionPane;

public class AcademiaController {

    public Academia CriarAcademia(CriarAcademiaDTO dto) {
        try {
            return MakeCriarAcademiaUseCase.make().executar(dto);
        } catch (Exception error) {
            System.out.println(error);
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CADASTRAR A ACADEMIA");
            return null;
        }
    }
    
    public List<Academia> BuscarAcademia(String termo){
        try {
            return MakeBuscarAcademiasUseCase.make().executar(termo);
        } catch (Exception error) {
            System.out.println(error);
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL BUSCAR ACADEMIAS");
            return null;
        }
    }
}
