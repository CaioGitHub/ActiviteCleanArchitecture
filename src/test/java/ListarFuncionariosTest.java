import application.funcionario.ListarFuncionarios;
import entities.funcionario.Funcionario;
import entities.funcionario.dto.FuncionarioDTO;
import infrastucture.FuncionarioRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ListarFuncionariosTest {

    @Test
    void deveRetornarListaDeFuncionarios() {
        FuncionarioRepository repository = new FuncionarioRepository();
        repository.salvar(new Funcionario("Maria", "Gerente", 5000.0));

        ListarFuncionarios listar = new ListarFuncionarios(repository);
        List<FuncionarioDTO> funcionarios = listar.executar();

        assertEquals(1, funcionarios.size());
        assertEquals("Maria", funcionarios.get(0).nome());
        assertEquals("Gerente", funcionarios.get(0).cargo());
    }
}
