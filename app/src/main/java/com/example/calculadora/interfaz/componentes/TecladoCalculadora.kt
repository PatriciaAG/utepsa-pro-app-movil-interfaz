package com.example.calculadora.interfaz.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculadora.ui.theme.OperationBlue
import com.example.calculadora.ui.theme.PurplePrimary

@Composable
fun TecladoCalculadora(
    modifier: Modifier = Modifier,
    onNumeroClick:(String) -> Unit,
    onOperacionClick:(String) -> Unit,
    onIgualClick:() -> Unit,
    onLimpiarClick:() -> Unit,
) {
    Column( modifier = modifier.fillMaxSize(),verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(modifier = Modifier.weight(1f),horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BotonCalculadora("7", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("7")})
            BotonCalculadora("8", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("8")})
            BotonCalculadora("9", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("9")})
            BotonCalculadora("/", OperationBlue, Modifier.weight(1f), onClick = {onOperacionClick("/")})
        }
        Row(modifier = Modifier.weight(1f),horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BotonCalculadora("4", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("4")})
            BotonCalculadora("5", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("5")})
            BotonCalculadora("6", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("6")})
            BotonCalculadora("*", OperationBlue, Modifier.weight(1f), onClick = {onOperacionClick("*")})
        }
        Row(modifier = Modifier.weight(1f),horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BotonCalculadora("1", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("1")})
            BotonCalculadora("2", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("2")})
            BotonCalculadora("3", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("3")})
            BotonCalculadora("-", OperationBlue, Modifier.weight(1f), onClick = {onOperacionClick("-")})
        }
        Row(modifier = Modifier.weight(1f),horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            BotonCalculadora("C", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("C")})
            BotonCalculadora("0", PurplePrimary, Modifier.weight(1f), onClick = {onNumeroClick("0")})
            BotonCalculadora("=", OperationBlue, Modifier.weight(1f), onClick = {onNumeroClick("=")})
            BotonCalculadora("+", OperationBlue, Modifier.weight(1f), onClick = {onOperacionClick("+")})
        }
    }
}