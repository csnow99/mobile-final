package com.example.a38_recommendify

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(val activity: Activity, private val songs: List<String>) :

    RecyclerView.Adapter<SongAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_number, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songs[position]
        val artist = "Artist name"
        holder.bind(song, artist)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val song: TextView
        private val artist: TextView
        private val recommend: Button
        private val image: ImageView

        fun bind(songTitle: String, artistName: String) {
            song.text = songTitle
            artist.text = artistName
            recommend.setOnClickListener {
                //do recommend shit
            }

        }

        init {
            song = itemView.findViewById(R.id.song_title)
            artist = itemView.findViewById(R.id.artist_title)
            recommend = itemView.findViewById(R.id.recommend)
            image = itemView.findViewById(R.id.album_cover)
        }
    }
}
