package com.example.android.lmapp.webScreen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
@InjectViewState
public class WebScreenPresenter extends MvpPresenter<WebScreenView> {
    void compareBtnClicked(){
        getViewState().showWebView();
    }
    void exitWebView(){
        getViewState().hideWebView();
    }
}
