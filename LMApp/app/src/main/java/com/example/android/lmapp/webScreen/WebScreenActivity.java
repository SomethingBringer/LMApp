package com.example.android.lmapp.webScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.android.lmapp.R;
import com.example.android.lmapp.mainScreen.MainActivity;


public class WebScreenActivity extends MvpAppCompatActivity implements WebScreenView{
    @InjectPresenter
    WebScreenPresenter webScreenPresenter;
    String value;
    WebView webView;
    Button compareButton;
    String url = "https://www.banki.ru/products/currency/cash/moskva/";

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            webScreenPresenter.exitWebView();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(WebScreenActivity.this, MainActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        TextView valueView = findViewById(R.id.UsdValue);
        webView = findViewById(R.id.webView);
        compareButton = findViewById(R.id.compareBtn);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        value = getIntent().getStringExtra("VALUE_MESSAGE");
        valueView.setText(value);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        compareButton.setOnClickListener(v -> webScreenPresenter.compareBtnClicked());
    }

    @Override
    public void showWebView() {
        webView.setVisibility(View.VISIBLE);
        compareButton.setVisibility(View.GONE);
    }

    @Override
    public void hideWebView() {
        webView.setVisibility(View.GONE);
        compareButton.setVisibility(View.VISIBLE);
    }
}
