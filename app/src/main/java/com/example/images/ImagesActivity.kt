package com.example.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)

        val passed_data = findViewById<TextView>(R.id.passed_data)
        passed_data.text = intent.getStringExtra("url")
    }
}