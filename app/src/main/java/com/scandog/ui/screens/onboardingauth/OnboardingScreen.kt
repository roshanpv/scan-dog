package com.scandog.ui.screens.onboardingauth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun OnboardingScreen(
    onboardingViewModel: OnboardingViewModel,
    navController: NavController,
) {

    OnboardingScreen()
}

@Composable
fun OnboardingScreen(

) {


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            text = "Hello Sucessfully Developer",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.Center)
        )

    }

}