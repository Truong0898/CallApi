package com.example.callapi.ui.adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.callapi.data.entity.Entry
import com.example.callapi.databinding.ItemRecycleBinding
import com.example.callapi.ui.adapter.holder.HolderAPI

class AdapterAPI(private val lsEntries: ArrayList<Entry>) : RecyclerView.Adapter<HolderAPI>() {
    private lateinit var binding: ItemRecycleBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderAPI {
        binding = ItemRecycleBinding.inflate(
            LayoutInflater
                .from(parent.context)
            ,parent
            ,false)
        return HolderAPI(binding)
    }


    override fun getItemCount(): Int {
       return lsEntries.size
    }

    override fun onBindViewHolder(holderAPI: HolderAPI, position: Int) {
        holderAPI.bind(lsEntries[position])
    }

    fun setLsEntries(lsEntries: List<Entry>) {
        this.lsEntries.apply {
            clear()
            addAll(lsEntries)
        }
    }
}