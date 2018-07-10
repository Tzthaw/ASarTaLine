package com.example.ptut.asartaline;

import android.app.Application;

import com.example.ptut.asartaline.models.UserLoginModel;
import com.example.ptut.asartaline.models.WardeeModel;

public class ASarTaLineApp extends Application {

    public static final String LOG_TAG = "SFCNewsApp";

    @Override
    public void onCreate() {
        super.onCreate();
        UserLoginModel.initNewsModel(getApplicationContext());
        WardeeModel.initNewsModel(getApplicationContext());
    }
}