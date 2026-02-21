package com.example.cuentaganado.data.repository

import com.example.cuentaganado.domain.model.CounterState
import kotlinx.coroutines.flow.Flow

interface CounterRepository {
    fun observeCounter(): Flow<CounterState>
    suspend fun save(state: CounterState)
    suspend fun reset()
}

