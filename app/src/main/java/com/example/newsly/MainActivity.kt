package com.example.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
   

    private var article= mutableListOf<Article>()
    lateinit var newsList:RecyclerView
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsList=findViewById<RecyclerView>(R.id.newsList)

        //val name = findViewById<Button>(R.id.inputName)
        adapter = MyAdapter(this@MainActivity, article)
        newsList.adapter=adapter
        newsList.layoutManager=LinearLayoutManager(this@MainActivity)


        getNews()
    }

    private fun getNews() {
        val news: Call<News> = NewsService.NewsInstance.getHeadlines("in", 1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null)
                    Log.d("sahil", news.toString())
                if (news != null) {
                    article.addAll(news.articles)
                    adapter.notifyDataSetChanged()
                }


            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("sahil", "error in fetching news", t)
            }
        })
    }
}