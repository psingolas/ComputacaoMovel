package pt.ulusofona.cm.kotlin.challenge.models
import java.util.*

abstract class Veiculo(open var identificador:String, var posicao: Posicao= Posicao(0,0), var dataDeAquisicao: Date=Date()) {
    abstract fun requerCarta(): Boolean
    fun data(){
        this.dataDeAquisicao=Date()
    }
     open fun moverPara(x: Int, y: Int) {
    }
}