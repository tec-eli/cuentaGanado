package com.example.cuentaganado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
            CuentaGanadoTheme(darkTheme = true) {
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
    val state = viewModel.state.collectAsState().value

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Totals
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "TOTAL",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Text(
                text = state.total.toString(),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 64.sp
            )
        }

        // Male / Female rows
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "MALE", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = state.male.toString(),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                    Spacer(Modifier.height(12.dp))
                    Row {
                        Button(onClick = { viewModel.decrementMale() }) {
                            Text(text = "−", fontSize = 32.sp)
                        }
                        Spacer(Modifier.width(16.dp))
                        Button(onClick = { viewModel.incrementMale() }) {
                            Text(text = "+", fontSize = 32.sp)
                        }
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "FEMALE", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = state.female.toString(),
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                    Spacer(Modifier.height(12.dp))
                    Row {
                        Button(onClick = { viewModel.decrementFemale() }) {
                            Text(text = "−", fontSize = 32.sp)
                        }
                        Spacer(Modifier.width(16.dp))
                        Button(onClick = { viewModel.incrementFemale() }) {
                            Text(text = "+", fontSize = 32.sp)
                        }
                    }
                }
            }
        }

        // Reset row
        Button(
            onClick = { viewModel.reset() },
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Text(text = "RESET", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    CuentaGanadoTheme(darkTheme = true) {
        val previewState = CounterState(male = 10, female = 12)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TOTAL",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Text(
                text = previewState.total.toString(),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 64.sp
            )
        }
    }
}