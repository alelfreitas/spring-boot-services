package dev.alexandrelfreitas.calculadora.service

import org.springframework.stereotype.Service

@Service
class CalcularService {

    fun somarNumeros(numeros: String): Int {
        val lista = numeros.split(",").map { it.toInt() }
        return lista.sum()
    }

    fun subtrairNumeros(numeros: String): Int {
        val lista = numeros.split(",").map { it.toInt() }
        var resultado = 0
        for((i, n) in lista.withIndex()){
            if(i == 0) resultado = n
            else resultado -= n
        }
        return resultado
    }
}