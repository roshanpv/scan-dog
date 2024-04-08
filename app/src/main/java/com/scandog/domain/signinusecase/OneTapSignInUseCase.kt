package com.scandog.domain.signinusecase

import android.content.Intent
import android.content.IntentSender
import com.scandog.domain.userdata.SignInUserData
import com.scandog.domain.userdata.UserData

interface OneTapSignInUseCase {

    suspend fun oneTapSignIn(): IntentSender?

    suspend fun signOut()

    suspend fun signInWithIntent(intent: Intent): SignInUserData

    fun getSignedInUser(): UserData?

}