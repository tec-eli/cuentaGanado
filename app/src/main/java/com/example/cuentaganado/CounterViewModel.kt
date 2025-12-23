package com.example.cuentaganado

import android.app.Application
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Simple immutable state holder
data class CounterState(
    val male: Int = 0,
    val female: Int = 0
) {
    val total: Int get() = male + female
}

class CounterViewModel(application: Application) : AndroidViewModel(application) {

    private val _state = MutableStateFlow(CounterState())
    val state: StateFlow<CounterState> = _state

    private val vibrator: Vibrator? =
        application.getSystemService(Vibrator::class.java)

    private fun vibrate(durationMs: Long, amplitude: Int = VibrationEffect.DEFAULT_AMPLITUDE) {
        vibrator?.vibrate(VibrationEffect.createOneShot(durationMs, amplitude))
    }

    private fun vibrateIncrement() = vibrate(30)
    private fun vibrateDecrement() = vibrate(60)
    private fun vibrateFinalize() = vibrate(120)

    fun incrementMale() {
        updateState { copy(male = male + 1) }
        vibrateIncrement()
    }

    fun decrementMale() {
        updateState { copy(male = (male - 1).coerceAtLeast(0)) }
        vibrateDecrement()
    }

    fun incrementFemale() {
        updateState { copy(female = female + 1) }
        vibrateIncrement()
    }

    fun decrementFemale() {
        updateState { copy(female = (female - 1).coerceAtLeast(0)) }
        vibrateDecrement()
    }

    fun reset() {
        updateState { CounterState() }
        vibrateFinalize()
    }

    private fun updateState(transform: CounterState.() -> CounterState) {
        viewModelScope.launch {
            _state.value = _state.value.transform()
            // TODO: persist state with Room when database is wired
        }
    }
}

