package pt.ulusofona.cm.kotlin.challenge.models

class Carro (var identificador:String,var motor: Motor) {


    override fun toString(): String {

        return "Carro | $identificador | data de aquisicao | Posicao | x:0 | y:0"
    }


}