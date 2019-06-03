package com.example.parcialunomoviles.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.parcialunomoviles.BasketBallRoomDataBase
import com.example.parcialunomoviles.Entities.BasketBall
import com.example.parcialunomoviles.Repository.BasketBallRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BasketBallViewModel(application: Application):AndroidViewModel(application){
    private var repository: BasketBallRepository? = null
    var allBKB: LiveData<List<BasketBall>>? = null
    var puntuacionEquipo1: Int=0
    var puntuacionEquipo2:Int=0

    init {
        val bkbDao=BasketBallRoomDataBase.getDatabase(application).BasketBallDao()

        repository= BasketBallRepository(bkbDao)

        allBKB=bkbDao.getAll()
    }

    fun insert(partido:BasketBall) = viewModelScope.launch(Dispatchers.IO){
        repository!!.insertBasketball(partido)
    }

    //fun mostrarPartido() = repository!!.getAllBKB()
}