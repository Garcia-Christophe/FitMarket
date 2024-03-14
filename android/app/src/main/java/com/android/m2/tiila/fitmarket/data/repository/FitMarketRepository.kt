package com.android.m2.tiila.fitmarket.data.repository

import com.android.m2.tiila.fitmarket.domain.model.Member
import com.android.m2.tiila.fitmarket.toDomain
import com.android.m2.tiila.fitmarket.data.api.FitMarketApi
import com.android.m2.tiila.fitmarket.data.core.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FitMarketRepository(private val api : FitMarketApi) : FitMarketRepositoryInterface {
    override suspend fun signIn(
        email: String,
        password: String
    ): Flow<Resource<Member>> {
        return flow{
            emit(Resource.Loading())
            emit(Resource.Success(toDomain(api.signIn(email = email, password = password).data!!)))
        }
    }
}