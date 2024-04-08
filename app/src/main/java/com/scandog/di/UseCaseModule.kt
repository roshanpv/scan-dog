package com.scandog.di

import com.scandog.domain.signinusecase.OneTapSignInUseCase
import com.scandog.domain.signinusecase.OneTapSignInUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindOneTapSignInUseCase(oneTapSignInUseCaseImpl: OneTapSignInUseCaseImpl): OneTapSignInUseCase

}