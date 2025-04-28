package com.alexyndrik.thousands_of_courses.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alexyndrik.thousands_of_courses.data.datastore.AppSettingsDataStore
import com.alexyndrik.thousands_of_courses.ui.login.LoginScreen
import com.alexyndrik.thousands_of_courses.ui.main.MainScreen
import com.alexyndrik.thousands_of_courses.ui.main.Screen
import com.alexyndrik.thousands_of_courses.ui.main.account.AccountScreen
import com.alexyndrik.thousands_of_courses.ui.main.favorites.FavoritesScreen
import com.alexyndrik.thousands_of_courses.ui.main.favorites.FavoritesViewModel
import com.alexyndrik.thousands_of_courses.ui.main.home.CoursesViewModel
import com.alexyndrik.thousands_of_courses.ui.main.home.HomeScreen
import com.alexyndrik.thousands_of_courses.ui.onboarding.OnboardingScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppEntryPoint(
    coursesViewModel: CoursesViewModel,
    favoritesViewModel: FavoritesViewModel
) {

    val context = LocalContext.current
    var onboardingCompleted by remember { mutableStateOf<Boolean?>(null) }
    var isAuthorized by remember { mutableStateOf<Boolean?>(null) }

    LaunchedEffect(Unit) {
        onboardingCompleted = AppSettingsDataStore.readOnboardingState(context)
        isAuthorized = AppSettingsDataStore.readAuthorizationState(context)
    }

    if (onboardingCompleted == null || isAuthorized == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (onboardingCompleted == false) {
        OnboardingScreen {
            CoroutineScope(Dispatchers.IO).launch {
                AppSettingsDataStore.saveOnboardingState(context, true)
            }
            onboardingCompleted = true
        }
    } else if (isAuthorized == false) {
        LoginScreen(
            onLoginClick = { email ->
                CoroutineScope(Dispatchers.IO).launch {
                    AppSettingsDataStore.saveAuthorizationState(context, true, email)
                }
                isAuthorized = true
            },
            onVkClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com"))) },
            onOkClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://ok.ru"))) }
        )
    } else {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { MainScreen(navController) }
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route
            ) {
                composable(Screen.Home.route) { HomeScreen(coursesViewModel, favoritesViewModel) }
                composable(Screen.Favorites.route) { FavoritesScreen(favoritesViewModel) }
                composable(Screen.Account.route) { AccountScreen() }
            }
        }
    }
}