package com.mostafaai.mindm.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val NeonCyan = Color(0xFF00D2FF)
val ElectricPurple = Color(0xFF8B5CF6)
val DeepViolet = Color(0xFF4C1D95)
val DarkSurface = Color(0xFF0B0F19)
val DarkSurfaceContainer = Color(0xFF161D31)
val DarkBackground = Color(0xFF07090E)

private val MindMDarkColorScheme = darkColorScheme(
    primary = ElectricPurple,
    onPrimary = Color.White,
    primaryContainer = DeepViolet,
    secondary = NeonCyan,
    onSecondary = Color.Black,
    surface = DarkSurface,
    onSurface = Color(0xFFF1F5F9),
    background = DarkBackground,
    onBackground = Color(0xFFF1F5F9),
    surfaceContainer = DarkSurfaceContainer
)

@Composable
fun MindMDarkTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MindMDarkColorScheme,
        typography = Typography,
        content = content
    )
}
