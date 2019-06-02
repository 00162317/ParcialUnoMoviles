package com.example.parcialunomoviles.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialunomoviles.Entities.BasketBall
import com.example.parcialunomoviles.R
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class BKBadapter(var partido:List<BasketBall>,var clickListener:(BasketBall)->Unit):RecyclerView.Adapter<BKBadapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view,parent,false))
    }

    override fun getItemCount(): Int = partido.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(partido[position], clickListener)

    internal fun setPartido(partido: List<BasketBall>){
        this.partido=partido
        notifyDataSetChanged()
    }

    class ViewHolder(item:View):RecyclerView.ViewHolder(item) {
        fun onBind(partido:BasketBall,clickListener: (BasketBall) -> Unit){

            itemView.equipo1_tv.text=partido.equipo1
            itemView.equipo2_tv.text=partido.equipo2

            itemView.setOnClickListener {
                clickListener(partido)
            }
        }
    }
}