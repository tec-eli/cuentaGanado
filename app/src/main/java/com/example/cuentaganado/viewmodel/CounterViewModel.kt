package com.example.cuentaganado.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cuentaganado.domain.model.CounterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(CounterState())
    val state: StateFlow<CounterState> = _state

    fun incrementMale() {
        updateState { copy(male = male + 1) }
    }

    fun decrementMale() {
        if (state.value.male > 0) updateState { copy(male = male - 1) }
    }

    fun incrementFemale() {
        updateState { copy(female = female + 1) }
    }

    fun decrementFemale() {
        if (state.value.female > 0) updateState { copy(female = female - 1) }
    }

    fun reset() {
        updateState { CounterState() }
    }

    private fun updateState(transform: CounterState.() -> CounterState) {
        _state.value = state.value.transform()
    }
}

