package com.google.retrofitdemo.view.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.retrofitdemo.utils.ActivityManagerUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/3.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addWindowFeature();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initListener();
        initData();
        ActivityManagerUtils.addActivity(this);
    }

    protected abstract void addWindowFeature();

    public abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        ActivityManagerUtils.remove(this);
    }
}
