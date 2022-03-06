package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
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
    fun moverPara(x: Int, y:Int){
        posicao.changePosition(x,y)
    }

    fun temCarta(): Boolean {
        return carta != null
    }

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
    fun venderVeiculo(identificador: String, comprador: Pessoa){
        for (cars in veiculos){
            if (cars.identificador.equals(identificador)){
                comprador.comprarVeiculo(cars)
                veiculos.remove(cars)
            }
        }
    }
    fun moverVeiculoPara(identificador: String, x:Int,y:Int){
        for (cars in veiculos){
            if (cars.identificador.equals(identificador) && !temCarta()){
                throw PessoaSemCartaException("${this.nome} não tem carta para conduzir o veículo indicado")
            }
            cars.moverPara(x, y)
        }
    }



    fun tirarCarta():Boolean{
        return true
    }



    override fun toString(): String {

        return "Pessoa | $nome | $dataDeNascimento | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }

}
