package org.ucb.mobile3p.stores.domain.usecase

import org.ucb.mobile3p.stores.domain.model.StoreModel
import org.ucb.mobile3p.stores.domain.repository.StoresRepository

class GetStoresUseCase(
    val repository: StoresRepository
) {
    suspend fun invoke(): List<StoreModel> {
        return repository.getStores()
    }
}
