package com.simakmu.simakmu.ui.transaksi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simakmu.simakmu.data.responses.Menu
import com.simakmu.simakmu.databinding.MenuItemBinding

class TransaksiAdapter(
    private val callBack: (name: String) -> Unit
) : RecyclerView.Adapter<TransaksiAdapter.ViewHolder>() {

    private val list = listOf(
        Menu("1", "Jurnal Transaksi"),
        Menu("2", "Persediaan Stok"),
        Menu("3", "Depresiasi / Amortisasi"),
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