package org.ucb.mobile3p.exchange.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class EventDto(
    val type: String = "",
    val timestamp: Long = 0
)
