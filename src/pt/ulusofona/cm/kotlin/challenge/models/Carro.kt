package pt.ulusofona.cm.kotlin.challenge.models

class Carro(var identificador: String, var motor: Motor) {


    override fun toString(): String {
        fun carroLigado() {
            motor.carroLigado()
        }
        fun carroDesligado(){
            motor.carroDesligado()
        }
        return "Carro | $identificador | data de aquisicao | Posicao | x:0 | y:0"
    }


}