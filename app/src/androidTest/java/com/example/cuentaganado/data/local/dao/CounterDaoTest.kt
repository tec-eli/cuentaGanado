package com.example.cuentaganado.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cuentaganado.data.local.database.AppDatabase
import com.example.cuentaganado.data.local.entity.CounterEntity
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
class CounterDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: CounterDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        dao = database.counterDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun givenDatabaseIsEmpty_whenObserved_thenNullIsReturned() = runTest {
        val result = dao.observe().first()
        assertEquals(null, result)
    }

    @Test
    fun givenEntityIsSaved_whenObserved_thenSameEntityIsReturned() = runTest {
        val entity = CounterEntity(
            id = 0,
            male = 0,
            female = 0
        )

        dao.save(entity)

        val result = dao.observe().first()

        assertEquals(entity, result)
    }

    @Test
    fun givenEntityExists_whenClearIsCalled_thenZeroEntityIsReturned() = runTest {
        dao.save(
            CounterEntity(
                id = 0,
                male = 1,
                female = 1
            )
        )

        dao.clear()

        val result = dao.observe().first()

        assertEquals(0, result?.male)
        assertEquals(0, result?.female)
    }
}
