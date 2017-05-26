package com.renjue.yuzhilai.retrofitInterface;

import com.renjue.yuzhilai.bean.GetHostBean;
import com.renjue.yuzhilai.utils.APIUtils;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 9:55
 */
public interface ApiGetHost {
    @FormUrlEncoded
    @POST(APIUtils.GET_HOST)
    Flowable<GetHostBean> getFirstData(@Field("app_id") String app_id, @Field("dev_id") String dev_id,
                                       @Field("ver_code") String ver_code, @Field("tick") String tick,
                                       @Field("sign") String sign);
}
