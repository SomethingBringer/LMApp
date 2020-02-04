package com.example.android.lmapp.webScreen;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface WebScreenView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void showWebView();
    @StateStrategyType(AddToEndStrategy.class)
    void hideWebView();
}
