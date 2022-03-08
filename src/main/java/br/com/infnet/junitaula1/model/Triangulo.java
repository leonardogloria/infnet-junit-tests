package br.com.infnet.junitaula1.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Triangulo {
    private Long ladoA;
    private Long ladoB;
    private Long ladoC;

}
