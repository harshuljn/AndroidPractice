package com.example.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.w3c.dom.Text
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

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
            },
            {})

        queue.add(jsonArrayRequest)
    }
}
