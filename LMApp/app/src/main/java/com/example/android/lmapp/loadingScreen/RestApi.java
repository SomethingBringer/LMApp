package com.example.android.lmapp.loadingScreen;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RestApi {
    private RestApi(){}
    private final HttpLoggingInterceptor networkLogInterceptor = new HttpLoggingInterceptor();
    private final OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(networkLogInterceptor)
            .connectTimeout((long) TIMEOUT_IN_SECONDS,TimeUnit.SECONDS)
            .writeTimeout((long) TIMEOUT_IN_SECONDS,TimeUnit.SECONDS)
            .readTimeout((long) TIMEOUT_IN_SECONDS,TimeUnit.SECONDS)
            .build();
    private final Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build();
    DataEndpoint dataEndpoint = retrofit.create(DataEndpoint.class);
    private static final String url ="https://www.cbr-xml-daily.ru/";
    private static final int TIMEOUT_IN_SECONDS = 5;
    private static RestApi sRestApi = null;
    static RestApi getInstance(){
        if (sRestApi==null){
            sRestApi = new RestApi();
            return sRestApi;
        }else
            return sRestApi;
    }
}
