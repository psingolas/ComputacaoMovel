package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos: Int, var cilindrada: Int, var ligado: Boolean = false):Ligavel{
       override fun ligar() {
        if (this.ligado == true) {
            throw VeiculoLigadoException("O veículo já se encontra ligado")
        } else {
            this.ligado = true
        }
    }
      override fun desligar(){
        if (!this.ligado){
            throw VeiculoDesligadoException("O veículo já se encontra desligado")
        }else{
            this.ligado=false
        }
    }
     override fun estaLigado():Boolean{
        return this.ligado
    }

    override fun toString(): String {
        return "Motor | ${cavalos} | ${cilindrada}"
    }
}