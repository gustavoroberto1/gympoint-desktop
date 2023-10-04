package UseCases;

import DTO.CriarAcademiaDTO;
import Entities.Academia;
import Repositories.AcademiaRepository;

public class CriarAcademiaUseCase {

    private final AcademiaRepository academiaRepository;

    public CriarAcademiaUseCase(AcademiaRepository academiaRepository) {
        this.academiaRepository = academiaRepository;
    }
    
    public Academia executar(CriarAcademiaDTO dto) {
        // RECEBER AS INFORMAÇÕES - OK
        // BUSCAR A ACADEMIA POR NOME
            // SE JÁ EXISTIR ACADEMIA COM O NOME ATUAL
                // LANÇAR EXCEPTION
            // SE NÃO EXISTIR ACADEMIA COM NOME ATUAL
                // CRIAR NOVA ACADEMIA (NEW ACADEMIA())
                // GUARDAR ACADEMIA NO BANCO DE DADOS
        
        return null;
    }
}
