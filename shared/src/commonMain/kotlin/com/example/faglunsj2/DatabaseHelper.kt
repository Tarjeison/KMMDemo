package com.example.faglunsj2

import chuck.ChuckDatabase

class DatabaseHelper(private val chuckDatabase: ChuckDatabase) {

    fun getRandomJoke(): String {
        return chuckDatabase.dbQueries.selectAll().executeAsList().last().joke
    }

    fun insertJoke(joke: String) {
        chuckDatabase.dbQueries.insertItem(null, joke)
    }
}

expect fun createChuckDatabase(): ChuckDatabase
