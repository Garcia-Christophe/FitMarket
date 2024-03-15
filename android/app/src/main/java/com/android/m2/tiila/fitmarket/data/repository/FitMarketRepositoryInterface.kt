package com.android.m2.tiila.fitmarket.data.repository

import com.android.m2.tiila.fitmarket.data.core.Resource
import com.android.m2.tiila.fitmarket.domain.model.ClassesResultDomain
import com.android.m2.tiila.fitmarket.domain.model.Connection
import kotlinx.coroutines.flow.Flow

interface FitMarketRepositoryInterface {
    suspend fun signIn(email: String, password: String): Flow<Resource<Connection?>>
    suspend fun collectClassesUser(id: Int): Flow<Resource<ClassesResultDomain?>>
}