package com.android.m2.tiila.fitmarket.domain.model

data class Connection(
    val member: Member?,
    val error: String?
)

data class Member(
    val id: Int?,
    val lastname: String?,
    val firstname: String?,
    val email: String?,
    val password: String?
)