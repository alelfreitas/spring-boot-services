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
     * Chamada /soma/n,n,n,n,...
     */
    @RequestMapping("/soma/{numeros}")
    fun somaNumeros(@PathVariable numeros: String): ResponseEntity<Any> {
        return ResponseEntity(calcularService.somarNumeros(numeros), HttpStatus.OK)
    }

    /**
     * Chamada /subtrai/n,n,n,n,...
     */
    @RequestMapping("/subtrai/{numeros}")
    fun subtraiNumeros(@PathVariable numeros: String): ResponseEntity<Any> {
        return ResponseEntity(calcularService.subtrairNumeros(numeros), HttpStatus.OK)
    }

    /**
     * Chamada /multiplica/n,n,n,n,...
     */
    @RequestMapping("/multiplica/{numeros}")
    fun multiplicaNumeros(@PathVariable numeros: String): ResponseEntity<Any> {
        return ResponseEntity(calcularService.mutiplicarNumeros(numeros), HttpStatus.OK)
    }

    /**
     * Chamada /divide/n,n,n,n,...
     */
    @RequestMapping("/divide/{numeros}")
    fun divideNumeros(@PathVariable numeros: String): ResponseEntity<Any> {
        return ResponseEntity(calcularService.dividirNumeros(numeros), HttpStatus.OK)
    }

}