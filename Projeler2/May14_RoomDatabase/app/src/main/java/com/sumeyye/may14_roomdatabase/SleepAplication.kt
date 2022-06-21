package com.sumeyye.may14_roomdatabase

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class SleepAplication:Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { SleepDatabase.getInstance(this, applicationScope) }

    val repository by lazy { SleepRepository(database.sleepDatabaseDao()) }
}