package com.example.calculadora.interfaz.componentes

import android.graphics.drawable.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun NavbarCalculadora( onMenuClick: () -> Unit, onMoreClick: () -> Unit) {
    @OptIn(ExperimentalMaterial3Api::class)
    TopAppBar(
        navigationIcon = {

            IconButton(
                onClick = onMenuClick
            ) {

                Text("Menu")
            }
        },

        title = {
            Text(
                text = "Calculadora"
            )
        },

        actions = {

            IconButton(
                onClick = onMoreClick
            ) {

                Text("Opciones")
            }
        }
    )
}