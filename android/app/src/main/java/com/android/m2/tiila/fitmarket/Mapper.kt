package com.android.m2.tiila.fitmarket

import com.android.m2.tiila.fitmarket.data.api.ConnectionDto
import com.android.m2.tiila.fitmarket.domain.model.Member
import com.android.m2.tiila.fitmarket.data.api.MemberDto
import com.android.m2.tiila.fitmarket.domain.model.Connection


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
