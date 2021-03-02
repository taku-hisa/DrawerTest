package com.example.drawertest

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.view.GravityCompat
import com.example.drawertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val category = arrayOf("A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E") //カテゴリを定義
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //navigation drawer
        binding.imageMenu.setOnClickListener{
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        //listView
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1 , category)
        binding.listView.adapter = adapter

    }
}