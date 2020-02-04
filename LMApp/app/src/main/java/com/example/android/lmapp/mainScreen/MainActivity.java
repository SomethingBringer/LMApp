package com.example.android.lmapp.mainScreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.android.lmapp.loadingScreen.LoadingActivity;
import com.example.android.lmapp.monkeyTreasureScreen.MonkeyTreasureActivity;
import com.example.android.lmapp.R;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @InjectPresenter
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button webViewButton = findViewById(R.id.WebViewBtn);
        Button monkeyTreasureButton = findViewById(R.id.MonkeyTreasureBtn);
        webViewButton.setOnClickListener(v ->
                mainPresenter.WebViewBtnClicked());
        monkeyTreasureButton.setOnClickListener(v ->
                mainPresenter.MonkeyTreasureBtnClicked());
    }

    @Override
    public void navigateToLoadingActivity() {
        Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToMonkeyTreasure() {
        Intent intent = new Intent(MainActivity.this, MonkeyTreasureActivity.class);
        startActivity(intent);
    }
}
