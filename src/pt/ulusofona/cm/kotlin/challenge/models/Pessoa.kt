package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.*

class Pessoa(
    var nome: String,
    var dataDeNascimento: Date,
    var carta: Carta? = null,
    var posicao: Posicao = Posicao(0, 0)
): Movimentavel {
    lateinit var veiculos: MutableList<Veiculo>


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
                if (cars.requerCarta() && !temCarta()){
                    throw PessoaSemCartaException("${this.nome} não tem carta para conduzir o veículo indicado")
                }
                cars.moverPara(x, y)
            }
        }
    }



    fun tirarCarta(){
        val idade=0
        if (idade<18){
            throw MenorDeIdadeException("Idade inferior")
        }else{
            carta=Carta()
        }
    }
    override fun moverPara(x: Int, y:Int){
        posicao.changePosition(x,y)
    }


    override fun toString(): String {

        return "Pessoa | $nome | $dataDeNascimento | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }

}
