package com.example.downloadimage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL
import java.util.concurrent.ExecutorService

class ExecutionViewModel(private val executorService: ExecutorService) : ViewModel() {

    private val TAG = "Download"
    private val MOOD_URL = URL(
        "https://sun9-7.userapi.com/impg/7I7Iepv1qs91WHMCc5a16pR9c0tl2uyJVIulnw/dnqlc38WYsI.jpg?size=640x642&quality=96&sign=fa29f3ea252838887b29f958d674cbb1&type=album"
    )

    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()

    fun downloadImage() {
        executorService.execute {
            Log.i(TAG, "Connecting to DB...")
            Thread.sleep(1000)
            Log.i(TAG, "Get request...")
            Thread.sleep(1000)
            Log.i(TAG, "Downloading in ${Thread.currentThread()}")
            bitmap.postValue(BitmapFactory.decodeStream(MOOD_URL.openConnection().getInputStream()))
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



