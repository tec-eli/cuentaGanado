package com.example.cuentaganado.data.repository

import com.example.cuentaganado.data.local.dao.CounterDao
import com.example.cuentaganado.data.local.entity.CounterEntity
import com.example.cuentaganado.domain.model.CounterState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(
    private val dao: CounterDao
) : CounterRepository {

    override fun observeCounter(): Flow<CounterState> =
        dao.observe().map { entity ->
            entity?.toState() ?: CounterState()
        }

    override suspend fun save(state: CounterState) {
        dao.save(state.toEntity())
    }

    override suspend fun reset() {
        dao.clear()
    }
}

private fun CounterEntity.toState() =
    CounterState(male = male, female = female)

private fun CounterState.toEntity() =
    CounterEntity(male = male, female = female)
