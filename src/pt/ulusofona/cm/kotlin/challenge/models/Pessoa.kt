package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.collections.ArrayList


class Pessoa(var nome: String, var dataDeNascimento: Date, var carta: Carta? = null, var posicao: Posicao = Posicao(0, 0), var veiculos:MutableList<Veiculo> = mutableListOf()) : Movimentavel {
    //var veiculos: ArrayList<Veiculo> = ArrayList()
    //var veiculos2: MutableList<Veiculo> = ArrayList<Veiculo>().clone() as MutableList<Veiculo>

    override fun moverPara(x: Int, y: Int) {
        posicao.changePosition(x, y)
    }
    fun temCarta(): Boolean {
        return carta != null
    }

    fun comprarVeiculo(carro: Veiculo) {
        veiculos.add(carro)
    }
    @Throws(VeiculoNaoEncontradoException::class)
    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (cars in veiculos) {
            if (cars.identificador == identificador) {
                return cars
            }
        }
        throw VeiculoNaoEncontradoException("O respetico veículo não existe")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        for (cars in veiculos) {
            if (cars.identificador == identificador) {
                comprador.comprarVeiculo(cars)
                veiculos.remove(cars)

                break
            }

        }

    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        for (cars in veiculos) {
            if (cars.identificador == identificador) {
                if (cars.requerCarta() && !temCarta()) {
                    throw PessoaSemCartaException("${this.nome} não tem carta para conduzir o veículo indicado")
                }
                cars.moverPara(x, y)

            }
        }
    }



    fun tirarCarta() {//

        // Ver email do stor sobre comparar datas
        //https://www.geeksforgeeks.org/localdate-parse-method-in-java-with-examples/


        /*val now = LocalDateTime.now()
        val tenSecondsLater = now.plusSeconds(10)
        val idade= ChronoUnit.YEARS.between(now, tenSecondsLater);*/

        //https://www.javabrahman.com/java-8/java-8-how-to-calculate-difference-between-two-java-time-localdate-instances/
        val now = LocalDateTime.now()
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val dataForm = SimpleDateFormat("dd-MM-yyyy")
        val dataNascimento = dataForm.format(dataDeNascimento)
        val localDate = LocalDate.parse(dataNascimento, dateTimeFormatter)
        val idade = ChronoUnit.YEARS.between(localDate, now)


        if (idade < 18) {
            throw MenorDeIdadeException("Idade Inferior")
        } else {
            carta = Carta()
        }
    }

    override fun toString(): String {
        val dataForm = SimpleDateFormat("dd-MM-yyyy")
        val dataNascimento = dataForm.format(dataDeNascimento)
        return "Pessoa | $nome | $dataNascimento | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }

}
