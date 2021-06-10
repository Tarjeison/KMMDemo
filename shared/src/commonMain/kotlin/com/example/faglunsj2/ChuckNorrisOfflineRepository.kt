package com.example.faglunsj2

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.network.sockets.*

class ChuckNorrisOfflineRepository {
    private val chuckNorrisClient = HttpClient() {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
            serializer = KotlinxSerializer(json)
        }
    }

    private val databaseHelper = DatabaseHelper(createChuckDatabase())

    suspend fun getChuckNorrisFunFact(): String {
        return try {
            chuckNorrisClient.get<ChuckNorrisResponse>("https://api.chucknorris.io/jokes/random").value.also {
                databaseHelper.insertJoke(it)
            }
        } catch (e: Exception) {
            databaseHelper.getRandomJoke()
        }
    }
}