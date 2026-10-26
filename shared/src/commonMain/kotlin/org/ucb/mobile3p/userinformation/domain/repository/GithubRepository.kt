package org.ucb.mobile3p.userinformation.domain.repository

import org.ucb.mobile3p.userinformation.domain.model.UserInfoModel

interface GithubRepository {
    suspend fun findByAlias(alias: String): Result<UserInfoModel>
}
