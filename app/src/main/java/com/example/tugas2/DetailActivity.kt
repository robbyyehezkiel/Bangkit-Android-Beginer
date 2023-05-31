package com.example.tugas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Halaman Detail"
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        val data = intent.getParcelableExtra<Artikel>("DATA")
        Log.d("Detail Data", data?.name.toString())

        val imgPhoto = findViewById<ImageView>(R.id.img_item_photo)
        val tvName = findViewById<TextView>(R.id.tv_item_name)
        val tvDescription = findViewById<TextView>(R.id.tv_item_description)
        val tvPublish = findViewById<TextView>(R.id.tv_item_publish)
        val tvWriter = findViewById<TextView>(R.id.tv_item_writer)

        imgPhoto.setImageResource(data?.photo!!)
        tvName.text = data.name
        tvDescription.text = data.description
        tvPublish.text = data.publish
        tvWriter.text = data.writer
    }
}