package com.example.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)
        val url = intent.getStringExtra("url")
        getImagesUrl(url)
    }

    private fun getImagesUrl(url: String?) {
        val queue = Volley.newRequestQueue(this)

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            { response ->
                val url_list = List(response.length()) {
                    response.getString(it)
                }
                val imagesList = findViewById<ListView>(R.id.image_list)

                val listAdapter = ImagesAdapter(url_list)
                imagesList.adapter = listAdapter
            },
            {})
        queue.add(jsonArrayRequest)
    }
}