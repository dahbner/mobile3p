package org.ucb.mobile3p.contact.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.ucb.mobile3p.contact.domain.model.ContactModel
import org.ucb.mobile3p.contact.domain.usecase.GetContactUseCase

class ContactViewModel(
    private val getContactUseCase: GetContactUseCase
) : ViewModel() {

    private val _contactState = MutableStateFlow(ContactModel())
    val contactState: StateFlow<ContactModel> = _contactState.asStateFlow()

    init {
        loadContact()
    }

    private fun loadContact() {
        viewModelScope.launch {
            getContactUseCase().collect { contact ->
                _contactState.value = contact
            }
        }
    }
}
