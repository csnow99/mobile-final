package com.example.a38_recommendify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "MainActivity"
const val NUMBER = "number"

class MainActivity : AppCompatActivity() {

    var input = ""
    private lateinit var mRecycler: RecyclerView
    private var adapter: SongAdapter = SongAdapter(this, getSongList())
    private lateinit var dataSource: DataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecycler = findViewById(R.id.song_recycler)

        val submit = findViewById<Button>(R.id.searchButton)
        val tallyWord = findViewById<EditText>(R.id.search)

        submit.setOnClickListener{
            addSong()
        }

        mRecycler.layoutManager = LinearLayoutManager(this)
        mRecycler.adapter = adapter

        dataSource = DataSource.getDataSource()
        val choicesLiveData = dataSource.getNumberList()

        choicesLiveData.observe(this) {
            it?.let {
                adapter = SongAdapter(this, it)
                mRecycler.adapter = adapter
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("word", input)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        input = savedInstanceState.getString("word").toString()
        super.onRestoreInstanceState(savedInstanceState)
    }
    private fun addSong() {
        dataSource.insertSong("Song title")
    }

}