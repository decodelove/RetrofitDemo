package com.google.retrofitdemo.presenter;

import com.google.retrofitdemo.net.Contants;
import com.google.retrofitdemo.net.bean.MovieEntity;
import com.google.retrofitdemo.utils.MLog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/10/30.
 */

public abstract class BasePrecenter {

    protected static ResposeInfoAPI responsInfoAPI;

    public BasePrecenter() {
        if (responsInfoAPI==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Contants.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            responsInfoAPI = retrofit.create(ResposeInfoAPI.class);

        }
    }

    public class CallbackAdapter implements Callback<MovieEntity>{

        @Override
        public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
            if (response !=null && response.isSuccess()){
                //根据与服务器约定好的请求成功的代码进行判断
                MLog.i(this,"response:"+response);
                parserData(response.body());
//                if ("200".equals(response.code())){
//                }
//                parserData(response);
            }
        }

        @Override
        public void onFailure(Call<MovieEntity> call, Throwable t) {

        }
    }

    /**
     *     错误处理
     */
    protected abstract void field(String msg);

    /**
     * 解析服务器回复数据
     */
    protected abstract void parserData(Object data);

}
