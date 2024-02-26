package com.sample.watch

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import com.sample.watch.api.ClientApi
import com.sample.watch.model.Item

private const val TAG = "SearchActivity"
class SearchActivity : AppCompatActivity() {
    private lateinit var list: List<Item>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SearchAdapter
    private lateinit var noMoviesTextView: TextView
    private lateinit var progressBar: ProgressBar
    private var query = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recyclerView = findViewById(R.id.recyclerView)
        //noMoviesTextView = findViewById(R.id.no_movies_textview)
        //progressBar = findViewById(R.id.progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SearchAdapter(emptyList())
        recyclerView.adapter = adapter

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val clientApi: ClientApi = retrofit.create<ClientApi>(ClientApi::class.java)

        lifecycleScope.launch {
                val response = clientApi.fetchResponse()
                list = response.items?: emptyList()
                recyclerView.adapter = SearchAdapter(list)
                //Log.d(TAG, "Response received: $response")
        }
    }
}