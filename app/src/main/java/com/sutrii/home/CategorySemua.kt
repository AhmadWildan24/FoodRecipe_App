package com.sutrii.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sutrii.home.recyclerdata.RecyclerData

class CategorySemua : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterSemua

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category_semua, container, false)

        recyclerView = view.findViewById(R.id.recycler_semua)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false) // Set the number of columns here

        // Sample data, replace it with your actual data
        val dataList = listOf(
            RecyclerData(R.drawable.semua_1, "Rendang Sapi Khas Tanah Minang", "Oleh Bu Susi", R.drawable.ic_fav, R.drawable.bookmark_outline_ic),
            RecyclerData(R.drawable.semua_2, "Ayam Bakar Saus Tomat", "Oleh Pak Tejo", R.drawable.ic_fav, R.drawable.bookmark_outline_ic),
            // Add more items as needed
        )

        adapter = AdapterSemua(requireActivity() as MainActivity, dataList)
        recyclerView.adapter = adapter

        return view
    }
}