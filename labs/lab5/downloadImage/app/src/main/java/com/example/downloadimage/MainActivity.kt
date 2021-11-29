package com.example.downloadimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.downloadimage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mainViewModel: ExecutionViewModel by viewModels()
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