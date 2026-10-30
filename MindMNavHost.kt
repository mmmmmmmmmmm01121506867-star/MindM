package com.mostafaai.mindm.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mostafaai.mindm.ui.components.MindMBottomBar
import com.mostafaai.mindm.ui.components.MindMTopBar
import com.mostafaai.mindm.ui.screens.MindChatScreen
import com.mostafaai.mindm.ui.screens.MindHomeScreen
import com.mostafaai.mindm.ui.screens.MindImageScreen
import com.mostafaai.mindm.ui.screens.MindLearnScreen
import com.mostafaai.mindm.ui.screens.MindMusicScreen

sealed class Screen(val route: String, val title: String) {
    data object Home : Screen("home", "MindM Hub")
    data object Chat : Screen("chat", "MindChat")
    data object Image : Screen("image", "MindImage 4K")
    data object Video : Screen("video", "MindVideo")
    data object Music : Screen("music", "MindMusic")
    data object Sound : Screen("sound", "MindSound")
    data object PDF : Screen("pdf", "MindPDF")
    data object Web : Screen("web", "MindWeb")
    data object Code : Screen("code", "MindCode")
    data object Learn : Screen("learn", "MindLearn")
}

@Composable
fun MindMNavHost() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Screen.Home.route

    Scaffold(
        topBar = { MindMTopBar(currentRoute = currentRoute) },
        bottomBar = { MindMBottomBar(navController = navController, currentRoute = currentRoute) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { MindHomeScreen(navController) }
            composable(Screen.Chat.route) { MindChatScreen() }
            composable(Screen.Image.route) { MindImageScreen() }
            composable(Screen.Music.route) { MindMusicScreen() }
            composable(Screen.Learn.route) { MindLearnScreen() }
        }
    }
}
