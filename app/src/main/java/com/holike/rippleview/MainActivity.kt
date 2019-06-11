package com.holike.rippleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0 until 50) {
            list.add("ripple effect test item "+(i + 1))
        }
        mRecyclerView.adapter = ItemAdapter()
    }

    private inner class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            holder.mItemTextView.text = list[position]
        }

        override fun getItemCount(): Int = list.size

        override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemHolder {
            return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ripple, parent, false))
        }


        inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val mItemTextView: TextView = itemView.findViewById(R.id.mItemTextView)
        }
    }
}
