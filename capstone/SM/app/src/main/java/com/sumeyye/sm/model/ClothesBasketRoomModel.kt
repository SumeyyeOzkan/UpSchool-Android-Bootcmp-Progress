package com.sumeyye.sm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productdatabase")
data class ClothesBasketRoomModel(

    @ColumnInfo(name = "user")
    var user: String?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "price")
    var price: Double?,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "category")
    var category: String?,

    @ColumnInfo(name = "image")
    var image: String?,

    @ColumnInfo(name = "rate")
    var rate: Double?,

    @ColumnInfo(name = "count")
    var count: Int?,

    @ColumnInfo(name = "sale_state")
    var sale_state: Int?)

{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?=null //Int = 0
}




