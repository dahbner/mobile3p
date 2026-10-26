package org.ucb.mobile3p.userinformation.domain.usecase

import org.ucb.mobile3p.userinformation.domain.model.UserInfoModel
import org.ucb.mobile3p.userinformation.domain.repository.GithubRepository

class FindAliasUseCase(
    val repository: GithubRepository
) {
    suspend fun invoke(alias: String): Result<UserInfoModel> {
        return repository.findByAlias(alias)
    }
}
