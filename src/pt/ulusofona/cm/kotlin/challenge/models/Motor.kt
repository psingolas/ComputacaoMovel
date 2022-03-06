package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos: Int, var cilindrada: Int, var ligado: Boolean = false){
       fun ligar() {
        if (this.ligado == true) {
            throw VeiculoLigadoException("!!!")
        } else {
            this.ligado = true
        }
    }
      fun desligar(){
        if (this.ligado==false){
            throw VeiculoDesligadoException("!!!")
        }else{
            this.ligado=false
        }
    }
     fun estaLigado():Boolean{
        return this.ligado
    }

    override fun toString(): String {
        return "Motor | ${this.cavalos} | ${this.cilindrada}"
    }
}