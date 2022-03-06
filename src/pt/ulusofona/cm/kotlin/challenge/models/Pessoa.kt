package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.collections.ArrayList


data class Pessoa(
    var nome: String,
    var dataDeNascimento: Date,
    var carta: Carta? = null,
    var posicao: Posicao = Posicao(0, 0)
): Movimentavel {
    var veiculos: MutableList<Veiculo> = ArrayList()

    fun temCarta(): Boolean {
        return carta != null
    }

    fun comprarVeiculo(carro:Veiculo){
        carro.data()
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
            if (cars.identificador == identificador){
                comprador.comprarVeiculo(cars)
                veiculos.remove(cars)
            }
        }
    }

    fun moverVeiculoPara(identificador: String, x:Int,y:Int){
        for (cars in veiculos ){
            if (cars.identificador == identificador){
                if (cars.requerCarta() && !temCarta()){
                    throw PessoaSemCartaException("${this.nome} não tem carta para conduzir o veículo indicado")
                }
                cars.moverPara(x, y)
            }
        }
    }

    fun tirarCarta(){//Ver email do stor sobre comparar datas
        val now = LocalDateTime.now()
        val tenSecondsLater = now.plusSeconds(10)
        val idade= ChronoUnit.SECONDS.between(now, tenSecondsLater);
        if (idade<18){
            throw MenorDeIdadeException("Idade Inferior")
        }else{
            carta=Carta()
        }
    }
    override fun moverPara(x: Int, y:Int){
        posicao.changePosition(x,y)
    }


    override fun toString(): String {
        val dataForm= SimpleDateFormat("dd-MM-yyyy")
        val dataNascimento=dataForm.format(dataDeNascimento)
        return "Pessoa | $nome | $dataNascimento | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }

}
