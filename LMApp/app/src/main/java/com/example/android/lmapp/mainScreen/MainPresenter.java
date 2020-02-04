package com.example.android.lmapp.mainScreen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    void WebViewBtnClicked(){
        getViewState().navigateToLoadingActivity();
    }
    void MonkeyTreasureBtnClicked(){
        getViewState().navigateToMonkeyTreasure();
    }
}
