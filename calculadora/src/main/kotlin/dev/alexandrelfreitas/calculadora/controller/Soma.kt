package dev.alexandrelfreitas.calculadora.controller

import io.micrometer.core.util.internal.logging.Slf4JLoggerFactory
import org.apache.logging.slf4j.SLF4JLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger
import javax.websocket.server.PathParam


/**
 * Classe responsável por receber números para realizar soma
 * através de REST iniciando por /v1/soma
 */

@RestController
@RequestMapping("/v1/soma")
class Soma {

//    @Autowired
//    lateinit private var logger: Logger

    /**
     * Chamada /1,2,3,4,5
     */
    @GetMapping("/{numeros}")
    fun somaNumeros(@PathVariable numeros: String): Int {
        val lista = numeros.split(",").map { it.toInt() }
        return lista.sum()
    }

}