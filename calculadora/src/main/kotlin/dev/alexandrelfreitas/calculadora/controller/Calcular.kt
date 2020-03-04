package dev.alexandrelfreitas.calculadora.controller

import dev.alexandrelfreitas.calculadora.service.CalcularService
import io.micrometer.core.util.internal.logging.Slf4JLoggerFactory
import org.apache.logging.slf4j.SLF4JLogger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger
import javax.websocket.server.PathParam


/**
 * Classe responsável por receber números para realizar calculos
 * através de REST iniciando por /v1
 */

@RestController
@RequestMapping("/v1")
class Calcular {

    private val LOG by lazy { LoggerFactory.getLogger(Calcular::class.java) }

    @Autowired
    private lateinit var calcularService: CalcularService

    /**
     * Chamada /soma/1,2,3,4,5
     */
    @RequestMapping("/soma/{numeros}")
    fun somaNumeros(@PathVariable numeros: String): ResponseEntity<Any> {
        return ResponseEntity(calcularService.somarNumeros(numeros), HttpStatus.OK)
    }

    /**
     * Chamada /subtrai/1,2,3,4,5
     */
    @RequestMapping("/subtrai/{numeros}")
    fun subtraiNumeros(@PathVariable numeros: String): ResponseEntity<Any> {
        return ResponseEntity(calcularService.subtrairNumeros(numeros), HttpStatus.OK)
    }

}