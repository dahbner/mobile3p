package org.ucb.mobile3p.stores.data.repository

import org.ucb.mobile3p.stores.data.datasource.FirestoreDataSource
import org.ucb.mobile3p.stores.domain.model.StoreModel
import org.ucb.mobile3p.stores.domain.repository.StoresRepository

class StoresRepositoryImpl(
    val firestoreDataSource: FirestoreDataSource
): StoresRepository {
    override suspend fun getStores(): List<StoreModel> {
        return firestoreDataSource.getStores()
    }
}
