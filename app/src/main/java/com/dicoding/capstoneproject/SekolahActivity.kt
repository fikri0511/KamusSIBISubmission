package com.dicoding.capstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.capstoneproject.databinding.ActivitySekolahBinding
import com.dicoding.capstoneproject.view.SekolahDetail
import com.dicoding.core.utils.AdapterUtil
import kotlinx.android.synthetic.main.item_list_sekolah.view.*

class SekolahActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySekolahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySekolahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup toolbar
        setupToolbar()

        binding.rvKamus.adapter = AdapterUtil(R.layout.item_list_sekolah,listSekolah,{ _, itemView, item ->
            itemView.tv_item_title.text= item.name
            itemView.tv_item_subtitle.text= item.address
            itemView.tv_item_subtitle.text= item.address
            itemView.iv_item_image.setImageResource(item.image)
        },{_,item ->
            val intent = Intent(this, SekolahDetail::class.java)
            intent.putExtra(SekolahDetail.EXTRA_DATA, item)
            startActivity(intent)
        })
        binding.rvKamus.layoutManager=LinearLayoutManager(this)

    }


    private var listSekolah = listOf(
        Sekolah("SLB Negeri Cicendo Kota Bandung","Jl. Cicendo No.2, Babakan Ciamis, Kec. Sumur Bandung, Kota Bandung, Jawa Barat 40117",-6.910926,107.604730,
            R.drawable.cicendo),
        Sekolah("Sekolah Luar Biasa - Tuna Grahita Karya Ibu"," Jl. Sosial No.510, Ario Kemuning, Kec. Sukarami, Kota Palembang, Sumatera Selatan 30151",-2.949630,104.738618,
            R.drawable.karyaibu),
        Sekolah("SLB Negeri  7 Jakarta"," Jl. Griya Wartawan, RT.8/RW.5, Cipinang Besar Sel., Kecamatan Jatinegara, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13410",-6.232527,106.882938,
            R.drawable.tujuhjakarta),
        Sekolah("SLB Yakut Tuna Rungu"," Jl. Kolonel Sugiri No.10, Brubahan, Kranji, Kec. Purwokerto Tim., Kabupaten Banyumas, Jawa Tengah 53116",-7.424970,109.235170,
            R.drawable.yakut)
    )

    //setup Toolbar
    private fun setupToolbar() {
        supportActionBar?.apply {
            this.title = "Sekolah Tuna Rungu"
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