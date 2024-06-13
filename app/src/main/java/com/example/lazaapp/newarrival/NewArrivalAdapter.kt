package com.example.lazaapp.newarrival

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lazaapp.databinding.NewArrivalBinding
import com.example.lazaapp.model.ProductResponse

class NewArrivalAdapter : RecyclerView.Adapter<NewArrivalAdapter.NewArrivalViewHolder>() {

    private val productList = ArrayList<ProductResponse>()
    lateinit var onClick: (id: String) -> Unit

    inner class NewArrivalViewHolder(val itemNewArrivalBinding: NewArrivalBinding) :
        RecyclerView.ViewHolder(itemNewArrivalBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewArrivalViewHolder {
        val view = NewArrivalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewArrivalViewHolder(view)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: NewArrivalViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.itemNewArrivalBinding.item = currentItem
        holder.itemNewArrivalBinding.clItemNewArrival.setOnClickListener {
            onClick(currentItem.id!!.toString())
        }
    }

    fun updateList(newList: List<ProductResponse>) {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
}