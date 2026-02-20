package com.mobileapp.lab3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobileapp.lab3.R
import com.mobileapp.lab3.model.Advice

class AdviceAdapter(
    private var adviceList: List<Advice>,
    private val onItemClick: (Advice) -> Unit
) : RecyclerView.Adapter<AdviceViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdviceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_advice, parent, false)

        return AdviceViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AdviceViewHolder,
        position: Int
    ) {
        val advice = adviceList[position]
        holder.bind(advice, onItemClick)
    }

    override fun getItemCount(): Int = adviceList.size
}