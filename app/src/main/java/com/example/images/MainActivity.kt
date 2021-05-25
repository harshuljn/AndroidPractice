package com.example.images

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val showOptionButton = findViewById<Button>(R.id.show_options_button)
        showOptionButton.setOnClickListener{showImages()}
    }
    private fun showImages() {
        val imagesActivity = Intent(this, ImagesActivity::class.java)
        imagesActivity.putExtra("url", getString(R.string.url))
        startActivity(imagesActivity)
    }
}