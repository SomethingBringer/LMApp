package com.example.android.lmapp.loadingScreen;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.http.GET;

interface DataEndpoint {
    @NonNull
    @GET("daily_json.js")
    Call<DefaultResponse> search();
}
