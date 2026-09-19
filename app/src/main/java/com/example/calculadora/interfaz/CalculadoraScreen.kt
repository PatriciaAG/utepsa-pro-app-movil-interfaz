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
import com.example.calculadora.viewmodel.CalculadoraViewModel


@Composable
fun CalculadoraScreen(viewModel: CalculadoraViewModel) {
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
            ResultadoCalculadora(viewModel.valor)

            TecladoCalculadora(
                modifier = Modifier.weight(1f),
                onNumeroClick = { numero ->
                    viewModel.numero(numero)
                },
                onOperacionClick = { op ->
                    viewModel.operacion(op)
                },
                onIgualClick = {
                    viewModel.igual()
                },
                onLimpiarClick = {
                    viewModel.limpiar()
                }
            )
        }
    }
}
