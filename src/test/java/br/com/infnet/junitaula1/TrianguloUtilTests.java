package br.com.infnet.junitaula1;

import br.com.infnet.junitaula1.model.Triangulo;
import br.com.infnet.junitaula1.util.TrianguloUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TrianguloUtilTests {
    @Test
    @DisplayName("Deve retornar que é um triangulo válido")
    void isTriangulo(){
        TrianguloUtil trianguloUtil = new TrianguloUtil();
        Triangulo triangulo = Triangulo.builder().ladoA(10L).ladoB(10L).ladoC(10L).build();
        boolean isTriangulo = trianguloUtil.isTriangulo(triangulo);
        assertTrue(isTriangulo);

    }
    @Test
    @DisplayName("Deve retornar que não é um triangulo válido.")
    void isNotTriangulo(){
        TrianguloUtil trianguloUtil = new TrianguloUtil();
        Triangulo triangulo = Triangulo.builder().ladoA(1L).ladoB(1L).ladoC(90L).build();
        boolean isNotTriangulo = trianguloUtil.isTriangulo(triangulo);
        assertFalse(isNotTriangulo);
    }
    @Test
    @DisplayName("Deve retornar uma exception caso um dos lados seja zero.")
    void testaZero(){
        TrianguloUtil trianguloUtil = new TrianguloUtil();
        assertThrows(IllegalArgumentException.class, () -> {
            trianguloUtil.isTriangulo(Triangulo.builder().ladoA(0L).ladoB(10L).ladoC(10L).build());
        });
        assertThrows(IllegalArgumentException.class, () -> {
            trianguloUtil.isTriangulo(Triangulo.builder().ladoA(1L).ladoB(0L).ladoC(1L).build());
        });
        assertThrows(IllegalArgumentException.class, () -> {
            trianguloUtil.isTriangulo(Triangulo.builder().ladoA(1L).ladoB(10L).ladoC(0L).build());
        });
    }
    @ParameterizedTest
    @MethodSource("triangulos")
    @DisplayName("Deve retornar uma exception caso um dos lados seja negativo.")
    void testaNegativo(Triangulo triangulo){
        TrianguloUtil trianguloUtil = new TrianguloUtil();
        assertThrows(IllegalArgumentException.class, () -> {
            trianguloUtil.isTriangulo(triangulo);
        });
    }
    public static Stream<Arguments> triangulos(){
        return Stream.of(
                Arguments.of(Triangulo.builder().ladoA(1L).ladoB(-1L).ladoC(1L).build()),
                Arguments.of(Triangulo.builder().ladoA(-1L).ladoB(1L).ladoC(1L).build()),
                Arguments.of(Triangulo.builder().ladoA(1L).ladoB(1L).ladoC(-1L).build())

        );
    }

}
