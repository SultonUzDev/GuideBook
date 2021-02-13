package com.uzdev.guidebook.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.uzdev.alichtechtask.api.RetrofitInstance.Companion.BASE_URL
import com.uzdev.guidebook.R
import com.uzdev.guidebook.databinding.FragmentWebBinding


class WebFragment : Fragment(R.layout.fragment_web) {
    private lateinit var binding: FragmentWebBinding
    private val args by navArgs<WebFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWebBinding.bind(view)
        val link = BASE_URL + args.data.url
        Log.d("link", link)



        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progrssBar.visibility = View.GONE
                    binding.webView.visibility = View.VISIBLE
                }
            }
            loadUrl(link)


        }
    }

}