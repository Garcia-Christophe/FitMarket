package com.android.m2.tiila.fitmarket.data.api

import com.android.m2.tiila.fitmarket.data.core.Resource
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent


class FitMarketApi(
    private val client: HttpClient,
    private var baseUrl: String = "http://10.0.2.2:8080/api/v1",
) : KoinComponent {
    suspend fun signIn(email: String, password: String): Resource<MemberDto> {
        try {
            val response:HttpResponse = client.post("$baseUrl/sign/in") {
                contentType(ContentType.Application.Json)
                setBody(PostSignInDto(email=email,password=password))
            }
            val responseBody = response.bodyAsText()
            val memberDTO = Json.decodeFromString<MemberDto>(responseBody)
            return Resource.Success(memberDTO)
        }catch (e:Exception) {
            return Resource.Error(e)
        }
    }
}


