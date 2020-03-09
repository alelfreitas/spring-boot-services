package dev.alexandrelfreitas.calculadora.message

import dev.alexandrelfreitas.calculadora.model.ContaDto
import dev.alexandrelfreitas.calculadora.service.CalcularService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink

@EnableBinding(Sink::class)
class MessageConsumer {

    private val logger: Logger = LoggerFactory.getLogger(MessageConsumer::class.java.getSimpleName())

    @Autowired
    private lateinit var calcularService: CalcularService

    @StreamListener(Sink.INPUT)
    fun readMessage(conta: ContaDto) {
        logger.info("Resultado: {}", calcularService.calcular(conta))
    }
}