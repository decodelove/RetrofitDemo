package com.google.retrofitdemo.presenter;

import com.google.retrofitdemo.net.bean.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/10/30.
 */

public interface ResposeInfoAPI {
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
}
