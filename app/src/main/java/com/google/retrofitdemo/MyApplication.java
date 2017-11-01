package com.google.retrofitdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/10/30.
 */

public class MyApplication extends Application {
    private static Context context;
    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
    }
}
