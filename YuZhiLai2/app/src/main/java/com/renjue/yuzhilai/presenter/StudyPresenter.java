package com.renjue.yuzhilai.presenter;

import android.content.Context;

import com.renjue.yuzhilai.bean.StudyBannerBean;
import com.renjue.yuzhilai.bean.StudyCourseBean;
import com.renjue.yuzhilai.bean.StudyListTryBean;
import com.renjue.yuzhilai.bean.StudyTopicBean;
import com.renjue.yuzhilai.model.IStudyModel;
import com.renjue.yuzhilai.model.StudyModel;
import com.renjue.yuzhilai.mvpinterface.BannerInterface;
import com.renjue.yuzhilai.mvpinterface.ListCourseInterface;
import com.renjue.yuzhilai.mvpinterface.ListTopicInterface;
import com.renjue.yuzhilai.mvpinterface.ListTryInterface;
import com.renjue.yuzhilai.view.IStudyView;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 13:46
 */
public class StudyPresenter {
    private IStudyView iStudyView;
    private IStudyModel iStudyModel;

    public StudyPresenter(IStudyView iStudyView) {
        this.iStudyView = iStudyView;
        iStudyModel=new StudyModel();
    }
    public void loadBannerData(Context context){
        iStudyModel.getServerBanner(context, new BannerInterface() {
            @Override
            public void getBannerData(StudyBannerBean studyBannerBean) {
                iStudyView.getBannerData(studyBannerBean);
            }
        });
    }
    public void loadTryData(Context context){
        iStudyModel.getServerListTry(context, new ListTryInterface() {
            @Override
            public void getListTryData(StudyListTryBean studyListTryBean) {
                iStudyView.getTryData(studyListTryBean);
            }
        });
    }
    public void loadCourseData(Context context){
        iStudyModel.getServerListCourse(context, new ListCourseInterface() {
            @Override
            public void getListCourseData(StudyCourseBean studyCourseBean) {
                iStudyView.getCourseData(studyCourseBean);
            }
        });
    }
    public void loadTopicData(Context context){
        iStudyModel.getServerListTopic(context, new ListTopicInterface() {
            @Override
            public void getListTopicData(StudyTopicBean studyTopicBean) {
                iStudyView.getTopicData(studyTopicBean);
            }
        });
    }
}
