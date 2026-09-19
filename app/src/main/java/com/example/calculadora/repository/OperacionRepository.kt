package com.example.calculadora.repository

import com.example.calculadora.data.local.dao.OperacionDao
import com.example.calculadora.data.local.entity.OperacionEntity

class OperacionRepository (private val operacionDao: OperacionDao){
    suspend fun guardarOperacion(expresion: String, resultado: String){
        val operacion = OperacionEntity(
            expresion = expresion,
            resultado = resultado
        )
        operacionDao.insertar(operacion)
    }

    suspend fun obtenerHistorial(): List<OperacionEntity> = operacionDao.obtenerTodas()

    suspend fun eliminarOperacion(operacion: OperacionEntity) = operacionDao.eliminar(operacion)

    suspend fun eliminarTodo() = operacionDao.eliminarTodas()
}