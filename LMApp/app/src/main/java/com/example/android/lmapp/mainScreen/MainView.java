package com.example.android.lmapp.mainScreen;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void navigateToLoadingActivity();
    @StateStrategyType(SkipStrategy.class)
    void navigateToMonkeyTreasure();
}
