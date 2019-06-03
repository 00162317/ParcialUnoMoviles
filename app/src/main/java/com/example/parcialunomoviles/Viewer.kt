package com.example.parcialunomoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.parcialunomoviles.Entities.BasketBall
import com.example.parcialunomoviles.ViewModel.BasketBallViewModel
import kotlinx.android.synthetic.main.activity_bkb.*
import kotlinx.android.synthetic.main.activity_viewer.*

class Viewer : AppCompatActivity() {

    lateinit var viewModelBKB: BasketBallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer)

        val dlc : Bundle = this.intent.extras.getBundle("joto")

        var basket : BasketBall = dlc.getParcelable("nigger")

        viewModelBKB= ViewModelProviders.of(this).get(BasketBallViewModel::class.java)//Aqui inicializo el viewModel

        viewer_equipo1.text = basket.equipo1
        viewer_equipo2.text = basket.equipo2
        viewer_equipo1_puntuacion.text = basket.puntuacion1
        viewer_equipo2_puntuacion.text = basket.puntuacion2
        viewer_hora.text = basket.hora
        viewer_fecha.text = basket.fecha

        if(basket.puntuacion1>basket.puntuacion2){
            viewer_ganador.text=basket.equipo1
        }
        else if(basket.puntuacion1<basket.puntuacion2){
            viewer_ganador.text=basket.equipo2
        }
        else{
            viewer_ganador.text="Empate"
        }

    }
}
