package com.example.a38_recommendify

fun getSongList(): List<String> {

    val songs = ArrayList<String>()

    for (i in 1..20){
        songs.add("Song title")
    }

    return songs
}