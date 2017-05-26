package com.renjue.yuzhilai.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.renjue.yuzhilai.bean.FirstHandBean;
import com.renjue.yuzhilai.retrofitInterface.ApiFirstHand;
import com.renjue.yuzhilai.utils.APIUtils;
import com.renjue.yuzhilai.utils.AttrUtils;
import com.renjue.yuzhilai.utils.RetrofitUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/25 21:02
 */
public class MyApplication extends Application{

    private SharedPreferences.Editor edit;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences config = getSharedPreferences("firsthand", MODE_PRIVATE);
        edit = config.edit();
        boolean flag=config.getBoolean("flag",false);
        if (flag){
            return;
        }
        getFirstData();
    }


    public void getFirstData() {
        String type=APIUtils.TYPE;
        String dev_id=AttrUtils.getInstance(getApplicationContext()).getDev_id();
        String ver_code=AttrUtils.getInstance(getApplicationContext()).getVer_code()+"";
        String tick=AttrUtils.getInstance(getApplicationContext()).getTick();
        String sign=AttrUtils.getInstance(getApplicationContext()).stringToMD5(APIUtils.PUBLIC_KEY+type+dev_id+ver_code+tick);
        Flowable<FirstHandBean> firstData = RetrofitUtils.getInstance()
                .getClientApi(APIUtils.BASE_URL, ApiFirstHand.class)
                .getFirstData(type, dev_id, ver_code, tick, sign);
        firstData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FirstHandBean>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(FirstHandBean firstHandBean) {
                        Log.e("XXXXXX",firstHandBean.toString());
                        edit.putString("app_id",firstHandBean.data.app_id);
                        edit.putString("private_key",firstHandBean.data.private_key);
                        edit.putBoolean("flag",true);
                        edit.commit();
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
