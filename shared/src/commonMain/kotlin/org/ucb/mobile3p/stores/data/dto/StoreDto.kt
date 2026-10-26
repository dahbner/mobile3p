package org.ucb.mobile3p.stores.data.dto

import kotlinx.serialization.Serializable
import org.ucb.mobile3p.stores.domain.model.StoreModel

@Serializable
data class StoreDto(
    val name: String = "",
    val address: String = "",
    val phone: String = "",
    val hours: List<String> = emptyList()
) {
    fun toModel(id: String) = StoreModel(
        id = id,
        name = name,
        address = address,
        phone = phone,
        hours = hours
    )
}
