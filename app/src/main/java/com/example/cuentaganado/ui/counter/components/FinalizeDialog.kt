package com.example.cuentaganado.ui.counter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.material3.LocalContentColor
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FinalizeDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.tertiary) {
                Column(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
                    Text(
                        text = "Finalizar conteo",
                        style = MaterialTheme.typography.labelMedium.copy(fontSize = 26.sp)
                    )
                }
            }
        },
        text = {
            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.tertiary) {
                Column(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
                    Text(
                        text = "¿Confirmás finalizar el conteo actual?",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
                    )
                }
            }
        },
        confirmButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp)
            ) {
                Button(
                    onClick = onConfirm,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Text(
                        text = "Finalizar",
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 20.sp
                    )
                }
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(
                        text = "Cancelar",
                        fontSize = 20.sp
                    )
                }
            }
        },
        dismissButton = {}
    )
}