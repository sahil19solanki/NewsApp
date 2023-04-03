package com.example.newsly

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.core.view.isGone

class full_News : AppCompatActivity() {
    private var progressBar:ProgressBar?=null

    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_news)

        val url = intent.getStringExtra("URL")

        val fullNews = findViewById<WebView>(R.id.webV)

        if(url != null){
            fullNews.settings.javaScriptEnabled=true
            fullNews.webViewClient = object:WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)

                }
            }
            fullNews.loadUrl(url)
        }
    }




}