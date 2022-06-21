package com.sumeyye.may14_roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepDatabaseDao {
    @Insert
    suspend fun insert(sleepNight: SllepNight)

    @Update
    fun update(sleepNight: SllepNight)

    @Delete
    fun delete(sleepNight: SllepNight)

    @Query("SELECT*FROM daily_sleep_quality_table WHERE nightId= :key")
    fun get(key: Long) :SllepNight?

    @Query("DELETE FROM daily_sleep_quality_table")
    suspend fun clear()

    @Query("SELECT*FROM daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): Flow<List<SllepNight>?>

    @Query("SELECT*FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
    fun getTonight(): SllepNight?
}