package pt.ulusofona.cm.kotlin.challenge.models

open class Carro(var identificador: String, var motor: Motor) {

     fun ligar() {
        motor.ligar()
    }
     fun desligar(){
        motor.desligar()
    }
     fun requerCarta():Boolean{
        return true
    }
     open fun estaLigado(){
        motor.estaLigado()
    }

    override fun toString(): String {
        return "Carro | $identificador | data de aquisicao | Posicao | x:0 | y:0"
    }


}