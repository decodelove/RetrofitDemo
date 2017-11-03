package com.google.retrofitdemo.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.retrofitdemo.MyApplication;
import com.google.retrofitdemo.R;
import com.google.retrofitdemo.view.BaseFragment;

/**
 * Created by Administrator on 2017/11/2.
 */

public class DoubanFragment extends BaseFragment {

    @Override
    public View getLayoutId() {
        View view = View.inflate(MyApplication.getContext(), R.layout.fragment_douban, null);
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
