package com.example.graduationthesis.di

import com.example.graduationthesis.network.repository.FirebaseRepository
import com.example.graduationthesis.network.repository.FirebaseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

   @Singleton
   @Binds
   fun bindFirebaseRepository(impl: FirebaseRepositoryImpl?): FirebaseRepository

}