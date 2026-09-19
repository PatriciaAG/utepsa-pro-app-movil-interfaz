package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.calculadora.data.local.CalculadoraDatabase
import com.example.calculadora.interfaz.CalculadoraScreen
import com.example.calculadora.repository.OperacionRepository
import com.example.calculadora.viewmodel.CalculadoraViewModel
import com.example.calculadora.viewmodel.CalculadoraViewModelFactory

class MainActivity : ComponentActivity() {
    private val database by lazy {
        CalculadoraDatabase.getDatabase(applicationContext)
    }

    private val repository by lazy {
        OperacionRepository(
            database.operacionDao()
        )
    }

    private val calculadoraViewModel: CalculadoraViewModel by viewModels {
        CalculadoraViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraScreen(calculadoraViewModel)
        }
    }
}
