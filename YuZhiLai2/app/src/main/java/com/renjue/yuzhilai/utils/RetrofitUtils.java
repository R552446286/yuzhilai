package com.renjue.yuzhilai.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 8:10
 */
public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils=null;

    private RetrofitUtils() {
    }
    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public Retrofit getRetrofit(String baseUrl){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public <T>T getClientApi(String baseUrl,Class<T> cls){
        return getRetrofit(baseUrl).create(cls);
    }
}
