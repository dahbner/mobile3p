package org.ucb.mobile3p.translations.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val LOCO_API_KEY = "CGi0s9yvXv4inGLuaPoXzRp8bzvG0RNG"

class LocoApiService {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    // Devuelve { "clave": "texto", ... } del idioma pedido (ej. "en-US", "es-ES", "es-BO")
    suspend fun getTranslations(locale: String): Map<String, String> {
        return client.get(
            "https://localise.biz/api/export/locale/$locale.json?no-expand&fallback=auto&key=$LOCO_API_KEY"
        ).body()
    }
}
