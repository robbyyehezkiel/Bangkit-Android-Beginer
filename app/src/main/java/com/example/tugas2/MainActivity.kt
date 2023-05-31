package com.example.tugas2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvArtikels: RecyclerView
    private val list = ArrayList<Artikel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Halaman Utama"

        rvArtikels = findViewById(R.id.rv_artikels)
        rvArtikels.setHasFixedSize(true)
        list.addAll(getListArtikels())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListArtikels(): ArrayList<Artikel> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPublish = resources.getStringArray(R.array.data_publish)
        val dataWriter = resources.getStringArray(R.array.data_writer)
        val listArtikel = ArrayList<Artikel>()
        for (i in dataName.indices) {
            val artikel = Artikel(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataPublish[i], dataWriter[i])
            listArtikel.add(artikel)
        }
        return listArtikel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page ->{
                this.startActivity(Intent(this,AboutPage::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvArtikels.layoutManager = LinearLayoutManager(this)
        val listArtikelAdapter = ListArtikelAdapter(list)
        rvArtikels.adapter = listArtikelAdapter
        listArtikelAdapter.setOnItemClickCallback(object : ListArtikelAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Artikel) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }
}
