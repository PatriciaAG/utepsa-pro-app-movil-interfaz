package com.example.calculadora.interfaz.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.ui.theme.AccentLilac
import com.example.calculadora.ui.theme.SurfaceLight
import com.example.calculadora.ui.theme.TextPrimary

@Composable
fun ResultadoCalculadora (valor: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxWidth().height(120.dp),
        color = SurfaceLight,
        shape = RoundedCornerShape(15.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(26.dp,6.dp)
                .background(AccentLilac),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center) {
            Text(
                text = valor,
                color = TextPrimary,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            )
        }
    }
}