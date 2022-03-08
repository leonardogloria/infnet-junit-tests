package br.com.infnet.junitaula1.util;

import br.com.infnet.junitaula1.model.Triangulo;

public class TrianguloUtil {
    public boolean isTriangulo(Triangulo triangulo){
        if(triangulo.getLadoA() <0 || triangulo.getLadoB() < 0 || triangulo.getLadoC() < 0) throw  new IllegalArgumentException();
        if(triangulo.getLadoA() == 0 || triangulo.getLadoB() == 0 || triangulo.getLadoC() == 0) throw new IllegalArgumentException("Um triangulo não pode ter lado de tamanho 0");
        Boolean condicao1 = triangulo.getLadoA() > (triangulo.getLadoB() - triangulo.getLadoC()) && triangulo.getLadoA() < triangulo.getLadoB() + triangulo.getLadoC() ? true : false;
        Boolean condicao2 = triangulo.getLadoB() > (triangulo.getLadoA() - triangulo.getLadoC()) && triangulo.getLadoB() < triangulo.getLadoA() + triangulo.getLadoC() ? true : false;
        Boolean condicao3 = triangulo.getLadoC() > (triangulo.getLadoB() - triangulo.getLadoA()) && triangulo.getLadoC() < triangulo.getLadoB() + triangulo.getLadoA() ? true : false;
        return condicao1 && condicao2 && condicao3;
    }

    public static void main(String[] args) {
        TrianguloUtil trianguloUtil = new TrianguloUtil();
        Triangulo triangulo = Triangulo.builder().ladoA(1L).ladoB(1L).ladoC(90L).build();
        boolean isTriangulo = trianguloUtil.isTriangulo(triangulo);
        if(isTriangulo == false) System.out.println("PASSOU");


    }

}
