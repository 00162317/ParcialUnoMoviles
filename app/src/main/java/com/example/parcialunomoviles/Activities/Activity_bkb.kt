package com.example.parcialunomoviles.Activities

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.parcialunomoviles.Entities.BasketBall
import com.example.parcialunomoviles.R
import com.example.parcialunomoviles.ViewModel.BasketBallViewModel
import kotlinx.android.synthetic.main.activity_bkb.*

class Activity_bkb : AppCompatActivity() {

    lateinit var viewModelBKB:BasketBallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bkb)

        tecladoOff()

        viewModelBKB=ViewModelProviders.of(this).get(BasketBallViewModel::class.java)//Aqui inicializo el viewModel

        btn_guardar.setOnClickListener {
            var equipoGanador=""
            var partido=BasketBall(0,et_equipo1.text.toString(),et_equipo2.text.toString()
                ,equipo1.text.toString(),equipo2.text.toString(),equipoGanador,et_hora.text.toString(),et_fecha.text.toString())

            viewModelBKB.insert(partido)
        }
    }
    fun accionBoton(vista:View){
        when(vista){
            btnUnoEquipo1 ->{
                viewModelBKB.puntuacionEquipo1+=1
            }
            btnDosEquipo1->{
                viewModelBKB.puntuacionEquipo1+=2
            }
            btnTresEquipo1->{
                viewModelBKB.puntuacionEquipo1+=3
            }
            btnUnoEquipo2->{
                viewModelBKB.puntuacionEquipo2+=1
            }
            btnDosEquipo2->{
                viewModelBKB.puntuacionEquipo2+=2
            }
            btnTresEquipo2->{
                viewModelBKB.puntuacionEquipo2+=3
            }
        }
        equipo1.text=viewModelBKB.puntuacionEquipo1.toString()
        equipo2.text=viewModelBKB.puntuacionEquipo2.toString()
    }
    private fun tecladoOff(){
        var inm : InputMethodManager = this?.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(et_equipo1.windowToken, 0)
    }
}