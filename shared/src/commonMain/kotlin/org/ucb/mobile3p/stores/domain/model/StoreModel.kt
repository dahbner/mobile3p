package org.ucb.mobile3p.stores.domain.model

data class StoreModel(
    val id: String,
    val name: String,
    val address: String,
    val phone: String,
    val hours: List<String>
)
