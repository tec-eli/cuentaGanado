package com.example.cuentaganado.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter")
data class CounterEntity(
    @PrimaryKey val id: Int = 0,
    val male: Int,
    val female: Int
)
