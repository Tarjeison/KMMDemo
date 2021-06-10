package com.example.faglunsj2

import android.content.Context
import chuck.ChuckDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

lateinit var appContext: Context

actual fun createChuckDatabase(): ChuckDatabase {
    val driver = AndroidSqliteDriver(ChuckDatabase.Schema, appContext, "chuck.db")
    return ChuckDatabase(driver)
}