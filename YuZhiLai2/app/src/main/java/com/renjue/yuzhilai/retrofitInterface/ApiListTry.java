package com.renjue.yuzhilai.retrofitInterface;

import com.renjue.yuzhilai.bean.StudyListTryBean;
import com.renjue.yuzhilai.utils.APIUtils;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 13:34
 */
public interface ApiListTry {
    @FormUrlEncoded
    @POST(APIUtils.LIST_TRY)
    Flowable<StudyListTryBean> getFirstData(@Field("app_id") String app_id, @Field("dev_id") String dev_id,
                                            @Field("ver_code") String ver_code, @Field("tick") String tick,
                                            @Field("page_size") String page_size, @Field("page_index") String page_index,
                                            @Field("sign") String sign);
}
