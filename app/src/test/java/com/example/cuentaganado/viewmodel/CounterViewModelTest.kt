package com.example.cuentaganado.viewmodel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CounterViewModelTest {

    @Before
    fun setUp() {
        val dispatcher = StandardTestDispatcher()
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun givenMaleIsZero_whenIncrementMale_thenMaleIsOne() {
        runTest {
            val repository = FakeCounterRepository()
            val viewModel = CounterViewModel(repository)

            viewModel.incrementMale()
            advanceUntilIdle()

            assertEquals(1, viewModel.state.value.male)
            assertEquals(0, viewModel.state.value.female)
            assertEquals(1, viewModel.state.value.total)
        }
    }

    @Test
    fun givenMaleIsZero_whenDecrementMale_thenMaleRemainsZero() {
        runTest {
            val repository = FakeCounterRepository()
            val viewModel = CounterViewModel(repository)

            viewModel.decrementMale()
            advanceUntilIdle()

            assertEquals(0, viewModel.state.value.male)
        }
    }

    @Test
    fun givenMaleAndFemaleAreNonZero_whenReset_thenBothAreZero() {
        runTest {
            val repository = FakeCounterRepository()
            val viewModel = CounterViewModel(repository)

            viewModel.incrementMale()
            viewModel.incrementFemale()
            advanceUntilIdle()

            viewModel.reset()
            advanceUntilIdle()

            assertEquals(0, viewModel.state.value.male)
            assertEquals(0, viewModel.state.value.female)
        }
    }

    @Test
    fun givenBothCountersZero_whenIncrementMale_thenTotalIsOne() {
        runTest {
            val repository = FakeCounterRepository()
            val viewModel = CounterViewModel(repository)

            viewModel.incrementMale()
            advanceUntilIdle()

            assertEquals(1, viewModel.state.value.total)
        }
    }

    @Test
    fun givenMaleOneFemaleZero_whenIncrementFemale_thenTotalIsTwo() {
        runTest {
            val repository = FakeCounterRepository()
            val viewModel = CounterViewModel(repository)

            viewModel.incrementMale()
            viewModel.incrementFemale()
            advanceUntilIdle()

            assertEquals(2, viewModel.state.value.total)
        }
    }

    @Test
    fun givenMaleTwoFemaleOne_whenDecrementMale_thenTotalIsTwo() {
        runTest {
            val repository = FakeCounterRepository()
            val viewModel = CounterViewModel(repository)

            viewModel.incrementMale()
            viewModel.incrementMale()
            viewModel.incrementFemale()
            advanceUntilIdle()

            viewModel.decrementMale()
            advanceUntilIdle()

            assertEquals(2, viewModel.state.value.total)
        }
    }

    @Test
    fun givenNonZeroCounters_whenReset_thenTotalIsZero() {
        runTest {
            val repository = FakeCounterRepository()
            val viewModel = CounterViewModel(repository)

            viewModel.incrementMale()
            viewModel.incrementFemale()
            advanceUntilIdle()

            viewModel.reset()
            advanceUntilIdle()

            assertEquals(0, viewModel.state.value.total)
        }
    }
}
