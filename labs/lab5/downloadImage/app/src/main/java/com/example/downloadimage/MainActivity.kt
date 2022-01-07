package com.example.downloadimage

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.example.downloadimage.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private val executorService by lazy { (application as ExecutorServiceApplication).executor }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        //for Executor Realization
//        val factory = MyViewModelFactory(executorService)
//        val mainViewModel = ViewModelProvider(this, factory)
//            .get(ExecutionViewModel::class.java)

        //for other realizations
        val mainViewModel: CorutineViewModel by viewModels()

        binding.downloadButton.setOnClickListener {
            mainViewModel.downloadImage()
        }
        binding.resetButton.setOnClickListener {
            mainViewModel.clearImage()
        }
        mainViewModel.bitmap.observe(this) {
            binding.imageView.setImageBitmap(it)
        }

    }

}

class ExecutorServiceApplication : Application() {
    var executor: ExecutorService = Executors.newSingleThreadExecutor()
}

class MyViewModelFactory(private val executor: ExecutorService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ExecutorService::class.java).newInstance(executor)
    }

}