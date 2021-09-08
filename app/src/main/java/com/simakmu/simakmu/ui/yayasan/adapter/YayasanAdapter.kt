package com.simakmu.simakmu.ui.yayasan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simakmu.simakmu.data.responses.Menu
import com.simakmu.simakmu.databinding.MenuItemBinding

class YayasanAdapter (
    private val callBack: (name: String) -> Unit
) : RecyclerView.Adapter<YayasanAdapter.ViewHolder>() {

    private val list = listOf(
        Menu("1", "Data Yayasan Cabang"),
        Menu("2", "Data Yayasan Lembaga"),
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