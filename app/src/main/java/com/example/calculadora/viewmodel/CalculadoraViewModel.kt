package com.example.calculadora.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadora.repository.OperacionRepository
import kotlinx.coroutines.launch

class CalculadoraViewModel(private val repository: OperacionRepository) : ViewModel() {
    var valor by mutableStateOf("")
    private set

    var primerNumero by mutableStateOf("")
        private set

    var operador by mutableStateOf("")
        private set

    fun numero(numero:String){
        valor += numero
    }

    fun operacion(op:String) {
        if (valor.isNotEmpty()) {
            primerNumero = valor
            operador = op
            valor = ""
        }
    }

    fun igual(){
        if (
            primerNumero.isNotEmpty() &&
            valor.isNotEmpty() &&
            operador.isNotEmpty()
        ) {
            val numero1 = primerNumero.toDouble()
            val numero2 = valor.toDouble()
            val resultado =
                when (operador) {
                    // case1
                    "+" -> numero1 + numero2
                    // case2
                    "-" -> numero1 - numero2
                    "*" -> numero1 * numero2
                    "/" -> {
                        if (numero2 != 0.0) {
                            numero1 / numero2
                        } else {
                            null
                        }
                    }
                    //default
                    else -> null
                }
            valor = if (resultado == null) {
                "Error"
            } else {
                if (resultado % 1 == 0.0) {
                    resultado.toLong().toString()
                } else {
                    resultado.toString()
                }
            }

            // Guardar en Room
            if (resultado != null) {
                viewModelScope.launch {

                    repository.guardarOperacion(
                        expresion = "$numero1 $operador $numero2",
                        resultado = valor
                    )
                }
            }
            primerNumero = ""
            operador = ""
        }
    }

    fun limpiar() {
        valor = ""
        primerNumero = ""
        operador = ""
    }
}