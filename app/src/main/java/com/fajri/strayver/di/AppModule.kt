package com.fajri.strayver.di

import android.content.Context
import com.fajri.strayver.data.repository.DatabaseRepository
import com.fajri.strayver.data.repository.UserRepository
import com.fajri.strayver.data.repository.OnBoardRepository
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
    fun provideFirebaseAuth()= UserRepository()

    @Provides
    @Singleton
    fun provideFirebaseDatabase()= DatabaseRepository()

}