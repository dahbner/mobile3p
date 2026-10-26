package org.ucb.mobile3p.movies.domain.repository

import org.ucb.mobile3p.movies.domain.model.DollarModel

interface DollarRepository {
    suspend fun getList(): List<DollarModel>

    suspend fun insert(dollar: DollarModel)
}
