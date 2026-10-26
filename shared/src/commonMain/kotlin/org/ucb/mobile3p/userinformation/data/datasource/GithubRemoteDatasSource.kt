package org.ucb.mobile3p.userinformation.data.datasource

import org.ucb.mobile3p.userinformation.data.dto.UserInfoDto

interface GithubRemoteDataSource {
    suspend fun getUser(nickname: String): UserInfoDto
}
