package pt.ulusofona.cm.kotlin.challenge.interfaces

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException

abstract class Ligavel {
    @Throws(VeiculoLigadoException::class)
    fun ligar() {
    }

    @Throws(VeiculoDesligadoException::class)
     fun desligar() {
    }

     abstract fun estaLigado(): Boolean
}