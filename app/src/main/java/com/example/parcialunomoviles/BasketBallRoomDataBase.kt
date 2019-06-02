package com.example.parcialunomoviles

import android.content.Context
import androidx.annotation.RestrictTo
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.parcialunomoviles.Dao.BasketBallDao
import com.example.parcialunomoviles.Entities.BasketBall
import kotlinx.coroutines.CoroutineScope

@Database(entities = [BasketBall::class],version = 1,exportSchema = false)
abstract class BasketBallRoomDataBase:RoomDatabase(){

    abstract fun BasketBallDao():BasketBallDao

    companion object {
        @Volatile
        private var INSTANCE:BasketBallRoomDataBase?=null

        fun getDatabase(
            context: Context
        ):BasketBallRoomDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BasketBallRoomDataBase::class.java,
                    "partido"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE=instance
                instance
            }
        }
    }
}