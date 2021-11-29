package com.example.downloadimage

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception
import java.net.URL

class PicassoViewModel : ViewModel() {

    private val TAG = "Download"
    private val MOOD_URL = URL(
        "https://sun9-7.userapi.com/impg/7I7Iepv1qs91WHMCc5a16pR9c0tl2uyJVIulnw/dnqlc38WYsI.jpg?size=640x642&quality=96&sign=fa29f3ea252838887b29f958d674cbb1&type=album"
    )

    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()


    fun downloadImage() {
        Picasso.get().load(MOOD_URL.toString()).into(
            object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    Log.i(TAG, "Loaded image")
                    this@PicassoViewModel.bitmap.postValue(bitmap)
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    Log.i(TAG, "Load image failed")
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    Log.i(TAG, "Prepare load image")
                }
            }
        )
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



