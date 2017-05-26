package com.renjue.yuzhilai.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.renjue.yuzhilai.bean.StudyBannerBean;
import com.renjue.yuzhilai.bean.StudyCourseBean;
import com.renjue.yuzhilai.bean.StudyListTryBean;
import com.renjue.yuzhilai.mvpinterface.BannerInterface;
import com.renjue.yuzhilai.mvpinterface.ListCourseInterface;
import com.renjue.yuzhilai.mvpinterface.ListTopicInterface;
import com.renjue.yuzhilai.mvpinterface.ListTryInterface;
import com.renjue.yuzhilai.retrofitInterface.ApiListBanner;
import com.renjue.yuzhilai.retrofitInterface.ApiListCourse;
import com.renjue.yuzhilai.retrofitInterface.ApiListTry;
import com.renjue.yuzhilai.utils.APIUtils;
import com.renjue.yuzhilai.utils.AttrUtils;
import com.renjue.yuzhilai.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 11:19
 */
public class StudyModel implements IStudyModel{

    @Override
    public void getServerBanner(Context context, final BannerInterface bannerInterface) {
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        String app_id=config.getString("app_id",null);
        String private_key=config.getString("private_key",null);
        String dev_id= AttrUtils.getInstance(context).getDev_id();
        String ver_code=AttrUtils.getInstance(context).getVer_code()+"";
        String tick=AttrUtils.getInstance(context).getTick();
        String sign=AttrUtils.getInstance(context).stringToMD5(private_key+app_id+dev_id+ver_code+tick);
        RetrofitUtils.getInstance()
                .getClientApi(APIUtils.getHost(context), ApiListBanner.class)
                .getFirstData(app_id,dev_id,ver_code,tick,sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<StudyBannerBean>() {
                    @Override
                    public void onNext(StudyBannerBean studyBannerBean) {
                        bannerInterface.getBannerData(studyBannerBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getServerListTry(Context context, final ListTryInterface listTryInterface) {
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        String app_id=config.getString("app_id",null);
        String private_key=config.getString("private_key",null);
        String dev_id= AttrUtils.getInstance(context).getDev_id();
        String ver_code=AttrUtils.getInstance(context).getVer_code()+"";
        String tick=AttrUtils.getInstance(context).getTick();
        String page_size=10+"";
        String page_index=0+"";
        String sign=AttrUtils.getInstance(context).stringToMD5(private_key+app_id+dev_id+ver_code+tick+page_size+page_index);
        RetrofitUtils.getInstance()
                .getClientApi(APIUtils.getHost(context), ApiListTry.class)
                .getFirstData(app_id,dev_id,ver_code,tick,page_size,page_index,sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<StudyListTryBean>() {
                    @Override
                    public void onNext(StudyListTryBean studyListTryBean) {
                        listTryInterface.getListTryData(studyListTryBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getServerListCourse(Context context, final ListCourseInterface listCourseInterface) {
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        String app_id=config.getString("app_id",null);
        String private_key=config.getString("private_key",null);
        String dev_id= AttrUtils.getInstance(context).getDev_id();
        String ver_code=AttrUtils.getInstance(context).getVer_code()+"";
        String tick=AttrUtils.getInstance(context).getTick();
        String page_size=10+"";
        String page_index=0+"";
        String sign=AttrUtils.getInstance(context).stringToMD5(private_key+app_id+dev_id+ver_code+tick+page_size+page_index);
        RetrofitUtils.getInstance()
                .getClientApi(APIUtils.getHost(context), ApiListCourse.class)
                .getFirstData(app_id,dev_id,ver_code,tick,page_size,page_index,sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<StudyCourseBean>() {
                    @Override
                    public void onNext(StudyCourseBean studyCourseBean) {
                        listCourseInterface.getListCourseData(studyCourseBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getServerListTopic(Context context, ListTopicInterface listTopicInterface) {

    }
}
