package com.example.callapi.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.callapi.data.entity.Entry
import com.example.callapi.databinding.ItemRecycleBinding

class HolderAPI(private val binding: ItemRecycleBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(entry: Entry) {
        binding.txtAPIName.text = entry.API
        binding.txtAuth.text = entry.Auth
        binding.txtDescription.text = entry.Description
        binding.txtCors.text = entry.Cors
        binding.txtHttps.text = entry.HTTPS.toString()
        binding.txtCategory.text = entry.Category
        binding.txtLink.text = entry.Link
    }
}