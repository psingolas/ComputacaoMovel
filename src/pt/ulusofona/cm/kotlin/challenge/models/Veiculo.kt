package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.models.Posicao
import java.util.*

open abstract class Veiculo( val identificador:String, var posicao: Posicao= Posicao(0,0), var dataDeAquisicao: Date=Date()) {
    abstract fun requerCarta(): Boolean

     open fun moverPara(x: Int, y: Int) {
        //posicao.alterarPosicaoPara(x, y)
    }

}