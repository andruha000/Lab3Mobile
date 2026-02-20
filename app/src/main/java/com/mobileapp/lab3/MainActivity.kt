package com.mobileapp.lab3

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobileapp.lab3.adapter.AdviceAdapter
import com.mobileapp.lab3.data.AdviceData

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adviceList = AdviceData.getAdviceList()

        val orientation = resources.configuration.orientation

        val layoutManager = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        } else {
            LinearLayoutManager(this)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rvAdviceList)
        recyclerView.layoutManager = layoutManager

        val adapter = AdviceAdapter(adviceList) { advice ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.DAY_NUMBER, advice.dayNumber)
                putExtra(DetailActivity.TITLE_ID, advice.titleId)
                putExtra(DetailActivity.FULL_DESCRIPTION_ID, advice.fullDescriptionId)
                putExtra(DetailActivity.IMAGE_ID, advice.imageId)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}