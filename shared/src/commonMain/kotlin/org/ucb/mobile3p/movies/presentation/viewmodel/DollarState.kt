package org.ucb.mobile3p.movies.presentation.viewmodel

import org.ucb.mobile3p.movies.domain.model.DollarModel

data class DollarState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val list: List<DollarModel> = emptyList()
)
