package com.example.newsly

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide


class MyAdapter(val context: Context, val articles: List<Article>) : Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article : Article= articles[position]
        holder.newsTitle.text=article.title
        holder.newsDesc.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)


        holder.itemView.setOnClickListener{
            val intent =Intent(context,full_News::class.java)
            intent.putExtra("URL",article.url)
            context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDesc = itemView.findViewById<TextView>(R.id.newsDesc)

    }
}