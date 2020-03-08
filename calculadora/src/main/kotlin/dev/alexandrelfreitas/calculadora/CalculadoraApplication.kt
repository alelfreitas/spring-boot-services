package dev.alexandrelfreitas.calculadora

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class CalculadoraApplication

fun main(args: Array<String>) {
	runApplication<CalculadoraApplication>(*args)
}
