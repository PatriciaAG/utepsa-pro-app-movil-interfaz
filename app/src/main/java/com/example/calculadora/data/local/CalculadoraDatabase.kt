package com.example.calculadora.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calculadora.data.local.dao.OperacionDao
import com.example.calculadora.data.local.entity.OperacionEntity

@Database(
    entities=[OperacionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CalculadoraDatabase : RoomDatabase(){
        abstract fun operacionDao(): OperacionDao

        companion object {
            @Volatile
            private var INSTANCE: CalculadoraDatabase?= null

            fun getDatabase(context: Context) : CalculadoraDatabase {
                return INSTANCE ?: synchronized(this) {
                    INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        CalculadoraDatabase::class.java,
                        "calculadora_db"
                    ).build().also { INSTANCE = it }
                }
            }

        }
}