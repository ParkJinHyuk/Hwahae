package com.example.hwahae.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hwahae.R
import com.example.hwahae.model.Cosmetics
import com.example.hwahae.model.CosmeticsList

class MainAdapter(val context: Context, val cosmeticsList: CosmeticsList): RecyclerView.Adapter<MainAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.cosmetics, parent, false)
        return Holder(view)
    }
    override fun getItemCount(): Int {
        return cosmeticsList.body.size;
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(cosmeticsList.body[position], context)
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cosmeticsImage = itemView.findViewById<ImageView>(R.id.iv_image)
        val cosmeticsTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val cosmeticsPrice = itemView.findViewById<TextView>(R.id.tv_price)

        fun bind(cosmetics: Cosmetics, context: Context) {
            Glide.with(itemView)
                .asBitmap().load(cosmetics.thumbnail_image)
                .into(cosmeticsImage)
            cosmeticsTitle.text= cosmetics.title
            cosmeticsPrice.text = (cosmetics.price).toString()
        }
    }
}