package com.sumeyye.may14_roomdatabase

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class SleepRepository(private val sleepDatabaseDao: SleepDatabaseDao) {

    val allSleepNight: Flow<List<SllepNight>?> = sleepDatabaseDao.getAllNights()//kotlinx.concurrent.flow ampüle basılıp import ediliri

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(sleepNight: SllepNight) {
        sleepDatabaseDao.insert(sleepNight)
    }
}
