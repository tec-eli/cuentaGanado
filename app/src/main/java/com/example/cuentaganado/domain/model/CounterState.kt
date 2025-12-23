package com.example.cuentaganado.domain.model

data class CounterState(
    val male: Int = 0,
    val female: Int = 0
) {
    val total: Int get() = male + female
}

