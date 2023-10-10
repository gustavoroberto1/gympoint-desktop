package UseCases;

import DTO.CriarAcademiaDTO;
import Entities.Academia;
import Repositories.AcademiaRepository;
import Repositories.InMemory.InMemoryAcademiaRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CriarAcademiaUseCaseTest {
    private AcademiaRepository academiaRepository;
    private CriarAcademiaUseCase criarAcademiaUseCase;
    
    @Before
    public void setUp() {
        this.academiaRepository = new InMemoryAcademiaRepository();
        this.criarAcademiaUseCase = new CriarAcademiaUseCase(academiaRepository);
    }
    
    @Test
    public void testeCriarAcademiaComDadosValidos() {
        // DADOS DE ENTRADA
        String nome = "Academia Senai";
        String telefone = "(00) 0000-0000";
        String descricao = "descricao teste";
        Double latitute = -48.000;
        Double longitude = -48.000;
        CriarAcademiaDTO dto = new CriarAcademiaDTO(nome, telefone, descricao, latitute, longitude);
        
        Academia academia = this.criarAcademiaUseCase.executar(dto);
        
        TestCase.assertEquals("Academia Senai", academia.getNome());
        TestCase.assertEquals("(00) 0000-0000", academia.getTelefone());  
    }
}
