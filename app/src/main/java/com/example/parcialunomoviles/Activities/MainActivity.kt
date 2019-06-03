package com.example.parcialunomoviles.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcialunomoviles.Adapter.BKBadapter
import com.example.parcialunomoviles.Entities.BasketBall
import com.example.parcialunomoviles.R
import com.example.parcialunomoviles.ViewModel.BasketBallViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewAdapter: BKBadapter
    lateinit var viewManager: LinearLayoutManager
    lateinit var viewModel:BasketBallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager= LinearLayoutManager(this)
        viewAdapter=BKBadapter(emptyList<BasketBall>(),{ variable:BasketBall->itemClick(variable)})
        recyclerMain.apply {
            adapter=viewAdapter
            layoutManager=viewManager
        }
        viewModel=ViewModelProviders.of(this).get(BasketBallViewModel::class.java)
        viewModel.allBKB?.observe(this, Observer { partido->
            partido?.let { viewAdapter.setPartido(it)}
        })
        btn_more.setOnClickListener {
            startActivity(Intent(this@MainActivity, Activity_bkb::class.java))
        }
    }
    fun itemClick(item:BasketBall){
        var content = Bundle()
        content.putParcelable("nigger", item)
        startActivity(Intent(this, Viewer::class.java).putExtra("joto", content)
        )
    }

}
