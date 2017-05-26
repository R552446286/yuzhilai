package com.renjue.yuzhilai.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.renjue.yuzhilai.bean.GetHostBean;
import com.renjue.yuzhilai.retrofitInterface.ApiGetHost;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/25 20:22
 */
public class APIUtils {
    public static final String BASE_URL="https://pretty.f8cam.com:17211";
    public static final String FIRST_HAND="/app/v1/first_hand";
    public static final String GET_HOST="/app/v1/get_host";
    public static final String LIST_BANNER="/app/v1/list_banner";
    public static final String TYPE="ANDROID";
    public static final String PUBLIC_KEY="312045ED9D036BEED16E96F3878E222ED7E58AC9";
    public static final String LIST_TRY="/app/v1/list_try";
    public static final String LIST_COURSE="/app/v1/list_course";
    public static final String LIST_TOPIC="/app/v1/list_topic";

    public static String getHost(Context context){
        SharedPreferences config = context.getSharedPreferences("config", context.MODE_PRIVATE);
        String app_id = config.getString("app_id", "");
        String private_key = config.getString("private_key", "");
        Log.e("SSSSSSS",app_id+";;;;;;"+private_key);
        String dev_id=AttrUtils.getInstance(context).getDev_id();
        String ver_code=AttrUtils.getInstance(context).getVer_code()+"";
        String tick=AttrUtils.getInstance(context).getTick();
        String sign=AttrUtils.getInstance(context).stringToMD5(private_key+app_id+dev_id+ver_code+tick);
        final String[] get_host = null;
        RetrofitUtils.getInstance()
                .getClientApi(APIUtils.BASE_URL, ApiGetHost.class)
                .getFirstData(app_id, dev_id, ver_code, tick, sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<GetHostBean>() {
                    @Override
                    public void onNext(GetHostBean getHostBean) {
                        get_host[0] =getHostBean.data.url_host;
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return get_host[0];
    }
}
