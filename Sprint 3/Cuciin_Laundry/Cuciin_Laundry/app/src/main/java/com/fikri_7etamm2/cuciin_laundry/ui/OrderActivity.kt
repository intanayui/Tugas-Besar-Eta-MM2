package com.fikri_7etamm2.cuciin_laundry.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fikri_7etamm2.cuciin_laundry.R
import com.fikri_7etamm2.cuciin_laundry.model.Order
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val spinner: Spinner = findViewById(R.id.spinner_layanan)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.pil_layanan,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this

        bt_pesan.setOnClickListener {
            if(t_jumlah.text.trim().isEmpty() || t_catatan.text.trim().isEmpty()){
                Toast.makeText(this,"Pastikan semua input dalam keadaan terisi", Toast.LENGTH_LONG).show()
            }else{
                val listOrder = ArrayList<Order>()
                val order = Order(
                    pilihan = spinner.selectedItem.toString(),
                    biaya = t_biaya.text.toString(),
                    detail = t_detail.text.toString(),
                    jumlah = t_jumlah.text.trim().toString(),
                    catatan = t_catatan.text.trim().toString()
                )
                listOrder.add(order)
                val j = Intent(this, HistoryOrderActivity::class.java)
                j.putParcelableArrayListExtra(HistoryOrderActivity.EXTRA_ORDER, listOrder)
                startActivity(j)
                Log.e("testCLick", listOrder.toString())
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Log.e("testCLick", p0.toString())
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p2) {
            0 -> {
                t_detail.text = "Cuci bagian luar dalam +- 3 hari"
                t_biaya.text = "Rp 25.000,-"
            }
            1 -> {
                t_detail.text = "Cuci bagian luar +- 3 hari"
                t_biaya.text = "Rp 20.000,-"
            }
            else -> {
                t_detail.text = "Cuci bagian luar dalam & parfum +- 3 hari"
                t_biaya.text = "Rp 35.000,-"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}