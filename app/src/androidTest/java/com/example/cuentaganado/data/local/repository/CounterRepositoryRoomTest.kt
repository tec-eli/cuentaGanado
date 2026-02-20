package com.example.cuentaganado.data.local.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cuentaganado.data.local.database.AppDatabase
import com.example.cuentaganado.data.repository.CounterRepository
import com.example.cuentaganado.data.repository.CounterRepositoryImpl
import com.example.cuentaganado.domain.model.CounterState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class CounterRepositoryRoomTest {

    private lateinit var database: AppDatabase
    private lateinit var repository: CounterRepository

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        repository = CounterRepositoryImpl(
            dao = database.counterDao()
        )
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun givenRepositoryBackedByRoom_whenStateIsSaved_thenObservedStateMatches() = runTest {
        repository.save(CounterState(male = 2, female = 3))

        val state = repository.observeCounter().first()

        assertEquals(2, state.male)
        assertEquals(3, state.female)
        assertEquals(5, state.total)
    }

    @Test
    fun givenRepositoryBackedByRoom_whenResetIsCalled_thenObservedStateIsCleared() = runTest {
        repository.save(CounterState(male = 1, female = 1))

        repository.reset()

        val state = repository.observeCounter().first()

        assertEquals(0, state.male)
        assertEquals(0, state.female)
        assertEquals(0, state.total)
    }

    @Test
    fun givenRoomPersistsState_whenRepositoryIsRecreated_thenStateIsStillAvailable() = runTest {
        repository.save(CounterState(male = 1, female = 2))

        repository = CounterRepositoryImpl(
            dao = database.counterDao()
        )

        val state = repository.observeCounter().first()

        assertEquals(1, state.male)
        assertEquals(2, state.female)
        assertEquals(3, state.total)
    }
}
