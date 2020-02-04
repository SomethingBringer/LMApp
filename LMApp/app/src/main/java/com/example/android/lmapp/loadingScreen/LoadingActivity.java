package com.example.android.lmapp.loadingScreen;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.android.lmapp.R;
import com.example.android.lmapp.webScreen.WebScreenActivity;

public class LoadingActivity extends MvpAppCompatActivity implements LoadingView {
    @InjectPresenter
    LoadingPresenter loadingPresenter;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        progressBar = findViewById(R.id.progress_bar);
        loadingPresenter.fetchValue();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void navigateToWebView(float value) {
        Intent intent = new Intent(LoadingActivity.this, WebScreenActivity.class);
        intent.putExtra("VALUE_MESSAGE",String.valueOf(value));
        startActivity(intent);
    }

    @Override
    public void showErrorToast(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }
}
