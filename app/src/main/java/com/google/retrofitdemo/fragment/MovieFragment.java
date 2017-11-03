package com.google.retrofitdemo.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.retrofitdemo.MyApplication;
import com.google.retrofitdemo.R;
import com.google.retrofitdemo.module.net.bean.MovieEntity;
import com.google.retrofitdemo.presenter.activity.MovieService;
import com.google.retrofitdemo.view.BaseFragment;
import com.google.retrofitdemo.view.IView;
import com.google.retrofitdemo.view.adpter.MainActivityAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/2.
 */

public class MovieFragment extends BaseFragment implements IView {


    @Bind(R.id.movie_tb)
    Toolbar movie_tb;
    @Bind(R.id.movie_recyclerview)
    RecyclerView movieRecyclerview;

    @Bind(R.id.movie_swiprl)
    SwipeRefreshLayout movieSwiprl;

    private MovieService movieService;

    private MainActivityAdapter adapter;

    @Override
    public View getLayoutId() {
        View movieView = View.inflate(MyApplication.getContext(), R.layout.fragment_movie, null);
        return movieView;
    }

    @Override
    protected void initView() {
        adapter = new MainActivityAdapter();
        movieService = new MovieService(this,adapter);
        movieRecyclerview.setLayoutManager(new LinearLayoutManager(MyApplication.getContext(),LinearLayoutManager.VERTICAL,false));
        if (adapter!=null){
            movieRecyclerview.setAdapter(adapter);
        }else{
            adapter = new MainActivityAdapter();
            movieRecyclerview.setAdapter(adapter);
        }
    }

    @Override
    protected void initData() {
        movieService.getData(1, 22);
    }

    @Override
    public void success(Object o) {
        MovieEntity movieEntity = (MovieEntity) o;
        movie_tb.setTitle(movieEntity.getTitle());
    }

    @Override
    public void failed(String msg) {
        Toast.makeText(mContext,"服务器忙，请稍后重试！",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
