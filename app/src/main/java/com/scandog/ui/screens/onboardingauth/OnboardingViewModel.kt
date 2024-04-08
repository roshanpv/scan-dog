package com.scandog.ui.screens.onboardingauth

import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scandog.domain.signinusecase.OneTapSignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val oneTapSignInUseCase: OneTapSignInUseCase
) : ViewModel() {

    fun signIn(launcher: ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>) {
        viewModelScope.launch {
            val signInIntentSender = oneTapSignInUseCase.oneTapSignIn()
            launcher.launch(
                IntentSenderRequest.Builder(
                    signInIntentSender ?: return@launch
                ).build()
            )
        }
    }

    fun getUsersData(intent: Intent) {
        viewModelScope.launch {
            val signInResult = oneTapSignInUseCase.signInWithIntent(
                intent = intent
            )
            Timber.e("parth -> ${signInResult.data?.username}")
        }
    }
}