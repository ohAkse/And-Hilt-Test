package com.example.hiltpractice.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.hiltpractice.R
import com.example.hiltpractice.viewModels.AppActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


@AndroidEntryPoint
class AppActivity : AppCompatActivity() {

    private val viewModel: AppActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewRepository = findViewById<TextView>(R.id.textViewRepository)
        val textViewNetwork = findViewById<TextView>(R.id.textViewNetwork)
        val textViewFile = findViewById<TextView>(R.id.textViewFile)
        val buttonFetch = findViewById<Button>(R.id.buttonFetch)

        viewModel.repositoryData.observe(this) { data ->
            textViewRepository.text = "Repository: $data"
        }

        viewModel.networkData.observe(this) { data ->
            textViewNetwork.text = "Network: $data"
        }

        viewModel.fileData.observe(this) { data ->
            textViewFile.text = "File: $data"
        }

        buttonFetch.setOnClickListener {
            viewModel.fetchData()
            showToast()
        }
    }
    
    private fun showToast() {
        val message = "Repository: ${viewModel.repositoryData.value}\n" +
                "Network: ${viewModel.networkData.value}\n" +
                "File: ${viewModel.fileData.value}"
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}