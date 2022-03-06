package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat

 class Bicicleta( identificador: String):Veiculo(identificador) {
      //lateinit var pos:Veiculo

    //para haver um override é necessário que a outra class seja open
    override fun requerCarta(): Boolean {
        return false //para andar de bicicleta não é necessário carta
    }

    override fun moverPara(x: Int, y: Int) {
        //pos.posicao.changePosition(x, y)
         posicao.changePosition(x,y)//na class Veiculo tem a funcao para alterar a posicao
    }

    override fun toString(): String {
        val dataForm=SimpleDateFormat("dd-MM-yyyy")
        val dataDeAquisicao=dataForm.format(dataDeAquisicao)
        return "Bicicleta | $identificador | $dataDeAquisicao | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }
}