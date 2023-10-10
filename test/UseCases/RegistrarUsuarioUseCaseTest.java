package UseCases;

import DTO.RegistrarUsuarioDTO;
import Entities.Usuario;
import Enums.Funcao;
import Repositories.InMemory.InMemoryUsuarioRepository;
import Repositories.UsuarioRepository;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrarUsuarioUseCaseTest {

    private UsuarioRepository usuarioRepository;
    private RegistrarUsuarioUseCase registrarUseCase;

    @Before
    public void setUp() {
        this.usuarioRepository = new InMemoryUsuarioRepository();
        this.registrarUseCase = new RegistrarUsuarioUseCase(this.usuarioRepository);
    }

    @Test
    public void testeRegistarUmNovoUsuario() throws Exception {
        // DADOS DE ENTRADA
        String nome = "gustavo";
        String email = "gustavo@exemple.com";
        String senha = "123";
        Funcao funcao = Funcao.ADMINISTRADOR;
        RegistrarUsuarioDTO dto = new RegistrarUsuarioDTO(nome, email, senha, funcao);

        // CHAMANDO A FUNÇÃO E PASSANDO DADOS DE ENTRADA
        Usuario u = this.registrarUseCase.executar(dto);

        //COMPARO RESULTADO COM VALORES ESPERADOS
        TestCase.assertEquals("gustavo", u.getNome());
        TestCase.assertEquals("gustavo@exemple.com", u.getEmail());
        TestCase.assertEquals(Funcao.ADMINISTRADOR, u.getFuncao_usuario());
    }

    @Test
    public void TesteRegistraUsuarioComEmailJaExistente() {
        String nome = "gustavo";
        String email = "gustavo@exemple.com";
        String senha = "123";
        Funcao funcao = Funcao.ADMINISTRADOR;
        RegistrarUsuarioDTO dto = new RegistrarUsuarioDTO(nome, email, senha, funcao);

        Usuario u = new Usuario(nome, email, senha, funcao);
        this.usuarioRepository.create(u);
        try {
            this.registrarUseCase.executar(dto);
        } catch (Exception error) {
            TestCase.assertEquals("Usuario já existe", error.getMessage());
        }
    }

}
