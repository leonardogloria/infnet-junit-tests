package br.com.infnet.junitaula1.repository;

import br.com.infnet.junitaula1.model.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class FuncionarioRepository {
    public List<Funcionario> getAll(){
        return Arrays.asList(
                Funcionario.builder().cpf("11111").nome("Leonardo").build(),
                Funcionario.builder().cpf("22222").nome("Alexandre").build(),
                Funcionario.builder().cpf("33333").nome("Pedro").build()

        );
    }
}
