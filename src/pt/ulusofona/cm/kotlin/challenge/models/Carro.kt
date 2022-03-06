package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(override var identificador: String, var motor: Motor):Veiculo(identificador) {

    fun ligar() {
        motor.ligar()
    }
      fun desligar(){
        motor.desligar()
    }
     override fun requerCarta():Boolean{
        return true
    }
      fun estaLigado(){
        motor.estaLigado()
    }

    override fun toString(): String {
        return "Carro | $identificador | $dataDeAquisicao | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }


}