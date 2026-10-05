package com.example.Akbar_3tib.pertemuan5

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.Akbar_3tib.R
import com.google.android.material.appbar.MaterialToolbar

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_web_view)

        toolbar = findViewById(R.id.webToolbar)
        webView = findViewById(R.id.webView)

        // Toolbar
        toolbar.title = "WebView"
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        // Pengaturan WebView
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(
                view: WebView?,
                url: String?
            ) {
                super.onPageFinished(view, url)

                // Mengambil judul halaman website
                val pageTitle = view?.title

                if (!pageTitle.isNullOrEmpty()) {
                    toolbar.title = pageTitle
                }
            }
        }

        webView.webChromeClient = WebChromeClient()

        // Website awal
        webView.loadUrl("https://www.google.com")

        // Tombol Back Android / Gesture
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {

                override fun handleOnBackPressed() {

                    if (webView.canGoBack()) {
                        webView.goBack()
                    } else {
                        finish()
                    }
                }
            }
        )
    }
}