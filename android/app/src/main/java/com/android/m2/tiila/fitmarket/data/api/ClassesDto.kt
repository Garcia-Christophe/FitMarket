package com.android.m2.tiila.fitmarket.data.api

import kotlinx.serialization.Serializable

@Serializable
data class ClassesResultDto(
    val classes: List<ClasseDto>?,
    val error: String?
)

@Serializable
data class ClasseDto(
    val id: Int?,
    val product: ProductDto?,
    val video: String?,
    val day_time: String?,
    val duration: Int?,
    val address: String
)

@Serializable
data class ProductDto(
    val id: Int?,
    val price: Int?,
    val images: List<String>?,
    val description: String?,
    val category: String?,
    val title: String?,
)
