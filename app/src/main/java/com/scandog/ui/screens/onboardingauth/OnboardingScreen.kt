package com.scandog.ui.screens.onboardingauth

import android.app.appsearch.AppSearchResult.RESULT_OK
import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import timber.log.Timber

@Composable
fun OnboardingScreen(
    onboardingViewModel: OnboardingViewModel,
    navController: NavController,
) {

    OnboardingScreen(
        signIn = onboardingViewModel::signIn,
        getUserData = onboardingViewModel::getUsersData
    )
}

@Composable
fun OnboardingScreen(
    signIn: (ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>) -> Unit,
    getUserData: (Intent) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val launcher: ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult> =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartIntentSenderForResult(),
            onResult = { result ->
                if (result.resultCode == RESULT_OK) {
                    Timber.e("parth -> Login Sucessfull")
                    getUserData(result.data ?: Intent())
                }
                Timber.e("parth -> Login Sucessfull ${result.data}")
            }
        )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Hello Sucessfully Developer",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    signIn(launcher)
                }
        )

    }

}