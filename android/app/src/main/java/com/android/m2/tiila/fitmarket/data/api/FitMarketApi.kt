package com.android.m2.tiila.fitmarket.data.api

import com.android.m2.tiila.fitmarket.data.core.Resource
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.koin.core.component.KoinComponent
import java.util.Objects


class FitMarketApi(
    private val client: HttpClient,
    private var baseUrl: String = "http://10.0.2.2:8080/api/v1",
) : KoinComponent {
    suspend fun signIn(email: String, password: String): Resource<ConnectionDto> {
        try {
            val response:HttpResponse = client.post("$baseUrl/sign/in") {
                contentType(ContentType.Application.Json)
                setBody(PostSignInDto(email=email,password=password))
            }
            val responseBody = response.bodyAsText()
            val json = Json { ignoreUnknownKeys = true }
            val jsonObject = json.parseToJsonElement(responseBody).jsonObject
            if ("code" in jsonObject) {
                val errorDescription = jsonObject["description"]?.jsonPrimitive?.contentOrNull
                val connection = ConnectionDto(member=null,error = errorDescription)
                return Resource.Error(connection)
            } else {
                val memberDto = json.decodeFromString<MemberDto>(responseBody)
                val connection = ConnectionDto(member=memberDto,error = null)
                return Resource.Success(connection)
            }
        }catch (e:Exception) {
            return Resource.Error(null)
        }
    }
}


