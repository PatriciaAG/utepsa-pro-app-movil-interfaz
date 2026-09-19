package com.example.calculadora.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.calculadora.data.local.entity.OperacionEntity

@Dao
interface OperacionDao {
    @Insert
    suspend fun insertar(
        operacion: OperacionEntity
    ): Long

    @Query("Select * from operaciones order by fecha desc")
    suspend fun obtenerTodas(): List<OperacionEntity>

    @Query("Delete from operaciones")
    suspend fun eliminarTodas()

    @Delete
    suspend fun eliminar(operacion: OperacionEntity)
}