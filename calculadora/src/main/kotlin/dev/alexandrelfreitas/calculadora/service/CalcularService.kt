package dev.alexandrelfreitas.calculadora.service

import dev.alexandrelfreitas.calculadora.message.MessageConsumer
import dev.alexandrelfreitas.calculadora.model.ContaDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class CalcularService {

    private val logger: Logger = LoggerFactory.getLogger(MessageConsumer::class.java.getSimpleName())

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
    fun multiplicarNumeros(numeros: String): BigDecimal {
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

    /**
     * conta conforme mensagem recebida
     */
    fun calcular(conta: ContaDto): BigDecimal = when (conta.tipoCalculo) {
            "soma" -> somarNumeros(conta.valores)
            "subtrai" -> subtrairNumeros(conta.valores)
            "multiplica" -> multiplicarNumeros(conta.valores)
            "divide" -> dividirNumeros(conta.valores)
            else -> BigDecimal.ZERO
    }
}