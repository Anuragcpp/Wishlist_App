package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntry : Wish)

    // loads all wishes from the wish table
    @Query("select * from `wish-table`")
    abstract fun getAllWishes() : Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wishEntry: Wish)


    @Delete
    abstract suspend fun deleteWish(wishEntry: Wish)

    @Query("select * from `wish-table` where id=:id")
    abstract fun getWishById( id : Long ) : Flow<Wish>
}