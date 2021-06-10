package com.example.faglunsj2

import chuck.ChuckDatabase
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual fun createChuckDatabase(): ChuckDatabase {
    val driver = NativeSqliteDriver(ChuckDatabase.Schema, "chuck.db")
    return ChuckDatabase(driver)
}