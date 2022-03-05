package pt.ulusofona.cm.kotlin.challenge.interfaces

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.models.Motor

open class Ligavel {
     lateinit var motor:Motor
     @Throws(VeiculoLigadoException::class)
     open fun ligar() {
     }
     @Throws(VeiculoDesligadoException::class)
     open fun desligar() {
     }

     @Throws(VeiculoDesligadoException::class)
     open fun estaLigado( ):Boolean {

         return motor.ligado
     }
 }