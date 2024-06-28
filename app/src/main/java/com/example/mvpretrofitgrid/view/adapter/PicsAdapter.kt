package com.example.mvpretrofitgrid.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mvpretrofitgrid.R
import com.example.mvpretrofitgrid.model.DataItem

class PicsAdapter(private val context: Context)
    :RecyclerView.Adapter<PicsAdapter.PicsViewHolder>() {

     private var picsList = mutableListOf<DataItem>()

    fun setList(list: List<DataItem>)
    {
        picsList.clear()
        picsList.addAll(list)
        notifyDataSetChanged()

    }


    class PicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rvImage :ImageView = itemView.findViewById(R.id.rvImage)
        val idImage :TextView = itemView.findViewById(R.id.idImage)
        val authorImage: TextView = itemView.findViewById(R.id.authorImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  PicsViewHolder (
        LayoutInflater.
        from(parent.context).inflate(R.layout.item_pics,parent,false)

    )

    override fun getItemCount() =  picsList.size

    override fun onBindViewHolder(holder: PicsViewHolder, position: Int) {

        val picItem = picsList[position]
        holder.apply {
           rvImage.load(picItem.download_url)
           idImage.text = picItem.id
           authorImage.text = picItem.author

        }

    }

}

