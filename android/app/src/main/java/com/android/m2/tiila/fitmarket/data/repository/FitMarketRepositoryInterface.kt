package com.android.m2.tiila.fitmarket.data.repository

import com.android.m2.tiila.fitmarket.domain.model.Member
import com.android.m2.tiila.fitmarket.data.core.Resource
import kotlinx.coroutines.flow.Flow

interface FitMarketRepositoryInterface {
    suspend fun signIn(email: String, password: String): Flow<Resource<Member>>
}