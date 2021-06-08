package com.example.faglunsj2

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class ChuckNorrisRepository {
    private val chuckNorrisClient = HttpClient() {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getChuckNorrisFunFact(): ChuckNorrisResponse {
        return chuckNorrisClient.get("https://api.chucknorris.io/jokes/random")
    }
}

@Serializable
data class ChuckNorrisResponse(
    val categories: List<String>,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("icon_url")
    val iconUrl: String,
    @SerialName("updated_at")
    val updatedAt: String,
    val url: String,
    val value: String
)