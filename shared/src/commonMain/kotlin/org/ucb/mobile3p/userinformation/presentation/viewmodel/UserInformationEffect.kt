package org.ucb.mobile3p.userinformation.presentation.viewmodel

sealed interface UserInformationEffect {
    data class ShowToast(val message: String): UserInformationEffect
    object NavigateToBack: UserInformationEffect
}
