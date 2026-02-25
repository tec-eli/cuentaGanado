package com.example.cuentaganado.ui.counter.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TotalSection(
    total: Int,
    onLongPress: () -> Unit,
    onClick: () -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val totalButtonHeight = screenHeight * 0.45f

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TOTAL",
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp),
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 30.sp
            ),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(totalButtonHeight)
                .combinedClickable(
                    onClick = onClick,
                    onLongClick = onLongPress,
                    role = Role.Button
                ),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 8.dp,
            shape = MaterialTheme.shapes.large
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(totalButtonHeight),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = total.toString(),
                    style = MaterialTheme.typography.displayLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 200.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
    }
}
