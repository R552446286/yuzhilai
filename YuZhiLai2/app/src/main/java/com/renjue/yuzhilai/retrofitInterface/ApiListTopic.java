package com.renjue.yuzhilai.retrofitInterface;

import com.renjue.yuzhilai.bean.StudyTopicBean;
import com.renjue.yuzhilai.utils.APIUtils;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 20:39
 */
public interface ApiListTopic {
    @FormUrlEncoded
    @POST(APIUtils.LIST_TOPIC)
    Flowable<StudyTopicBean> getTopicData(@Field("app_id") String app_id, @Field("dev_id") String dev_id,
                                          @Field("ver_code") String ver_code, @Field("tick") String tick,
                                          @Field("page_size") String page_size, @Field("page_index") String page_index,
                                          @Field("sign") String sign);
}
