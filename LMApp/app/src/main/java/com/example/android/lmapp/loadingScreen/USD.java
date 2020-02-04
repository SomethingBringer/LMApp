package com.example.android.lmapp.loadingScreen;

import com.google.gson.annotations.SerializedName;

public class USD {
    @SerializedName("ID")
    String id;
    @SerializedName("NumCode")
    String  numCode;
    @SerializedName("CharCode")
    String charcode;
    @SerializedName("Nominal")
    Integer nominal;
    @SerializedName("Name")
    String name;
    @SerializedName("Value")
    Float value;
    @SerializedName("Previous")
    Float previous;

    public String getId() {
        return id;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharcode() {
        return charcode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public Float getValue() {
        return value;
    }

    public Float getPrevious() {
        return previous;
    }

}
