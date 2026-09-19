package com.example.calculadora.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="operaciones")
data class OperacionEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val expresion : String,
    val resultado: String,
    val fecha: Long = System.currentTimeMillis()
)