package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.models.Posicao
import java.util.*

abstract class Veiculo(open var identificador:String, open var posicao: Posicao= Posicao(0,0),  var dataDeAquisicao: Date=Date()) {
    abstract fun requerCarta(): Boolean
}