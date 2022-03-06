package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.text.SimpleDateFormat

class Bicicleta(var identificador: String) {
    lateinit var pos: Veiculo

    //para haver um override é necessário que a outra class seja open
    fun requerCarta(): Boolean {
        return false //para andar de bicicleta não é necessário carta
    }
    //@Throws(AlterarPosicaoException::class)
    fun moverPara(x: Int, y: Int) {
        pos.posicao.changePosition(x, y)
        //posicao.changePosition(x,y)//na class Veiculo tem a funcao para alterar a posicao
    }

    override fun toString(): String {
        val dataForm=SimpleDateFormat()
        val data=dataForm.format(pos.dataDeAquisicao)
        return "Bicicleta | $identificador | $data| Posicao | x:${this.pos.posicao.x} | y:${this.pos.posicao.y}"
    }

}