package pt.ulusofona.cm.kotlin.challenge.models

class Carro(var identificador: String, var motor: Motor) {


    override fun toString(): String {
        fun ligar() {
            motor.ligar()
        }
        fun desligar(){
            motor.desligar()
        }
        fun requerCarta():Boolean{
            return true
        }
        fun estaLigado(){
            motor.estaLigado()
        }
        return "Carro | $identificador | data de aquisicao | Posicao | x:0 | y:0"
    }


}