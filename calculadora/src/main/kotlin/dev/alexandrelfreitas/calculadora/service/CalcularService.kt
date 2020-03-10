package dev.alexandrelfreitas.calculadora.service

import dev.alexandrelfreitas.calculadora.enums.TipoCalculo
import dev.alexandrelfreitas.calculadora.message.MessageConsumer
import dev.alexandrelfreitas.calculadora.model.ContaDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class CalcularService {

    private val LOG: Logger = LoggerFactory.getLogger(MessageConsumer::class.java.getSimpleName())

    /**
     * somar todos os numeros recebidos no formato "n,n,n,n,n,..."
     */
    fun somarNumeros(numeros: String): BigDecimal {
        return numeros.valueToList()
                .reduce{acc, number -> acc + number}
    }

    /**
     * subtrair todos os numeros recebidos no formato "n,n,n,n,n,..."
     */
    fun subtrairNumeros(numeros: String): BigDecimal {
        return numeros.valueToList()
                .reduce {acc, numero -> acc - numero}
    }

    /**
     * multiplicar todos os numeros recebidos no formato "n,n,n,n,n,..."
     */
    fun multiplicarNumeros(numeros: String): BigDecimal {
        return numeros.valueToList()
                .reduce {acc, numero -> acc * numero}
    }

    /**
     * dividir todos os numeros recebidos no formato "n,n,n,n,n,..."
     */
    fun dividirNumeros(numeros: String): BigDecimal {
        return if (numeros.valueToList().contains(BigDecimal.ZERO))
            BigDecimal.ZERO
        else
            numeros.valueToList()
                    .reduce{acc, numero -> acc.divide(numero,2, RoundingMode.HALF_UP)}
    }

    /**
     * calcula conforme objeto recebido
     */
    fun calcular(conta: ContaDto): BigDecimal = when (conta.tipoCalculo) {
            TipoCalculo.SOMA.name -> somarNumeros(conta.valores)
            TipoCalculo.SUBTRACAO.name -> subtrairNumeros(conta.valores)
            TipoCalculo.MULTIPLICACAO.name -> multiplicarNumeros(conta.valores)
            TipoCalculo.DIVISAO.name -> dividirNumeros(conta.valores)
            else -> BigDecimal.ZERO
    }

    /**
     * String extension para converter string para lista de bigdecimal
     */
    fun String.valueToList() = this.split(",").map {
        if (it.matches("-?\\d+(\\.\\d+)?".toRegex())) it.toBigDecimal()
        else BigDecimal.ZERO
    }
}