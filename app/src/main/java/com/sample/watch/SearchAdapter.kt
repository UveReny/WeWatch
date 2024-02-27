package com.sample.watch

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso
import com.sample.watch.model.Item

const val SEARCH_QUERY = "searchQuery"
const val EXTRA_TITLE = "SearchActivity.TITLE_REPLY"
const val EXTRA_RELEASE_DATE = "SearchActivity.RELEASE_DATE_REPLY"
const val EXTRA_POSTER_PATH = "SearchActivity.POSTER_PATH_REPLY"
private const val TAG = "SearchHolder"
class SearchHolder(view: View)
    : RecyclerView.ViewHolder(view), View.OnClickListener {
    private lateinit var item: Item
    var titleTextView: TextView = view.findViewById(R.id.title_textview)
    var overviewTextView: TextView = view.findViewById(R.id.overview_textview)
    var releaseDateTextView: TextView = view.findViewById(R.id.release_date_textview)
    var imageView: ImageView = view.findViewById(R.id.movie_imageview)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: Item) {
        this.item = item
        this.item.apply {
            titleTextView.text = title
            releaseDateTextView.text = releaseDate
            overviewTextView.text = overview

            if (posterPath != "N/A") {
                Picasso.get().load(posterPath).into(imageView)
            }
        }
    }

    override fun onClick(v: View?) {
        Toast.makeText(imageView.context,
            "Click ${item.releaseDate}",
            Toast.LENGTH_LONG)
            .show()

        /*
        val pos = v. .adapterPosition
        Log.d(TAG, "Click ${item.overview}")
        val movie = movies[pos]
        val intent = Intent(SearchActivity, AddActivity::class.java)
        intent.putExtra(EXTRA_TITLE, movie.title)
        intent.putExtra(EXTRA_RELEASE_DATE, movie.getReleaseYearFromDate())
        intent.putExtra(EXTRA_POSTER_PATH, movie.posterPath)
        startActivity(intent)*/
    }
}

class SearchAdapter(var list: List<Item>): RecyclerView.Adapter<SearchHolder>() {
    val movies = list

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_details, parent, false)
        val viewHolder = SearchHolder(view)

        //view.setOnClickListener { v -> listener.onItemClick(v, viewHolder.adapterPosition) }
            //finish()
        return viewHolder
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getItemAtPosition(pos: Int): Item {
        return list[pos]
    }
}