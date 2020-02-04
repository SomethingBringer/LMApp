package com.example.android.lmapp.loadingScreen;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class LoadingPresenter extends MvpPresenter<LoadingView> {
    @Override
    public void attachView(LoadingView view) {
        super.attachView(view);
        getViewState().showProgressBar();
    }
    void fetchValue(){
        Call<DefaultResponse> searchRequest = RestApi.getInstance().dataEndpoint.search();
        searchRequest.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                checkResponse(response);
            }
            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Log.e("Request", "Request failed");
                getViewState().hideProgressBar();
                getViewState().showErrorToast("Request Failed");
            }
        });
    }
    private void checkResponse(Response<DefaultResponse> response){
        if(!response.isSuccessful()){
            Log.d("ResponseCheck","Server error");
            getViewState().hideProgressBar();
            getViewState().showErrorToast("Server error");
            return;
        }
        if(response.body()==null){
            Log.d("ResponseCheck","Body is null");
            getViewState().hideProgressBar();
            getViewState().showErrorToast("Body is null");
            return;
        } else {
            DefaultResponse body = response.body();
            Float value = body.getValute().getUsd().value;
            getViewState().hideProgressBar();
            getViewState().navigateToWebView(value);
        }
    }
}
