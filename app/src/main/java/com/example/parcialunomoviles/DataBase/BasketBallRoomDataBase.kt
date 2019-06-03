package com.example.parcialunomoviles.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcialunomoviles.Dao.BasketBallDao
import com.example.parcialunomoviles.Entities.BasketBall

@Database(entities = [BasketBall::class],version = 1,exportSchema = false)
abstract class BasketBallRoomDataBase:RoomDatabase(){

    abstract fun BasketBallDao():BasketBallDao

    companion object {
        @Volatile
        private var INSTANCE: BasketBallRoomDataBase?=null

        fun getDatabase(
            context: Context
        ): BasketBallRoomDataBase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BasketBallRoomDataBase::class.java,
                    "partido"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE =instance
                instance
            }
        }
    }
}