package org.ucb.mobile3p.stores.domain.repository

import org.ucb.mobile3p.stores.domain.model.StoreModel

interface StoresRepository {
    suspend fun getStores(): List<StoreModel>
}
