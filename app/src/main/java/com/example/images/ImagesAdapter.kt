package com.example.images

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImagesAdapter(
//    private val context: Context,
    private val url_list: List<String>
) : BaseAdapter() {
//    private val inflater: LayoutInflater =
//        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return url_list.size
    }

    override fun getItem(p0: Int): Any {
        return url_list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.image_item, parent, false)

        Glide.with(parent.context).load(url_list[position])
            .into(rowView.findViewById(R.id.imageItemView));
        return rowView
    }
}