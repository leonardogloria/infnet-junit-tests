package br.com.infnet.junitaula1.service;

import br.com.infnet.junitaula1.model.Funcionario;
import br.com.infnet.junitaula1.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.Comparator.*;
import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;
    public List<Funcionario> getOrdered(){
        List<Funcionario> all = funcionarioRepository.getAll();
        all.sort(comparing(Funcionario::getNome));
        return all;
    }
}
