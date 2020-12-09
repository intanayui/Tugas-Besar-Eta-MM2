package com.fikri_7etamm2.cuciin_laundry.ui

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.fikri_7etamm2.cuciin_laundry.R
import com.fikri_7etamm2.cuciin_laundry.model.Order
import kotlinx.android.synthetic.main.content_scrolling.*

class DetailOrderActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ORDER = "extra_order"
    }
    private lateinit var dataOrder : Order
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_order)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        dataOrder = intent.getParcelableExtra(EXTRA_ORDER)!!
        t_biaya_detail.text = dataOrder.biaya
        t_detail_detail.text = dataOrder.detail
        t_catatan_detail.text = dataOrder.catatan
        t_jumlah_detail.text = dataOrder.jumlah
        t_pilihan_detail.text = dataOrder.pilihan
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}