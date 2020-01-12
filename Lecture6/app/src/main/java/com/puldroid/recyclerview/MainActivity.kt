package com.puldroid.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val movies = arrayOf(
        "Iron Man",
        "Thor",
        "Captain America",
        "Doctor Strange",
        "Captain Marvel",
        "Black Panther"
    )
    val year = arrayOf("2008", "2010", "2011", "2016", "2019", "2018")
    val actors = arrayOf("RDJ", "Chris", "Chris Evans", "Benedict", "Brie", "Chadwick")
    val images = arrayOf(
        R.drawable.ironman,
        R.drawable.thor,
        R.drawable.captain,
        R.drawable.strange,
        R.drawable.marvel,
        R.drawable.panther
    )
    val list = arrayListOf<Movies>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0..100) {
            val random = Random().nextInt(5)
            val movie = Movies(
                movies[random],
                year[random],
                actors[random],
                images[random]
            )
            list.add(movie)
        }
        moviesRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MovieAdapter(list)
        }
    }
}

data class Movies(
    val name: String,
    val year: String,
    val actor: String,
    val image: Int
)