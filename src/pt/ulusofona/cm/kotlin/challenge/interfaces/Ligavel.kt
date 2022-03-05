package pt.ulusofona.cm.kotlin.challenge.interfaces

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException

open class Ligavel {
    @Throws(VeiculoLigadoException::class)
    open fun ligar() {
    }

    @Throws(VeiculoDesligadoException::class)
    open fun desligar() {
    }

    open fun estaLigado(): Boolean {
        return false
    }
}