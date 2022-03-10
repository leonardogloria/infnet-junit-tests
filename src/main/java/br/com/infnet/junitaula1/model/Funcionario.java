package br.com.infnet.junitaula1.model;

import lombok.Builder;
import lombok.Data;

@Builder@Data
public class Funcionario {
    private String nome;
    private String cpf;

}
