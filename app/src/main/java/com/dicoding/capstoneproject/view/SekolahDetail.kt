@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection")

package com.dicoding.capstoneproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.dicoding.capstoneproject.R
import com.dicoding.capstoneproject.Sekolah
import kotlinx.android.synthetic.main.activity_detail_kamus.text_detail_image
import kotlinx.android.synthetic.main.content_detail_kamus.*
import java.lang.StringBuilder

class SekolahDetail : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_detail)
        //setup toolbar

        val detailSekolah = intent.getParcelableExtra<Sekolah>(EXTRA_DATA)
        showDetailKamus(detailSekolah)
    }

    private fun showDetailKamus(detailSekolah: Sekolah?) {
        detailSekolah?.let {
            supportActionBar?.title = detailSekolah.name
            tv_detail_description.text = StringBuilder("Alamat Sekolah : ").append(detailSekolah.address)
            text_detail_image.setImageResource(detailSekolah.image)
        }
    }
    //setup Toolbar
    private fun setupToolbar() {
        supportActionBar?.apply {
            this.setDisplayHomeAsUpEnabled(true)
            this.setDisplayShowHomeEnabled(true)
        }
    }

    //Handler Toolbar Menu
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}