package com.example.cuentaganado.data.repository

import com.example.cuentaganado.data.local.dao.FakeCounterDao
import com.example.cuentaganado.domain.model.CounterState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CounterRepositoryImplTest {

    @Test
    fun givenCounterStateIsPersisted_whenObserved_thenStateIsMappedCorrectly() = runTest {
        val dao = FakeCounterDao()
        val repository = CounterRepositoryImpl(dao)

        repository.save(CounterState(male = 2, female = 3))

        val state = repository.observeCounter().first()

        assertEquals(state.male + state.female, state.total)
    }

    @Test
    fun givenRepositoryContainsState_whenResetIsCalled_thenObservedStateIsCleared() = runTest {
        val dao = FakeCounterDao()
        val repository = CounterRepositoryImpl(dao)

        repository.save(CounterState(male = 1, female = 1))
        repository.reset()

        val state = repository.observeCounter().first()

        assertEquals(0, state.male)
        assertEquals(0, state.female)
        assertEquals(0, state.total)
    }

    @Test
    fun givenRepositoryReceivesMultipleSaves_whenObserved_thenLatestStateIsEmitted() = runTest {
        val dao = FakeCounterDao()
        val repository = CounterRepositoryImpl(dao)

        repository.save(CounterState(male = 1, female = 0))
        repository.save(CounterState(male = 3, female = 2))

        val state = repository.observeCounter().first()

        assertEquals(state.male + state.female, state.total)
    }
}
