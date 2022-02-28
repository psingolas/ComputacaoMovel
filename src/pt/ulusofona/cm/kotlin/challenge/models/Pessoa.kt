package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

abstract class Pessoa (var nome:String, var veiculo: MutableList<Veiculo> = mutableListOf<Veiculo>(), var dataDeNascimento:Date, var posicao: Posicao) {



}
