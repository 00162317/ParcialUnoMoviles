package com.example.parcialunomoviles.Entities

import android.os.Parcel
import android.os.Parcelable
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
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_partido)
        parcel.writeString(equipo1)
        parcel.writeString(equipo2)
        parcel.writeString(puntuacion1)
        parcel.writeString(puntuacion2)
        parcel.writeString(ganador)
        parcel.writeString(hora)
        parcel.writeString(fecha)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BasketBall> {
        override fun createFromParcel(parcel: Parcel): BasketBall {
            return BasketBall(parcel)
        }

        override fun newArray(size: Int): Array<BasketBall?> {
            return arrayOfNulls(size)
        }
    }
}