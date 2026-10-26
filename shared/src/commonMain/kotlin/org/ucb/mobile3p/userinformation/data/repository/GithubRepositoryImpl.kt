package org.ucb.mobile3p.userinformation.data.repository

import org.ucb.mobile3p.userinformation.data.datasource.GithubRemoteDataSource
import org.ucb.mobile3p.userinformation.data.mapper.toDomain
import org.ucb.mobile3p.userinformation.domain.model.UserInfoModel
import org.ucb.mobile3p.userinformation.domain.repository.GithubRepository

class GithubRepositoryImpl(val dataSource: GithubRemoteDataSource): GithubRepository {
    override suspend fun findByAlias(alias: String): Result<UserInfoModel> {
        return Result.success(dataSource.getUser(alias).toDomain())
    }
}
