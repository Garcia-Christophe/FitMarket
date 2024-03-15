package com.android.m2.tiila.fitmarket.data.api

import kotlinx.serialization.Serializable
@Serializable
data class ConnectionDto(
    val member: MemberDto?,
    val error: String?
)

@Serializable
data class MemberDto(
    val id: Int,
    val lastname: String,
    val firstname: String,
    var email: String,
    val password: String
)

@Serializable
data class PostSignInDto(
    var email: String,
    val password: String
)

