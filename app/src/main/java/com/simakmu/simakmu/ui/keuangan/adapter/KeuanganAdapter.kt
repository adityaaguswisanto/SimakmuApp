package com.simakmu.simakmu.ui.keuangan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simakmu.simakmu.data.responses.Menu
import com.simakmu.simakmu.databinding.MenuItemBinding

class KeuanganAdapter (
    private val callBack: (name: String) -> Unit
) : RecyclerView.Adapter<KeuanganAdapter.ViewHolder>() {

    private val list = listOf(
        Menu("1","Buku Besar"),
        Menu("2","Laporan Arus Kas"),
        Menu("3","Laporan Perubahan Aset"),
        Menu("4","Laporan Posisi Keuangan"),
        Menu("5","Laporan Keuangan Batasan"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            MenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            cl.setOnClickListener { callBack.invoke(item.id) }
            txtTitle.text = item.title
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val binding = MenuItemBinding.bind(view)
    }
}