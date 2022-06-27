package com.sumeyye.sm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sumeyye.sm.model.ClothesBasketRoomModel

@Database(entities = [ClothesBasketRoomModel::class], version = 1)
abstract class ClothesBasketRoomDatabase : RoomDatabase() {

    abstract fun clothesBasketDao(): ClothesBasketDao

    companion object {

        private var instance: ClothesBasketRoomDatabase? = null

        fun clothesBasketRoomDatabase(context: Context): ClothesBasketRoomDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ClothesBasketRoomDatabase::class.java,
                    "productdatabase.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}