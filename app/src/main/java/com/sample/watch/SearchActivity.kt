package com.sample.watch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.watch.databinding.ActivitySearchBinding
import com.sample.watch.api.ClientApi
import com.sample.watch.model.Item
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "SearchActivity"
class SearchActivity : AppCompatActivity() {
    private lateinit var list: List<Item>
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
            // GridLayoutManager(this, 2)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val clientApi: ClientApi = retrofit.create<ClientApi>(ClientApi::class.java)

        lifecycleScope.launch {
                val response = clientApi.fetchResponse()
                Log.d(TAG, "Response received: $response")
                list = response.items?: emptyList()
                binding.recyclerView.adapter = SearchAdapter(list)
        }
    }
}