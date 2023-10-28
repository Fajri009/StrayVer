package com.fajri.strayver.di

import android.content.Context
import com.fajri.strayver.data.FirebaseRepository
import com.fajri.strayver.data.OnBoardRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOnBoardDataStore(@ApplicationContext context: Context)= OnBoardRepository(context)

    @Provides
    @Singleton
    fun provideFirebaseAuth()= FirebaseRepository()

}