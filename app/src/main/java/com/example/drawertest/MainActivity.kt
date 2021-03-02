package com.example.drawertest

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.drawertest.databinding.ActivityMainBinding
import com.example.drawertest.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    private val category = arrayOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "A",
        "B",
        "C",
        "D",
        "E",
        "A",
        "B",
        "C",
        "D",
        "E",
        "A",
        "B",
        "C",
        "D",
        "E"
    ) //カテゴリを定義
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //MainFragment
        val mainFragmentFirst = MainFragment("最初の画面です")
        //FrameLayout(R.id.mainContent)にFragmentを表示する
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainContent, mainFragmentFirst)
            .commit()

        //navigation drawer
        binding.imageMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        //istView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, category)
        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            //ListViewのitemを取得する
            val item = (view.findViewById<TextView>(android.R.id.text1)).text.toString()
            //MainFragment
            val mainFragment = MainFragment(item)
            //FrameLayout(R.id.mainContent)にFragmentを表示する
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContent, mainFragment)
                .commit()
        }
    }
}