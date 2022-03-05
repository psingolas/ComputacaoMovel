package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException

class Motor(var cavalos: Int, var cilindrada: Int, var ligado: Boolean = false) {
    fun carroLigado() {
        if (this.ligado == true) {
            throw VeiculoLigadoException("O veículo já se encontra ligado")
        } else {
            this.ligado = true
        }
    }
    fun carroDesligado(){
        if (this.ligado==false){
            throw VeiculoDesligadoException("O veículo já se encontra desligado")
        }else{
            this.ligado=false
        }
    }
    fun estadoDoCarro():Boolean{
        return this.ligado
    }

    override fun toString(): String {
        return "Motor | ${this.cavalos} | ${this.cilindrada}"
    }
}