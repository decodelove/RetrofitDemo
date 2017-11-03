package com.google.retrofitdemo.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.retrofitdemo.MyApplication;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/2.
 */

public abstract class BaseFragment extends Fragment {

    public Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = MyApplication.getContext();
        View view = getLayoutId();
        ButterKnife.bind(this,view);
        initView();
        initData();
        return view;
    }

    public abstract View getLayoutId();

    protected abstract void initView();

    protected abstract void initData();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
