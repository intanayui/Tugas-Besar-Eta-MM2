package com.fikri_7etamm2.cuciin_laundry.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fikri_7etamm2.cuciin_laundry.R
import com.fikri_7etamm2.cuciin_laundry.model.Order
import kotlinx.android.synthetic.main.item_history_order.view.*

class HistoryOrderAdapter(private val listDataOrder : ArrayList<Order>, private val listener : (Order)->Unit):RecyclerView.Adapter<HistoryOrderAdapter.ListViewHolder>() {
    inner class ListViewHolder(view: View):RecyclerView.ViewHolder(view) {
        fun bind(order: Order) {
            with(itemView){
                tv_item_name.text = order.pilihan
                tv_item_description.text = order.detail
                img_item_photo.background = ContextCompat.getDrawable(context, R.drawable.sepatu)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history_order, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listDataOrder.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener(listDataOrder[position]) }
        holder.bind(listDataOrder[position])
    }
}