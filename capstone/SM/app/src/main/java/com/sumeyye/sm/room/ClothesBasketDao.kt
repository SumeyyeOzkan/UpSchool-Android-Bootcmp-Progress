package com.sumeyye.sm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sumeyye.sm.model.ClothesBasketRoomModel
import retrofit2.http.DELETE

@Dao
interface ClothesBasketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)

   // @Insert
    fun addClothesBasket(clothesBasketRoomModel: ClothesBasketRoomModel)

    @Query("SELECT * FROM productdatabase")
    fun getClothesBasket(): List<ClothesBasketRoomModel>?

    @Query("SELECT title FROM productdatabase")
    fun getClothesNamesBasket(): List<String>?

    //@DELETE
    //fun delete(room:ClothesBasketRoomModel)

    @Query("DELETE FROM productdatabase WHERE id = :id")
    fun deleteClothesWithId(id: Int)

    @Query("DELETE FROM productdatabase")
    fun clearBasket()

}