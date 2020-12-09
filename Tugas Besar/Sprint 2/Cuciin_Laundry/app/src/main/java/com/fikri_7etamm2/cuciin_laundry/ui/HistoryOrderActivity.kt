package com.fikri_7etamm2.cuciin_laundry.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.fikri_7etamm2.cuciin_laundry.R
import com.fikri_7etamm2.cuciin_laundry.adapter.HistoryOrderAdapter
import com.fikri_7etamm2.cuciin_laundry.model.Order
import kotlinx.android.synthetic.main.activity_history_order.*

class HistoryOrderActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ORDER = "extra_order"
    }
    private lateinit var listDataOrder : ArrayList<Order>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_order)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<Toolbar>(R.id.toolbar).title = title
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        listDataOrder = intent.getParcelableArrayListExtra(EXTRA_ORDER)!!
        Log.e("click list", listDataOrder.toString())
        rv_mydata.setHasFixedSize(true)
        showRecyclerView()
    }

    private fun showRecyclerView(){
        rv_mydata.layoutManager = LinearLayoutManager(this)
        val listHistoryOrderAdapter = HistoryOrderAdapter(listDataOrder){ data : Order -> itemOrderClick(data)}
        rv_mydata.adapter = listHistoryOrderAdapter
    }

    private fun itemOrderClick(data: Order) {
        val j = Intent(this, DetailOrderActivity::class.java)
        j.putExtra(DetailOrderActivity.EXTRA_ORDER, data)
        startActivity(j)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}