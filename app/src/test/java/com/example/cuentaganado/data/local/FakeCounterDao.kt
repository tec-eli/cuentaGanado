package com.example.cuentaganado.data.local.dao

import com.example.cuentaganado.data.local.entity.CounterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeCounterDao : CounterDao {

    private val state = MutableStateFlow<CounterEntity?>(null)

    override fun observe(): Flow<CounterEntity?> {
        return state
    }

    override suspend fun save(entity: CounterEntity) {
        state.value = entity
    }

    override suspend fun clear() {
        state.value = CounterEntity(
            id = 0,
            male = 0,
            female = 0
        )
    }
}
