package com.example.progettoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class Statistics extends AppCompatActivity {

    ImageView back;
    WebView sito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        back = findViewById(R.id.imageView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Statistics.this, HomeActivity.class);
                startActivity(i);
                finish();

            }
        });

        sito = (WebView) findViewById(R.id.webView);
        sito.setWebViewClient(new WebViewClient());
        sito.loadUrl("https://opendatadpc.maps.arcgis.com/apps/dashboards/dae18c330e8e4093bb090ab0aa2b4892");

        WebSettings webSettings = sito.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (sito.canGoBack()) {
            sito.goBack();
        } else {
            super.onBackPressed();
        }
    }
}


