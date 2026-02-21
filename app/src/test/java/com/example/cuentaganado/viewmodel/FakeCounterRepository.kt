package com.example.cuentaganado.viewmodel

import com.example.cuentaganado.data.repository.CounterRepository
import com.example.cuentaganado.domain.model.CounterState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeCounterRepository : CounterRepository {

    private val counterState = MutableStateFlow(CounterState())

    override fun observeCounter(): Flow<CounterState> {
        return counterState
    }

    override suspend fun save(state: CounterState) {
        counterState.value = state
    }

    override suspend fun reset() {
        counterState.value = CounterState()
    }
}
