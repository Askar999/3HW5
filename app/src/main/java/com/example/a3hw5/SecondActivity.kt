package com.example.a3hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a3hw5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.firstEdit.setText(intent.getStringExtra("key"))

        binding.nextOne.setOnClickListener {
            if (binding.firstEdit.text.isNotEmpty()) {
                setResult(RESULT_OK, Intent().putExtra("keyTwo", binding.firstEdit.text.toString()))
                finish()
            } else {
                Toast.makeText(this, "Edit text!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}