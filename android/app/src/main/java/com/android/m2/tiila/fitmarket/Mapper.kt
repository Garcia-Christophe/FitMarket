package com.android.m2.tiila.fitmarket

import com.android.m2.tiila.fitmarket.domain.model.Member
import com.android.m2.tiila.fitmarket.data.api.MemberDto


fun toDomain(dto: MemberDto): Member {
    return Member(
        id = dto.id,
        lastname = dto.lastname,
        firstname = dto.firstname,
        email = dto.email,
        password = dto.password
    )
}

fun toDto(domain: Member): MemberDto {
    return MemberDto(
        id = domain.id,
        lastname = domain.lastname,
        firstname = domain.firstname,
        email = domain.email,
        password = domain.password
    )
}
