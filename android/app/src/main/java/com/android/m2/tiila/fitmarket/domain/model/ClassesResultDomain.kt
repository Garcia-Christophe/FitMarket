package com.android.m2.tiila.fitmarket.domain.model

data class ClassesResultDomain(
    val classes: List<Classe>?,
    val error: String?
)

data class Classe(
    val id: Int?,
    val product: Product?,
    val video: String?,
    val day_time: String?,
    val duration: Int?,
    val address: String
)

data class Product(
    val id: Int?,
    val price: Int?,
    val images: List<String>?,
    val description: String?,
    val category: String?,
    val title: String?,
)