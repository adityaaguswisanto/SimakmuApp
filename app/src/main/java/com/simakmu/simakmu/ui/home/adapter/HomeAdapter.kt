package com.simakmu.simakmu.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simakmu.simakmu.data.responses.Menu
import com.simakmu.simakmu.databinding.HomeItemBinding

class HomeAdapter(
    private val callBack: (name: String) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val list = listOf(
        Menu("1","Set Up"),
        Menu("2","Laporan Keuangan"),
        Menu("3","Laporan Iuran"),
        Menu("4","Transaksi"),
        Menu("5","Bukti Transaksi"),
        Menu("6","Analisa"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            HomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            txtTitle.setOnClickListener { callBack.invoke(item.id) }
            txtTitle.text = item.title
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val binding = HomeItemBinding.bind(view)
    }
}