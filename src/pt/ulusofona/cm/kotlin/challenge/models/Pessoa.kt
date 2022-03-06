package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.text.SimpleDateFormat
import java.util.*

class Pessoa(
    var nome: String,
    var dataDeNascimento: Date,
    var carta: Carta? = null,
    var posicao: Posicao = Posicao(0, 0)
) {
    lateinit var veiculos: MutableList<Veiculo>


    fun comprarVeiculo(carro:Veiculo){
        veiculos.add(carro)
    }

    fun pesquisarVeiculo(identificador: String):Veiculo{
        for (cars in veiculos){
            if (cars.identificador.equals(identificador)){
                return cars
            }
        }
        throw VeiculoNaoEncontradoException("O respetico veículo não existe")
    }










    fun tirarCarta():Boolean{
        return true
    }



//fun pesquisarVeiculo( identificador:String):Veiculo{

//}

    fun temCarta(): Boolean {
        if (carta == null) {
            return false
        } else {
            return true
        }
    }

    override fun toString(): String {

        return "Pessoa | $nome | $dataDeNascimento | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }

}
