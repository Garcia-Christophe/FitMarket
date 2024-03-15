package com.android.m2.tiila.fitmarket

import com.android.m2.tiila.fitmarket.data.api.ClasseDto
import com.android.m2.tiila.fitmarket.data.api.ClassesResultDto
import com.android.m2.tiila.fitmarket.data.api.ConnectionDto
import com.android.m2.tiila.fitmarket.domain.model.Member
import com.android.m2.tiila.fitmarket.data.api.MemberDto
import com.android.m2.tiila.fitmarket.data.api.ProductDto
import com.android.m2.tiila.fitmarket.domain.model.Classe
import com.android.m2.tiila.fitmarket.domain.model.ClassesResultDomain
import com.android.m2.tiila.fitmarket.domain.model.Connection
import com.android.m2.tiila.fitmarket.domain.model.Product


fun toDomain(dto: MemberDto): Member {
    return Member(
        id = dto.id,
        lastname = dto.lastname,
        firstname = dto.firstname,
        email = dto.email,
        password = dto.password
    )
}

fun toDomain(dto: ConnectionDto): Connection {
    return Connection(
        member = dto.member?.let { toDomain(it) },
        error = dto.error
    )
}

fun toDomain(dto: ClasseDto): Classe {
    return Classe(
        id = dto.id,
        product = dto.product?.let { toDomain(it) },
        video = dto.video,
        address = dto.address,
        day_time = dto.day_time,
        duration = dto.duration
    )
}

fun toDomain(dto: ProductDto): Product {
    return Product(
        id = dto.id,
        price = dto.price,
        images = dto.images,
        description = dto.description,
        category = dto.category,
        title = dto.title
    )
}

fun toDomain(dto: ClassesResultDto): ClassesResultDomain {
    return ClassesResultDomain(
        classes = dto.classes?.map { toDomain(it) },
        error = dto.error
    )
}

