package org.ucb.mobile3p.contact.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import org.ucb.mobile3p.contact.data.datasource.RemoteConfigDataSource
import org.ucb.mobile3p.contact.domain.model.ContactModel
import org.ucb.mobile3p.contact.domain.repository.ContactRepository

class ContactRepositoryImpl(
    private val remoteConfigDataSource: RemoteConfigDataSource
) : ContactRepository {

    override fun observeContact(): Flow<ContactModel> = combine(
        remoteConfigDataSource.getPhone(),
        remoteConfigDataSource.getEmail(),
        remoteConfigDataSource.isWhatsappEnabled()
    ) { phone, email, whatsappEnabled ->
        ContactModel(
            phone = phone,
            email = email,
            whatsappEnabled = whatsappEnabled
        )
    }
}
