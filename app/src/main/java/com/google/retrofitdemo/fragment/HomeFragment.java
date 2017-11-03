package com.google.retrofitdemo.view.fragment;

import android.app.Activity;
import android.view.View;
import com.google.retrofitdemo.MyApplication;
import com.google.retrofitdemo.R;
import com.google.retrofitdemo.view.BaseFragment;

/**
 * Created by Administrator on 2017/11/2.
 */

public class HomeFragment extends BaseFragment {

    @Override
    public View getLayoutId() {
        View view = View.inflate(MyApplication.getContext(), R.layout.fragment_home, null);
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
