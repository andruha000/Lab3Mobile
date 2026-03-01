package com.mobileapp.lab3.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobileapp.lab3.R
import com.mobileapp.lab3.model.Advice

class AdviceViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    private val textDayNumber: TextView = item.findViewById(R.id.textDayNumber)
    private val textTitle: TextView = item.findViewById(R.id.textTitle)
    private val textShortDescription: TextView = item.findViewById(R.id.textShortDescription)
    private val image: ImageView = item.findViewById(R.id.image)

    fun bind(advice: Advice, clickListener: (Advice) -> Unit) {
        textDayNumber.text = itemView.context.getString(R.string.day_format, advice.dayNumber)
        textTitle.text = itemView.context.getString(advice.titleId)
        textShortDescription.text = itemView.context.getString(advice.shortDescriptionId)
        image.setImageResource(advice.imageId)

        itemView.setOnClickListener {
            clickListener(advice)
        }
    }
}