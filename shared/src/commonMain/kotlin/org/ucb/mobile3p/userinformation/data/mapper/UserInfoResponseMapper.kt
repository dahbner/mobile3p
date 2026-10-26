package org.ucb.mobile3p.userinformation.data.mapper

import org.ucb.mobile3p.userinformation.data.dto.UserInfoDto
import org.ucb.mobile3p.userinformation.domain.model.UserInfoModel

fun UserInfoDto.toDomain(): UserInfoModel = UserInfoModel(
    email = email?:"",
    company = "",
    avatarUrl = avatarUrl?:"",
    alias = ""
)
