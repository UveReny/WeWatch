package com.sample.watch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso
import com.sample.watch.model.Item

class SearchHolder(view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var item: Item
    var titleTextView: TextView = view.findViewById(R.id.title_textview)
    var overviewTextView: TextView = view.findViewById(R.id.overview_textview)
    var releaseDateTextView: TextView = view.findViewById(R.id.release_date_textview)
    var imageView: ImageView = view.findViewById(R.id.movie_imageview)

    /*
        init {
          v.setOnClickListener { v: View ->
            listener.onItemClick(v, adapterPosition)
      }
    }*/
}

class SearchAdapter(var list: List<Item>): RecyclerView.Adapter<SearchHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_details, parent, false)
        val viewHolder = SearchHolder(view)
        //view.setOnClickListener { v -> listener.onItemClick(v, viewHolder.adapterPosition) }
        view.setOnClickListener {
            Toast.makeText(
                parent.context,
                "Click ${viewHolder.releaseDateTextView.text}",
                Toast.LENGTH_LONG)
                .show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.titleTextView.text = list[position].title
        holder.releaseDateTextView.text = list[position].releaseDate
        holder.overviewTextView.text = list[position].overview

        if (list[position].posterPath != "N/A") {
            Picasso.get().load(list[position].posterPath).into(holder.imageView)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getItemAtPosition(pos: Int): Item {
        return list[pos]
    }
}