package com.example.cuentaganado.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cuentaganado.data.local.dao.CounterDao
import com.example.cuentaganado.data.local.entity.CounterEntity

@Database(
    entities = [CounterEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun counterDao(): CounterDao
}
