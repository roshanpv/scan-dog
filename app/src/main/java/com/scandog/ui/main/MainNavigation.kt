package com.scandog.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.scandog.ui.Routes
import com.scandog.ui.screens.onboardingauth.OnboardingScreen
import com.scandog.ui.screens.onboardingauth.OnboardingViewModel
import com.scandog.ui.screens.splash.SplashScreen

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    navController: NavHostController,
    startDestination: String,
) {


    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination,
    ) {

        composable(Routes.onboardingAuth) {
            val onboardingViewModel = hiltViewModel<OnboardingViewModel>()
            OnboardingScreen(
                onboardingViewModel = onboardingViewModel,
                navController = navController
            )
        }

        composable(Routes.splashScreen) {
            SplashScreen(navController = navController)
        }

    }
}