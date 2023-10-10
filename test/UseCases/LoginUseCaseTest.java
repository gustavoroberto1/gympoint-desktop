package UseCases;

import DTO.LoginDTO;
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

public class LoginUseCaseTest {
    private UsuarioRepository usuarioRepository;
    private LoginUseCase loginUseCase;
    
    @Before
    public void setUp() {
        this.usuarioRepository = new InMemoryUsuarioRepository();
        this.loginUseCase = new LoginUseCase(this.usuarioRepository);
        
    }
       
    @Test
    public void testeLoginComCredenciaisValidas() throws Exception {
        // DADOS DE ENTRADA
        String email = "gustavo@exemplo.com";
        String senha = "123";
        String nome = "gustavo";
        Funcao f = Funcao.ADMINISTRADOR;
        
        // DEPENCIA QUE O TESTE TEM
        Usuario usuario = new Usuario(nome, email, senha, f);
        this.usuarioRepository.create(usuario);
        
        //CHAMANDO FUNÇÃO COM DADOS DE ENTRADA
        LoginDTO dto = new LoginDTO(email, senha);
        Usuario u = this.loginUseCase.executar(dto);
        
        // COMPARANDO A SAÍDA COM OS VALORES ESPERADOS
        TestCase.assertEquals("gustavo@exemplo.com", u.getEmail());
        TestCase.assertEquals("gustavo", u.getNome());
        TestCase.assertEquals(Funcao.ADMINISTRADOR, u.getFuncao_usuario()); 
    }
    
    @Test
    public void testeLoginComUsuarioInexistente(){
        // DADOS DE ENTRADA
        String email = "gustavo@exemplo.com";
        String senha = "123";        
        LoginDTO dto = new LoginDTO(email, senha);
        
        try {
            //CHAMANDO FUNÇÃO COM DADOS DE ENTRADA       
            Usuario u = this.loginUseCase.executar(dto);
        }catch(Exception e){
            TestCase.assertEquals("USUÁRIO NÃO CADASTRADO", e.getMessage());
        }        
    }
    
    @Test
    public void testeLoginComSenhaIncorreta() {
        String email = "gustavo@exemplo.com";
        String senha = "123";
        
        Usuario usuario = new Usuario("gustavo", email, senha, Funcao.ADMINISTRADOR);
        this.usuarioRepository.create(usuario);
        
        try {
            LoginDTO dto = new LoginDTO(email, "1234");
            Usuario u = this.loginUseCase.executar(dto);
        } catch (Exception e){
            TestCase.assertEquals("SENHA ERRADA MALUCO", e.getMessage());
        }
        
        
    }
}
