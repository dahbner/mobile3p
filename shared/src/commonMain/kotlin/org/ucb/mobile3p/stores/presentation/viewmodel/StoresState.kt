package org.ucb.mobile3p.stores.presentation.viewmodel

import org.ucb.mobile3p.stores.domain.model.StoreModel

data class StoresState(
    val isLoading: Boolean = true,
    val stores: List<StoreModel> = emptyList(),
    val error: String? = null
)
