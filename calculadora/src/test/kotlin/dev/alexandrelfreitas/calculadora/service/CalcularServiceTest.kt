package dev.alexandrelfreitas.calculadora.service

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CalcularServiceTest {

    @Autowired
    private lateinit var calcularService: CalcularService

    val NUMEROS_CALCULO = "1,2,3"

    val RESULTADO_SOMA = "6".toBigDecimal()

    @Test
    fun quandoSomarNumerosCalculo_DeveResultarResultadoSoma(){
        val resultado = calcularService.somarNumeros(NUMEROS_CALCULO)
        assert(resultado == RESULTADO_SOMA)
    }

    val RESULTADO_SUBTRAIR = "-4".toBigDecimal()

    @Test
    fun quandoSubtrairNumerosCalculo_DeveResultarResultadoSubtrair(){
        val resultado = calcularService.subtrairNumeros(NUMEROS_CALCULO)
        assert(resultado == RESULTADO_SUBTRAIR)
    }

    val RESULTADO_DIVIDIR = "0.17".toBigDecimal()

    @Test
    fun quandoDividirNumerosCalculo_DeveResultarResultadoDividir(){
        val resultado = calcularService.dividirNumeros(NUMEROS_CALCULO)
        assert(resultado == RESULTADO_DIVIDIR)
    }

    val RESULTADO_MULTIPLICAR = "6".toBigDecimal()

    @Test
    fun quandoMultiplicarNumerosCalculo_DeveResultarResultadoMultiplicar(){
        val resultado = calcularService.mutiplicarNumeros(NUMEROS_CALCULO)
        assert(resultado == RESULTADO_MULTIPLICAR)
    }

}