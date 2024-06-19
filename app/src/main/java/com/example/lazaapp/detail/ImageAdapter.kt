package com.example.lazaapp.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lazaapp.databinding.ItemPagerImageBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val imageList = arrayListOf<String>()

    inner class ImageViewHolder(val itemPagerImageBinding: ItemPagerImageBinding) :
        RecyclerView.ViewHolder(itemPagerImageBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = ItemPagerImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = imageList[position]
        holder.itemPagerImageBinding.image = item
    }

    fun updateList(newList:List<String>){
        imageList.clear()
        imageList.addAll(newList)
        notifyDataSetChanged()
    }

}