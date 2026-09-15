package com.example.calculadora.interfaz

import android.R.attr.onClick
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculadora.interfaz.componentes.NavbarCalculadora
import com.example.calculadora.interfaz.componentes.ResultadoCalculadora
import com.example.calculadora.interfaz.componentes.TecladoCalculadora
import com.example.calculadora.ui.theme.Background


@Composable
fun CalculadoraScreen() {

    var valor by remember {
        mutableStateOf("")
    }
    var primerNumero by remember {
        mutableStateOf("")
    }
    var operador by remember {
        mutableStateOf("")
    }

    Scaffold (
        topBar = {
            NavbarCalculadora(
                onMenuClick = {
                },
                onMoreClick = {
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().
                        background(Background).
                        padding(paddingValues).
                        padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ResultadoCalculadora(valor)

            TecladoCalculadora(
                modifier = Modifier.weight(1f),
                onNumeroClick = { numero ->
                    valor += numero
                },
                onOperacionClick = { op ->
                    if (valor.isNotEmpty()) {
                        primerNumero = valor
                        operador = op
                        valor = ""
                    }
                },
                onIgualClick = {
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
                        primerNumero = ""
                        operador = ""
                    }
                },
                onLimpiarClick = {
                    valor = ""
                    primerNumero = ""
                    operador = ""
                }
            )
        }
    }
}
