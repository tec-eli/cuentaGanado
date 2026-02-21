package com.example.cuentaganado.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cuentaganado.data.repository.CounterRepository
import com.example.cuentaganado.domain.model.CounterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val repository: CounterRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CounterState())

    val state: StateFlow<CounterState> = _state

    init {
        viewModelScope.launch {
            repository.observeCounter().collect {
                stored -> _state.value = stored
            }
        }
    }
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
        if (_state.value.female > 0) updateState { copy(female = female - 1) }
    }

    fun reset() {
        updateState { CounterState() }
    }

    private fun updateState(transform: CounterState.() -> CounterState) {
        val newState = transform(_state.value)
        _state.value = newState

        viewModelScope.launch {
            repository.save(
                newState
            )
        }
    }
}

