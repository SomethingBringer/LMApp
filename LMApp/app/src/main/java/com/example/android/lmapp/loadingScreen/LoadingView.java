package com.example.android.lmapp.loadingScreen;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface LoadingView extends MvpView {
    @StateStrategyType(AddToEndStrategy.class)
    void showProgressBar();
    @StateStrategyType(AddToEndStrategy.class)
    void hideProgressBar();
    @StateStrategyType(SkipStrategy.class)
    void navigateToWebView(float value);
    @StateStrategyType(SkipStrategy.class)
    void showErrorToast(String error);

}
