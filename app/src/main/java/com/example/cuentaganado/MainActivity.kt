package com.example.cuentaganado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cuentaganado.ui.theme.CuentaGanadoTheme

class MainActivity : ComponentActivity() {
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuentaGanadoTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        CounterScreen(
                            modifier = Modifier.padding(innerPadding),
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}

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
private fun RowScope.GenderCounterCard(
    label: String,
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Card(
        modifier = Modifier
            .weight(1f)
            .height(280.dp),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .combinedClickable(
                    onClick = onIncrement,
                    onLongClick = onDecrement,
                    role = Role.Button
                ),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = count.toString(),
                style = MaterialTheme.typography.displayLarge.copy(fontSize = 72.sp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CounterScreenContent(
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TotalSection(
    total: Int,
    onLongPress: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = {},
                onLongClick = onLongPress,
                role = Role.Button
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TOTAL",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
        )
        Text(
            text = total.toString(),
            style = MaterialTheme.typography.displayLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 84.sp
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
private fun FinalizeDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Finalizar conteo") },
        text = { Text(text = "¿Confirmás finalizar el conteo actual?") },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Finalizar", color = MaterialTheme.colorScheme.error)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Cancelar")
            }
        }
    )
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
