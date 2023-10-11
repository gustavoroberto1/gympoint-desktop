package UseCases;

import DTO.CriarAcademiaDTO;
import Entities.Academia;
import Repositories.AcademiaRepository;

public class CriarAcademiaUseCase {

    private final AcademiaRepository academiaRepository;

    public CriarAcademiaUseCase(AcademiaRepository academiaRepository) {
        this.academiaRepository = academiaRepository;
    }
    
    public Academia executar(CriarAcademiaDTO dto) throws Exception  {
        Academia jaExisteAcademia = this.academiaRepository.buscarAcademiaPorNome(dto.getNome());
        if(jaExisteAcademia != null){
            throw new Exception("JÁ EXISTE ACADEMIA COM ESTE NOME");
        }
               
        Academia academia = new Academia(dto.getNome(), dto.getTelefone(), dto.getDescricao(), dto.getLatitude(), dto.getLongitude());
        this.academiaRepository.create(academia);
        return academia;
    }
}
