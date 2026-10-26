package org.ucb.mobile3p.contact.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.ucb.mobile3p.contact.domain.model.ContactModel
import org.ucb.mobile3p.contact.domain.repository.ContactRepository

class GetContactUseCase(
    private val contactRepository: ContactRepository
) {
    operator fun invoke(): Flow<ContactModel> = contactRepository.observeContact()
}
