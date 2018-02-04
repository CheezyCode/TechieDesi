package com.cheezycode.techiedesi;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Toolbar toolbar;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        webview = (WebView) findViewById(R.id.detailView);

        setSupportActionBar(toolbar);
        webview.setVisibility(View.INVISIBLE);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Toast.makeText(DetailActivity.this, "Page Started Loading", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                webview.setVisibility(View.VISIBLE);
                Toast.makeText(DetailActivity.this, "Page Loaded", Toast.LENGTH_SHORT).show();
                String javaScript ="javascript:(function() { var a= document.getElementsByTagName('header');a[0].hidden='true';a=document.getElementsByClassName('page_body');a[0].style.padding='0px';})()";
                webview.loadUrl(javaScript);
            }
        });
        webview.loadUrl(getIntent().getStringExtra("url"));
    }
}















