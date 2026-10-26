package org.ucb.mobile3p.movies.data.repository

import org.ucb.mobile3p.movies.data.datasource.DollarLocalDataSource
import org.ucb.mobile3p.movies.domain.model.DollarModel
import org.ucb.mobile3p.movies.domain.repository.DollarRepository

class DollarRepositoryImpl(
    val localDataSource: DollarLocalDataSource
): DollarRepository {
    override suspend fun getList(): List<DollarModel> {
        return localDataSource.getList()
    }

    override suspend fun insert(dollar: DollarModel) {
        localDataSource.insert(dollar)
    }
}
