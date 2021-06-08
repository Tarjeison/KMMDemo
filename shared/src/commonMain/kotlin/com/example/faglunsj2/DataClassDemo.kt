package com.example.faglunsj2

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant


class DataClassDemo {
    fun getInfo() = Info("Informasjon")
    fun getAnimalCat(): Animal = Animal.Cat()
    fun getAnimalDog(): Animal = Animal.Dog()
}

data class Info(val infoText: String)

fun getInfoFunction() = Info("Informasjon er bra")

sealed class Animal {
    abstract val sound: String
    data class Cat(override val sound: String = "Mjau"): Animal()
    data class Dog(override val sound: String = "Voff", val isAGoodBoy: Boolean = true): Animal()
}

class ASyncRepo() {
    suspend fun doSomeWork(): String {
        return "Done"
    }
}

class SomeTime() {
    fun getTimeNow(): Instant {
        return Clock.System.now()
    }
}
