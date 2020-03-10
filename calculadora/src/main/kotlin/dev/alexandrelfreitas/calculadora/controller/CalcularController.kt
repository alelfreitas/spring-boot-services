package dev.alexandrelfreitas.calculadora.controller

import dev.alexandrelfreitas.calculadora.model.ContaDto
import dev.alexandrelfreitas.calculadora.service.CalcularService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * Classe responsável por receber números para realizar calculos
 * através de REST iniciando por /v1
 */

@RestController
@RequestMapping("/v1")
class CalcularController {

    private val LOG by lazy { LoggerFactory.getLogger(CalcularController::class.java) }

    @Autowired
    private lateinit var calcularService: CalcularService

    @RequestMapping("/calcular")
    fun calcularValores(@RequestBody conta: ContaDto): ResponseEntity<Any> {
        LOG.info("conta recebida: {}", conta)
        return ResponseEntity(calcularService.calcular(conta), HttpStatus.OK)
    }

}