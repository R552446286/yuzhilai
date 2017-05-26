package com.renjue.yuzhilai.model;

import android.content.Context;

import com.renjue.yuzhilai.mvpinterface.BannerInterface;
import com.renjue.yuzhilai.mvpinterface.ListCourseInterface;
import com.renjue.yuzhilai.mvpinterface.ListTopicInterface;
import com.renjue.yuzhilai.mvpinterface.ListTryInterface;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 11:13
 */
public interface IStudyModel {
    void getServerBanner(Context context, BannerInterface bannerInterface);
    void getServerListTry(Context context, ListTryInterface listTryInterface);
    void getServerListCourse(Context context, ListCourseInterface listCourseInterface);
    void getServerListTopic(Context context, ListTopicInterface listTopicInterface);
}
