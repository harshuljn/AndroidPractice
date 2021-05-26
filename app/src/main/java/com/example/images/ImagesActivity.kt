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
//        val textView = findViewById<TextView>(R.id.passed_data)
        val queue = Volley.newRequestQueue(this)

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            { response ->
                val url_list = List(response.length()) {
                    response.getString(it)
                }
                val imagesList = findViewById<ListView>(R.id.image_list)
                val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, url_list)
                imagesList.adapter = listAdapter

                val testImageView = findViewById<ImageView>(R.id.testImageView)
                Glide.with(this).load(url_list[0])
                    .into(testImageView);
            },
            {})

        queue.add(jsonArrayRequest)
    }
}
