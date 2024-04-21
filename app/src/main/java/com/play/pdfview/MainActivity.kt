package com.play.pdfview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.play.pdfview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener {
            launcher.launch("application/pdf")

        }

    }

    private val launcher= registerForActivityResult(
        ActivityResultContracts.GetContent()
    ){
        uri ->uri?.let{
            binding.pdfViewer.fromUri(it).load()
    }
    }
}