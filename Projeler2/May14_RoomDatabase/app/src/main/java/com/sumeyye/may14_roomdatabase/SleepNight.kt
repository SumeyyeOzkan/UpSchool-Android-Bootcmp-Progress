package com.sumeyye.may14_roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_sleep_quality_table")
data class SllepNight(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="nightId")
    var nightId: Long= 0L,

    @ColumnInfo(name = "start_time_milli")
    var startTimeMilli : Long= System.currentTimeMillis(),

    @ColumnInfo(name = "end_time_milli")
    var endTimeMilli : Long= startTimeMilli,

    @ColumnInfo(name = "quality_rating")
    var sleepQuality : Int=-1



    )
