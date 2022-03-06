package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

data class Posicao(var x: Int, var y: Int) {
    //dá-me erro no DP. Dá os mesmo valores mas não passa no DP
    //Res--> Meter "data class"
    //https://play.kotlinlang.org/byExample/03_special_classes/01_Data%20classes

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