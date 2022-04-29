package com.example.a3hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a3hw5.databinding.ActivityMainBinding
import android.app.Activity
import androidx.activity.result.ActivityResult

import androidx.activity.result.ActivityResultCallback

import androidx.activity.result.contract.ActivityResultContracts

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult


class MainActivity : AppCompatActivity() {


    private var launchForResult = registerForActivityResult(
        ActivityResultContracts
            .StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val text = result.data?.getStringExtra("keyTwo")
            binding.firstEdit.setText(text)
        }
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nextOne.setOnClickListener {
            if (binding.firstEdit.text.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("key", binding.firstEdit.text.toString())
                launchForResult.launch(intent)
            } else {
                Toast.makeText(this, "Edit text!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}