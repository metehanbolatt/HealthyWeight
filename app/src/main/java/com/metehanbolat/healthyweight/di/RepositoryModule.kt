package com.metehanbolat.healthyweight.di

import com.google.firebase.auth.FirebaseAuth
import com.metehanbolat.healthyweight.repository.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(auth: FirebaseAuth) = AuthRepositoryImpl(auth = auth)
}