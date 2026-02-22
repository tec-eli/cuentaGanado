package com.example.cuentaganado.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = EarthAccentGreen,
    secondary = EarthDeepGreen,
    tertiary = EarthNeutral,
    background = EarthDark,
    surface = EarthSurface,
    onPrimary = EarthOnAccentDark,
    onSecondary = LightGreen,
    onTertiary = EarthOnDark,
    onBackground = EarthOnDark,
    onSurface = EarthOnDark
)

@Composable
fun CuentaGanadoTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}