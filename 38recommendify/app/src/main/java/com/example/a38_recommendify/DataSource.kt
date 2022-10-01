package com.example.a38_recommendify

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

private const val TAG = "DataSource"

class DataSource {
    private val initialChoiceList = com.example.a38_recommendify.getSongList()
    private val choicesLiveData = MutableLiveData(initialChoiceList)


    fun insertSong(song: String){
        addSong(song)
    }

    private fun addSong(song: String){
        //do a search here instead of adding nummber
        val currentList = choicesLiveData.value
        if (currentList == null){
            choicesLiveData.postValue(listOf(song))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, song)
            choicesLiveData.postValue(updatedList)
        }
    }

    fun getNumberList(): LiveData<List<String>> {
        return choicesLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}