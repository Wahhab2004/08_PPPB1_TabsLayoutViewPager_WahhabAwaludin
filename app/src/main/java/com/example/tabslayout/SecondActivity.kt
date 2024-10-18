package com.example.tabslayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tabslayout.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
   private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_NAME) ?: "username kosong"
        binding.usernameView.text = "Welcome $username"

    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PASSWORD = "extra_password"
    }

}