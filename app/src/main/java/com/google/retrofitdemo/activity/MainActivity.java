package com.google.retrofitdemo.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.retrofitdemo.activity.BaseActivity;
import com.google.retrofitdemo.R;
import java.util.ArrayList;
import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/2.
 */

public class HomeActivity extends BaseActivity{
    @Bind(R.id.activity_fragment)
    FrameLayout activity_fragment;
    @Bind(R.id.home_rb1)
    RadioButton homeRb1;
    @Bind(R.id.home_rb2)
    RadioButton homeRb2;
    @Bind(R.id.home_rb3)
    RadioButton homeRb3;
    @Bind(R.id.home_rb4)
    RadioButton homeRb4;
    @Bind(R.id.home_rg)
    RadioGroup home_rg;
    private ArrayList<Fragment> mFragments;


    @Override
    protected void addWindowFeature() {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new GankFragment());
        mFragments.add(new DoubanFragment());
        mFragments.add(new MovieFragment());
    }

    @Override
    public void initListener() {
        homeRb1.setOnClickListener(onClickListener);
        homeRb2.setOnClickListener(onClickListener);
        homeRb3.setOnClickListener(onClickListener);
        homeRb4.setOnClickListener(onClickListener);
        home_rg.check(R.id.home_rb1);
        showFragment(0);
    }

    @Override
    protected void initData() {

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.home_rb1:
                    showFragment(0);
                    break;
                case R.id.home_rb2:
                    showFragment(1);
                    break;
                case R.id.home_rb3:
                    showFragment(2);
                    break;
                case R.id.home_rb4:
                    showFragment(3);
                    break;
            }
        }
    };

    private void showFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            Fragment fragment = mFragments.get(i);
            if (position==i){
                if (fragment.isAdded()){
                    fragmentTransaction.show(fragment);
                }else{
                    fragmentTransaction.replace(R.id.activity_fragment,fragment).commit();
                }
            }
        }
    }
}
