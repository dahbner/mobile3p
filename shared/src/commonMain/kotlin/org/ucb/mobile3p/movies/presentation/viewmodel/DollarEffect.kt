package org.ucb.mobile3p.movies.presentation.viewmodel

interface DollarEffect {
    data class ShowToast(val message: String): DollarEffect
}
