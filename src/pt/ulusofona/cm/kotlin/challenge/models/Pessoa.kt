package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat
import java.util.*

abstract class Pessoa (var nome:String, var veiculo: MutableList<Veiculo> = mutableListOf<Veiculo>(), var dataDeNascimento:Date, var carta: Carta?,var posicao: Posicao) {
fun temCarta(): Boolean{
    if (carta== null){
        return false
    }else{
        return true
    }
}
    override fun toString(): String {

        return "Pessoa | $nome | $dataDeNascimento | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }

}
