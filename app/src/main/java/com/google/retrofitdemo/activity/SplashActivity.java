package com.google.retrofitdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.google.retrofitdemo.R;
import com.google.retrofitdemo.utils.MLog;

/**
 * Created by Administrator on 2017/11/2.
 */

public class SplashActivity extends BaseActivity{

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            startActivity(new Intent(SplashActivity.this,MainActivity.class));
            finish();
        }
    };


    @Override
    protected void addWindowFeature() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        MLog.i(this,"onCreate start");
        new Thread(){
            @Override
            public void run() {
                super.run();
                Message msg = new Message();
                mHandler.sendMessageAtTime(msg,5000);
            }
        }.start();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
    }
}
