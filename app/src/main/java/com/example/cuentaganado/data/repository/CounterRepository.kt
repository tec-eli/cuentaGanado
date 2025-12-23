package com.example.cuentaganado.data.repository

import com.example.cuentaganado.domain.model.CounterState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CounterRepository @Inject constructor() {

    private var state = CounterState()

    fun getState(): CounterState = state

    fun saveState(newState: CounterState) {
        state = newState
    }

    fun getCounter(): Int {
        return 0
    }

    fun updateCounter(newValue: Int) {
    }
}
