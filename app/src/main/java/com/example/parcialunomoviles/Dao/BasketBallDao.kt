package com.example.parcialunomoviles.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcialunomoviles.Entities.BasketBall

@Dao
interface BasketBallDao{

    @Query("SELECT * FROM partido")
    fun getAll():LiveData<List<BasketBall>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(new:BasketBall)
}