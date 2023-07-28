package com.example.mercurio.data.repository

import com.example.mercurio.core.StringConstants.NULL_USER
import com.example.mercurio.core.StringConstants.USER_NOT_FOUND
import com.example.mercurio.domain.models.Response
import com.example.mercurio.domain.models.Response.Failure
import com.example.mercurio.domain.models.Response.Success
import com.example.mercurio.domain.models.user.User
import com.example.mercurio.domain.repository.user.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    @Named("auth")
    private val auth: FirebaseAuth,
    @Named("users")
    private val usersRef: CollectionReference
) : UserRepository {

    override suspend fun logUser(
        email: String,
        password: String
    ): Response<Boolean> = try {
        auth.signInWithEmailAndPassword(
            email,
            password
        ).await()

        Success(true)
    } catch (e: Exception) {
        Failure(e)
    }

    override suspend fun createUser(
        name: String,
        email: String,
        password: String
    ): Response<Boolean> = try {
        auth.createUserWithEmailAndPassword(
            email,
            password
        ).await()
        val userFromAuth = auth.currentUser
        val id = userFromAuth!!.uid

        val user = User(
            userId = id,
            name = name,
            email = email
        )
        usersRef.document(id).set(user).await()

        Success(true)
    } catch (e: Exception) {
        Failure(e)
    }

    override suspend fun getLoggedUser(): Response<User> {
        val userFromAuth = auth.currentUser ?: return Failure(Exception(NULL_USER))

        return try {
            val querySnapshot = usersRef
               .whereEqualTo("userId", userFromAuth.uid)
               .get()
               .await()

            if (!querySnapshot.isEmpty) {
                val userData = querySnapshot.documents[0].toObject(User::class.java)

                Success(userData!!)
            } else {
                Failure(Exception(USER_NOT_FOUND))
            }
        } catch (e: Exception) {
            Failure(e)
        }
    }

    override suspend fun sendPasswordRecoveryEmail(email: String): Response<Boolean> = try {
        auth.sendPasswordResetEmail(email).await()

        Success(true)
    } catch (e: Exception) {
        Failure(e)
    }

    override fun logout() {
        auth.signOut()
    }
}