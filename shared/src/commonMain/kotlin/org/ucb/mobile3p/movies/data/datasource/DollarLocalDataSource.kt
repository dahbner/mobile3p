package org.ucb.mobile3p.movies.data.datasource

import org.ucb.mobile3p.movies.data.dao.DollarDao
import org.ucb.mobile3p.movies.data.entity.DollarEntity
import org.ucb.mobile3p.movies.domain.model.DollarModel

class DollarLocalDataSource(
    val dao: DollarDao
) {
    suspend fun getList(): List<DollarModel> {
        return dao.getList().map {
            it.toModel()
        }
    }

    suspend fun insert(dollar: DollarModel) {
        dao.insert(dollar.toEntity())
    }

    private fun DollarEntity.toModel() : DollarModel {
        return DollarModel(
            official = dollarOfficial?: "",
            parallel = dollarParallel?:""
        )
    }

    private fun DollarModel.toEntity() = DollarEntity(
        dollarOfficial = "12.05",
        dollarParallel = "12.07"
    )
}
