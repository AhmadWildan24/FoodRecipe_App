package com.sutrii.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.sutrii.home.recyclerdata.RecyclerData

class AdapterSemua(
    private val getActivity: MainActivity,
    private val list_item: List<RecyclerData>
) :
    RecyclerView.Adapter<AdapterSemua.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_semua, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list_item.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ItemName.text = list_item[position].name
        holder.ItemImage.setImageResource(list_item[position].imageResource)
        holder.favIcon.setImageResource(list_item[position].favicon)
        holder.bookmarkIcon.setImageResource(list_item[position].bookmarkIcon)

        holder.cardView.setOnClickListener {
            Toast.makeText(getActivity, list_item[position].name, Toast.LENGTH_LONG).show()
        }
    }

    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ItemName: TextView = itemView.findViewById(R.id.cook_name)
        val ItemImage: ImageView = itemView.findViewById(R.id.cook_image)
        val cardView: CardView = itemView.findViewById(R.id.cv_semua)
        val favIcon: ImageView = itemView.findViewById(R.id.fav_btn)
        val bookmarkIcon: ImageView = itemView.findViewById(R.id.bm_btn)
    }
}