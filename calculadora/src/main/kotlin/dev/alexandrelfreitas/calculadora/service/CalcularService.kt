package dev.alexandrelfreitas.calculadora.service

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class CalcularService {

    /**
     * somar todos os numeros recebidos no formato "n,n,n,n,n,..."
     */
    fun somarNumeros(numeros: String): BigDecimal {
        return numeros.split(",").map { it.toBigDecimal() }
                .reduce{acc, number -> acc + number}
    }

    /**
     * subtrair todos os numeros recebidos no formato "n,n,n,n,n,..."
     */
    fun subtrairNumeros(numeros: String): BigDecimal {
        return numeros.split(",").map { it.toBigDecimal() }
                .reduce {acc, numero -> acc - numero}
    }

    /**
     * multiplicar todos os numeros recebidos no formato "n,n,n,n,n,..."
     */
    fun mutiplicarNumeros(numeros: String): BigDecimal {
        return numeros.split(",").map { it.toBigDecimal() }
                .reduce {acc, numero -> acc * numero}
    }

    /**
     * dividir todos os numeros recebidos no formato "n,n,n,n,n,..."
     */
    fun dividirNumeros(numeros: String): BigDecimal {
        return numeros.split(",").map { it.toBigDecimal() }
                .reduce{acc, numero -> acc.divide(numero,2, RoundingMode.HALF_UP)}
    }
}