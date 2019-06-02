package com.example.parcialunomoviles.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partido")
data class BasketBall(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_partido") val id_partido:Int,
    @ColumnInfo(name = "equipo1") val equipo1:String,
    @ColumnInfo(name = "equipo2") val equipo2:String,
    @ColumnInfo(name = "puntuacion1") val puntuacion1:String,
    @ColumnInfo(name = "puntuacion2") val puntuacion2: String,
    @ColumnInfo(name = "ganador") val ganador:String,
    @ColumnInfo(name = "hora") val hora:String,
    @ColumnInfo(name = "fecha") val fecha:String
)