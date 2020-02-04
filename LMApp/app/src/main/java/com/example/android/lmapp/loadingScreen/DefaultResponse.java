package com.example.android.lmapp.loadingScreen;

import com.google.gson.annotations.SerializedName;



public class DefaultResponse {
    @SerializedName("Valute")
    private Valute valute;

    public Valute getValute() {
        return valute;
    }
}
