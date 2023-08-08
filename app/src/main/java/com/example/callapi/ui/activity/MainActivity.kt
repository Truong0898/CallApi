package com.example.callapi.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callapi.databinding.ActitvityMainBinding
import com.example.callapi.ui.adapter.adapter.AdapterAPI
import com.example.callapi.utils.Status
import com.example.callapi.viewmodel.ViewModelAPI
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val apiViewModelAPI: ViewModelAPI by viewModel()
    private lateinit var binding: ActitvityMainBinding
    private lateinit var adapterAPI: AdapterAPI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActitvityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.reverseLayout = false

        binding.rcvListAPI.setHasFixedSize(true)
        binding.rcvListAPI.layoutManager = linearLayoutManager
        adapterAPI = AdapterAPI(arrayListOf())
        binding.rcvListAPI.adapter = adapterAPI

        apiViewModelAPI.getAPI.observe(this, Observer {
            it?.let {apiResource ->
                when (apiResource.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rcvListAPI.visibility = View.VISIBLE
                        Log.i("API Result Count", apiResource.data?.count.toString())
                        apiResource.data?.let { it1 ->
                            adapterAPI.apply {
                                setLsEntries(it1.entries)
                                notifyDataSetChanged()
                            }
                        }
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rcvListAPI.visibility = View.VISIBLE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.rcvListAPI.visibility = View.GONE
                    }
                }
            }

        })
    }
}

