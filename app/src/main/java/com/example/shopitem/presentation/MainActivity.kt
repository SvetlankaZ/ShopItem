package com.example.shopitem.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.shopitem.R


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.shopList.observe(this){
            Log.d("MainActivity", it.toString())
            if(count == 0){
                count += 1
                val item = it[0]
                viewModel.deleteShopItem(item)
            }
        }
    }


}