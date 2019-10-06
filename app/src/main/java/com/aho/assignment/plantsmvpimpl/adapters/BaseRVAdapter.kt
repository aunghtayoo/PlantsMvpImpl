package com.aho.assignment.plantsmvpimpl.adapters

import androidx.recyclerview.widget.RecyclerView
import com.aho.assignment.plantsmvpimpl.views.viewholder.BaseViewHolder

abstract class BaseRVAdapter<VH : BaseViewHolder<T>, T> : RecyclerView.Adapter<VH>() {

    private var dataList: MutableList<T> = ArrayList()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setNewData(newData: MutableList<T>){
        dataList = newData
        notifyDataSetChanged()
    }

}