package com.mobileapp.lab3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DAY_NUMBER = "day_number"
        const val TITLE_ID = "title_id"
        const val FULL_DESCRIPTION_ID = "full_description_id"
        const val IMAGE_ID = "image_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dayNumber = intent.getIntExtra(DAY_NUMBER, 0)
        val titleId = intent.getIntExtra(TITLE_ID, 0)
        val fullDescriptionId = intent.getIntExtra(FULL_DESCRIPTION_ID, 0)
        val imageId = intent.getIntExtra(IMAGE_ID, 0)

        val textDayNumber = findViewById<TextView>(R.id.textDetailDayNumber)
        val textTitle = findViewById<TextView>(R.id.textDetailTitle)
        val textFullDescription = findViewById<TextView>(R.id.textDetailFullDescription)
        val image = findViewById<ImageView>(R.id.detailImage)

        textDayNumber.text = getString(R.string.day_format, dayNumber)
        textTitle.text = getString(titleId)
        textFullDescription.text = getString(fullDescriptionId)
        image.setImageResource(imageId)
    }
}