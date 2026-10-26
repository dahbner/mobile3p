package org.ucb.mobile3p.exchange.data.datasource

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.ucb.mobile3p.exchange.data.dto.EventDto

class RealTimeDataBase {

    private val database by lazy { Firebase.database }
    private val messageRef by lazy  { database.reference("app_dollar") }
    private val eventsRef by lazy { database.reference("events") }

    fun observeMessage(): Flow<String?> {
        return messageRef.valueEvents
            .map {
                snapshot ->
                snapshot.value<String?>()
            }
    }

    // push() crea un hijo con ID único dentro de "events"
    suspend fun saveEvent(event: EventDto) {
        eventsRef.push().setValue(event)
    }
}
