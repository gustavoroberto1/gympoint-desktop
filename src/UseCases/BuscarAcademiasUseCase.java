package UseCases;

import Entities.Academia;
import Repositories.AcademiaRepository;
import java.util.List;

public class BuscarAcademiasUseCase {
    private final AcademiaRepository academiaRepository;
    
    public BuscarAcademiasUseCase(AcademiaRepository academiaRepository) {
        this.academiaRepository = academiaRepository;
    }
    
    public List<Academia> executar(String termo) {
        return this.academiaRepository.buscarAcademias(termo);
    }
}
