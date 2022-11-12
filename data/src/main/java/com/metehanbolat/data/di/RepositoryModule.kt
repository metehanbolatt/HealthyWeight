package com.metehanbolat.data.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.metehanbolat.data.repository.AuthRepositoryImpl
import com.metehanbolat.data.repository.FirestoreRepositoryImpl
import com.metehanbolat.domain.repository.AuthRepository
import com.metehanbolat.domain.repository.FirestoreRepository
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