package com.example.parcialunomoviles.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.parcialunomoviles.Dao.BasketBallDao
import com.example.parcialunomoviles.Entities.BasketBall

class BasketBallRepository(private val BKBdao:BasketBallDao){

    fun getAllBKB():LiveData<List<BasketBall>> = BKBdao.getAll()

    @WorkerThread
    suspend fun insertBasketball(bkb:BasketBall)=BKBdao.insert(bkb)
}