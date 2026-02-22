package com.example.cuentaganado.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = EarthAccentGreen,
    secondary = EarthAccentAmber,
    tertiary = EarthNeutral,
    background = EarthDark,
    surface = EarthSurface,
    onPrimary = EarthOnAccentDark,
    onSecondary = EarthOnAccentDark,
    onTertiary = EarthOnDark,
    onBackground = EarthOnDark,
    onSurface = EarthOnDark
)

private val LightColorScheme = lightColorScheme(
    primary = EarthDeepGreen,
    secondary = EarthBurntOrange,
    tertiary = EarthNeutral,
    background = EarthLight,
    surface = EarthLight,
    onPrimary = EarthOnLight,
    onSecondary = EarthOnLight,
    onTertiary = EarthOnLight,
    onBackground = EarthOnLight,
    onSurface = EarthOnLight
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