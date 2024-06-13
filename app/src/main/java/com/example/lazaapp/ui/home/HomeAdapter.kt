package com.example.lazaapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lazaapp.databinding.ItemBrandBinding
import com.example.lazaapp.model.BrandModel

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val brandList = arrayListOf<BrandModel>()

    inner class HomeViewHolder(val itemBinding: ItemBrandBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = ItemBrandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return brandList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val brand = brandList[position]
        holder.itemBinding.brand = brand
    }

    fun updateList(newList: List<BrandModel>) {
        brandList.clear()
        brandList.addAll(newList)
        notifyDataSetChanged()
    }
}