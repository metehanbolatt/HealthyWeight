package com.metehanbolat.healthyweight.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.metehanbolat.healthyweight.repository.auth.AuthRepository
import com.metehanbolat.healthyweight.repository.auth.AuthRepositoryImpl
import com.metehanbolat.healthyweight.repository.firestore.FirestoreRepository
import com.metehanbolat.healthyweight.repository.firestore.FirestoreRepositoryImpl
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
    fun provideAuthRepository(auth: FirebaseAuth): AuthRepository = AuthRepositoryImpl(auth = auth)

    @Provides
    @Singleton
    fun provideFirestoreRepository(firestore: FirebaseFirestore): FirestoreRepository =
        FirestoreRepositoryImpl(firestore = firestore)
}