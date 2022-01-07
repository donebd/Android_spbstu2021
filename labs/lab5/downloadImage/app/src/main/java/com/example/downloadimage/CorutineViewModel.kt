package com.example.downloadimage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CorutineViewModel : ViewModel() {

    private val TAG = "Download"
    private val MOOD_URL = URL(
        "https://sun9-7.userapi.com/impg/7I7Iepv1qs91WHMCc5a16pR9c0tl2uyJVIulnw/dnqlc38WYsI.jpg?size=640x642&quality=96&sign=fa29f3ea252838887b29f958d674cbb1&type=album"
    )

    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()

    fun downloadImage() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i(TAG, "Connecting to DB...")
            delay(1000)
            Log.i(TAG, "Get request...")
            delay(1000)
            Log.i(TAG, "Downloading in ${Thread.currentThread()}")
            val pic = BitmapFactory.decodeStream(
                MOOD_URL.openConnection().getInputStream()
            )
            MainScope().launch {
                bitmap.value = pic
            }
        }
    }

    fun clearImage() {
        Log.i(TAG, "Clearing image")
        bitmap.value = null
    }

    override fun onCleared() {
        Log.i(TAG, "Clear ViewModel")
        super.onCleared()
    }

}



