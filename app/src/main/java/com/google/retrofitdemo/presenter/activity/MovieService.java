package com.google.retrofitdemo.presenter.activity;

import com.google.gson.internal.ObjectConstructor;
import com.google.retrofitdemo.net.bean.MovieEntity;
import com.google.retrofitdemo.presenter.BasePrecenter;
import com.google.retrofitdemo.view.IView;
import com.google.retrofitdemo.view.MainActivity;
import com.google.retrofitdemo.view.adpter.MainActivityAdapter;

import retrofit2.Call;

/**
 * Created by Administrator on 2017/10/30.
 * MovieService 作为MainActivity与View视图的业务处理类
 */

public class MovieService extends BasePrecenter{

    public IView view;
    private final MainActivityAdapter adapter;

    public MovieService(IView view, MainActivityAdapter adapter) {
        this.view = view;
        this.adapter = adapter;
    }

    @Override
    protected void field(String msg) {
        view.failed(msg);
    }

    @Override
    protected void parserData(Object data) {
        MovieEntity movieEntity = (MovieEntity) data;
        view.success(movieEntity);
        adapter.setData(movieEntity);
    }

    public void getData(int start,int count){
        Call<MovieEntity> movie = responsInfoAPI.getTopMovie(start, count);
        movie.enqueue(new CallbackAdapter());
    }
}
