package com.example.mercurio.di

import com.example.mercurio.core.Constants.USERS
import com.example.mercurio.data.repository.UserRepositoryImpl
import com.example.mercurio.domain.repository.user.UserRepository
import com.example.mercurio.domain.use_cases.user.UserUseCases
import com.example.mercurio.domain.use_cases.user.use_cases.CreateUser
import com.example.mercurio.domain.use_cases.user.use_cases.GetLoggedUser
import com.example.mercurio.domain.use_cases.user.use_cases.LogUser
import com.example.mercurio.domain.use_cases.user.use_cases.Logout
import com.example.mercurio.domain.use_cases.user.use_cases.SendPasswordRecoveryEmail
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Core
    @Provides
    @Named("auth")
    fun provideAuth() = Firebase.auth

    // User
    @Provides
    @Named("users")
    fun provideUsersRef() = Firebase.firestore.collection(USERS)

    @Provides
    fun provideUserRepository(
        @Named("auth")
        auth: FirebaseAuth,
        @Named("users")
        usersRef: CollectionReference
    ) : UserRepository = UserRepositoryImpl(auth, usersRef)

    @Provides
    fun provideUserUseCases(
        repo: UserRepository
    ) = UserUseCases(
        logUser = LogUser(repo),
        createUser = CreateUser(repo),
        getLoggedUser = GetLoggedUser(repo),
        sendPasswordRecoveryEmail = SendPasswordRecoveryEmail(repo),
        logout = Logout(repo)
    )
}