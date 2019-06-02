package com.example.parcialunomoviles

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.parcialunomoviles.Entities.BasketBall
import com.example.parcialunomoviles.ViewModel.BasketBallViewModel
import kotlinx.android.synthetic.main.activity_bkb.*

class Activity_bkb : AppCompatActivity() {

    lateinit var viewModelBKB:BasketBallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bkb)

        viewModelBKB=ViewModelProviders.of(this).get(BasketBallViewModel::class.java)//Aqui inicializo el viewModel

        btn_guardar.setOnClickListener {
            var equipoGanador=""
            var partido=BasketBall(0,et_equipo1.text.toString(),et_equipo2.text.toString()
                ,equipo1.text.toString(),equipo2.text.toString(),equipoGanador,et_hora.text.toString(),et_fecha.text.toString())

            viewModelBKB.insert(partido)
            var carro = BasketBall(0,"","","","","","","")
            viewModelBKB.allBKB?.observe(this, Observer { datos ->
                datos?.let { carro = BasketBall(datos[0].id_partido,datos[datos.size-1].equipo1,datos[datos.size-1].equipo2,datos[0].puntuacion1,datos[0].puntuacion2,
                    datos[0].ganador,datos[0].hora,datos[0].fecha) }
            })

            Toast.makeText(this, carro.equipo1, Toast.LENGTH_SHORT).show()
            //finish()
        }
    }
}