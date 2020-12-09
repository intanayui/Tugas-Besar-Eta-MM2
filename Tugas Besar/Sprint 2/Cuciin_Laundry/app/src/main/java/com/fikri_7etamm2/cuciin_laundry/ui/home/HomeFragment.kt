package com.fikri_7etamm2.cuciin_laundry.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.fikri_7etamm2.cuciin_laundry.MapsActivity
import com.fikri_7etamm2.cuciin_laundry.R
import com.fikri_7etamm2.cuciin_laundry.ui.OrderActivity


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.sepatu_sekolah).setOnClickListener {
            Log.e("testCLick", "test")
            val j = Intent(this.context, OrderActivity::class.java)
            startActivity(j)
        }
        view.findViewById<ImageView>(R.id.sepatu_wanita).setOnClickListener {
            Log.e("testCLick", "test")
            val j = Intent(this.context, MapsActivity::class.java)
            startActivity(j)
        }

    }
}