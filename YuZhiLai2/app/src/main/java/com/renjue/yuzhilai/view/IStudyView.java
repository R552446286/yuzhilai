package com.renjue.yuzhilai.view;

import com.renjue.yuzhilai.bean.StudyBannerBean;
import com.renjue.yuzhilai.bean.StudyCourseBean;
import com.renjue.yuzhilai.bean.StudyListTryBean;
import com.renjue.yuzhilai.bean.StudyTopicBean;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 11:05
 */
public interface IStudyView {
    void getBannerData(StudyBannerBean studyBannerBean);
    void getTryData(StudyListTryBean studyListTryBean);
    void getCourseData(StudyCourseBean studyCourseBean);
    void getTopicData(StudyTopicBean studyTopicBean);
}
