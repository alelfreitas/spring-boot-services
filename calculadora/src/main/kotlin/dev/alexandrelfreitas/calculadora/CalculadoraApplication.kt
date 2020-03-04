package dev.alexandrelfreitas.calculadora

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CalculadoraApplication

fun main(args: Array<String>) {
	runApplication<CalculadoraApplication>(*args)
}
