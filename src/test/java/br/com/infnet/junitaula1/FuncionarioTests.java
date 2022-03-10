package br.com.infnet.junitaula1;

import br.com.infnet.junitaula1.model.Funcionario;
import br.com.infnet.junitaula1.repository.FuncionarioRepository;
import br.com.infnet.junitaula1.service.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class FuncionarioTests {
    @InjectMocks
    FuncionarioService funcionarioService;

    @Mock
    FuncionarioRepository funcionarioRepository;
    @BeforeEach
    void setUp(){
        List<Funcionario> funcionariosMock = Arrays.asList(
                Funcionario.builder().cpf("11111").nome("Obi-Wan").build(),
                Funcionario.builder().cpf("22222").nome("Anakin Skywalker").build(),
                Funcionario.builder().cpf("33333").nome("Luke Skywalker").build()
        );
        when(this.funcionarioRepository.getAll()).thenReturn(funcionariosMock);
    }

    @Test
    @DisplayName("Testa o metodo de servico que deve ordenar os dados que vêm do banco.")
    void testaOrdenacao(){
        List<Funcionario> ordered = funcionarioService.getOrdered();
        assertAll("funcionario",
                () -> assertEquals("Anakin Skywalker", ordered.get(0).getNome()),
                () -> assertEquals("Luke Skywalker", ordered.get(1).getNome()),
                () -> assertEquals("Obi-Wan", ordered.get(2).getNome())
                );
    }

}
