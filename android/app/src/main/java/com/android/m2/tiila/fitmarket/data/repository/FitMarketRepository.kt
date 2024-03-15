package com.android.m2.tiila.fitmarket.data.repository

import com.android.m2.tiila.fitmarket.toDomain
import com.android.m2.tiila.fitmarket.data.api.FitMarketApi
import com.android.m2.tiila.fitmarket.data.core.Resource
import com.android.m2.tiila.fitmarket.data.core.Status
import com.android.m2.tiila.fitmarket.domain.model.ClassesResultDomain
import com.android.m2.tiila.fitmarket.domain.model.Connection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FitMarketRepository(private val api : FitMarketApi) : FitMarketRepositoryInterface {
    override suspend fun signIn(
        email: String,
        password: String
    ): Flow<Resource<Connection?>> {
        return flow{
            emit(Resource.Loading())
            try {
                val signInResponse = api.signIn(email = email, password = password)
                if(signInResponse.status==Status.ERROR){
                    emit(Resource.Error(toDomain(signInResponse.data!!)))
                }else{
                    emit(Resource.Success(toDomain(signInResponse.data!!)))
                }
            } catch (e: Exception) {
                // Gérer l'erreur et émettre une ressource d'échec
                emit(Resource.Error(null))
            }
        }
    }

    override suspend fun collectClassesUser(
        id: Int,
    ): Flow<Resource<ClassesResultDomain?>> {
        return flow{
            emit(Resource.Loading())
            try {
                val response = api.collectClassesUser(id=id)
                if(response.status==Status.ERROR){
                    emit(Resource.Error(toDomain(response.data!!)))
                }else{
                    emit(Resource.Success(toDomain(response.data!!)))
                }
            } catch (e: Exception) {
                // Gérer l'erreur et émettre une ressource d'échec
                emit(Resource.Error(null))
            }
        }
    }
}