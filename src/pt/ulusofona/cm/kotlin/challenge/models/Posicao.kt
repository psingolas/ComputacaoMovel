package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

open class Posicao(var x: Int, var y: Int) {

    fun changePosition(novoPosX: Int, novoPosY: Int) {

        if (this.x == novoPosX && this.y == novoPosY) {
            throw AlterarPosicaoException("Esta posição já se encontra ocupada")
        } else {
            this.x = novoPosX
            this.y = novoPosY
        }
    }

    override fun toString(): String {

        return "Posicao | x:${this.x} | y:${this.y}"
    }

}