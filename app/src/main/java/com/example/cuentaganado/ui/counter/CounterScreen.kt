package com.example.cuentaganado.ui.counter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuentaganado.domain.model.CounterState
import com.example.cuentaganado.viewmodel.CounterViewModel
import com.example.cuentaganado.ui.components.FinalizeDialog
import com.example.cuentaganado.ui.components.GenderCounterCard
import com.example.cuentaganado.ui.components.TotalSection
import com.example.cuentaganado.ui.theme.CuentaGanadoTheme

@Composable
fun CounterScreen(
    modifier: Modifier = Modifier,
    viewModel: CounterViewModel
) {
    val state by viewModel.state.collectAsState()
    var showFinalizeDialog by remember { mutableStateOf(false) }

    CounterScreenContent(
        modifier = modifier,
        state = state,
        showFinalizeDialog = showFinalizeDialog,
        onShowFinalize = { showFinalizeDialog = true },
        onDismissFinalize = { showFinalizeDialog = false },
        onConfirmFinalize = {
            viewModel.reset()
            showFinalizeDialog = false
        },
        onIncrementMale = viewModel::incrementMale,
        onDecrementMale = viewModel::decrementMale,
        onIncrementFemale = viewModel::incrementFemale,
        onDecrementFemale = viewModel::decrementFemale
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CounterScreenContent(
    modifier: Modifier = Modifier,
    state: CounterState,
    showFinalizeDialog: Boolean,
    onShowFinalize: () -> Unit,
    onDismissFinalize: () -> Unit,
    onConfirmFinalize: () -> Unit,
    onIncrementMale: () -> Unit,
    onDecrementMale: () -> Unit,
    onIncrementFemale: () -> Unit,
    onDecrementFemale: () -> Unit
) {
    if (showFinalizeDialog) {
        FinalizeDialog(
            onDismiss = onDismissFinalize,
            onConfirm = onConfirmFinalize
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TotalSection(
            total = state.total,
            onLongPress = onShowFinalize
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            GenderCounterCard(
                label = "MACHO",
                count = state.male,
                onIncrement = onIncrementMale,
                onDecrement = onDecrementMale
            )
            GenderCounterCard(
                label = "HEMBRA",
                count = state.female,
                onIncrement = onIncrementFemale,
                onDecrement = onDecrementFemale
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1F1B16)
@Composable
fun CounterScreenPreview() {
    CuentaGanadoTheme {
        CounterScreenContent(
            state = CounterState(male = 12, female = 9),
            showFinalizeDialog = false,
            onShowFinalize = {},
            onDismissFinalize = {},
            onConfirmFinalize = {},
            onIncrementMale = {},
            onDecrementMale = {},
            onIncrementFemale = {},
            onDecrementFemale = {}
        )
    }
}
