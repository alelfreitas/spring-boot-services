package dev.alexandrelfreitas.srvdiscovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class SrvDiscoveryApplication

fun main(args: Array<String>) {
	runApplication<SrvDiscoveryApplication>(*args)
}
