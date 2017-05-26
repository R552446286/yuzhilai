package com.renjue.yuzhilai.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.renjue.yuzhilai.R;
import com.renjue.yuzhilai.bean.StudyBannerBean;
import com.renjue.yuzhilai.bean.StudyCourseBean;
import com.renjue.yuzhilai.bean.StudyListTryBean;
import com.renjue.yuzhilai.bean.StudyTopicBean;
import com.renjue.yuzhilai.presenter.StudyPresenter;
import com.renjue.yuzhilai.view.IStudyView;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/25 19:35
 */
public class FragmentStudy extends Fragment implements IStudyView {
    private RecyclerView study_recycler;
    private XBanner mBanner;
    private ImageView imageview_sanjiao;
    private ImageView imageview_jian;
    private TextView try_all;
    private RecyclerView try_recyclerview;
    private ImageView imageview_sanjiao2;
    private ImageView imageview_jian2;
    private RecyclerView course_recyclerview;
    private ImageView iv;
    private ImageView iv2;
    private TextView topic_all;
    private RecyclerView topic_recyclerview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, null);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StudyPresenter studyPresenter = new StudyPresenter(this);
        studyPresenter.loadBannerData(getActivity());
    }

    private void initView(View view) {
        mBanner = (XBanner) view.findViewById(R.id.mBanner);
        imageview_sanjiao = (ImageView) view.findViewById(R.id.imageview_sanjiao);
        imageview_jian = (ImageView) view.findViewById(R.id.imageview_jian);
        try_all = (TextView) view.findViewById(R.id.try_all);
        try_recyclerview = (RecyclerView) view.findViewById(R.id.try_recyclerview);
        imageview_sanjiao2 = (ImageView) view.findViewById(R.id.imageview_sanjiao2);
        imageview_jian2 = (ImageView) view.findViewById(R.id.imageview_jian2);
        course_recyclerview = (RecyclerView) view.findViewById(R.id.course_recyclerview);
        iv = (ImageView) view.findViewById(R.id.iv);
        iv2 = (ImageView) view.findViewById(R.id.iv2);
        topic_all = (TextView) view.findViewById(R.id.topic_all);
        topic_recyclerview = (RecyclerView) view.findViewById(R.id.topic_recyclerview);
    }

    @Override
    public void getBannerData(StudyBannerBean studyBannerBean) {
        final List<StudyBannerBean.Data.Banners> banners = studyBannerBean.data.banner;
        mBanner.setData(banners,null);
        mBanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(banners.get(position).image).into((ImageView) view);
            }
        });
    }

    @Override
    public void getTryData(StudyListTryBean studyListTryBean) {
        List<StudyListTryBean.Data.Try> tryX = studyListTryBean.data.tryX;
    }

    @Override
    public void getCourseData(StudyCourseBean studyCourseBean) {
        List<StudyCourseBean.Data.Course> course = studyCourseBean.data.course;
    }

    @Override
    public void getTopicData(StudyTopicBean studyTopicBean) {
        List<StudyTopicBean.Data.Topic> topic = studyTopicBean.data.topic;
    }
}
