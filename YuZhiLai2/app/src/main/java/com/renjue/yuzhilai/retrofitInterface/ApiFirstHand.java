package com.renjue.yuzhilai.retrofitInterface;

import com.renjue.yuzhilai.bean.FirstHandBean;
import com.renjue.yuzhilai.utils.APIUtils;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 8:23
 */
public interface ApiFirstHand {
    @FormUrlEncoded
    @POST(APIUtils.FIRST_HAND)
    Flowable<FirstHandBean> getFirstData(@Field("type") String type,@Field("dev_id") String dev_id,
                                         @Field("ver_code") String ver_code,@Field("tick") String tick,
                                        @Field("sign") String sign);
}
