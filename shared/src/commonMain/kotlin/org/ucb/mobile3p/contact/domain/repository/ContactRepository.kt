package org.ucb.mobile3p.contact.domain.repository

import kotlinx.coroutines.flow.Flow
import org.ucb.mobile3p.contact.domain.model.ContactModel

interface ContactRepository {
    fun observeContact(): Flow<ContactModel>
}
