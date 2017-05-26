package com.renjue.yuzhilai.bean;

import java.util.List;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 11:14
 */
public class StudyBannerBean {
    public int ret;
    public Data data;

    @Override
    public String toString() {
        return "StudyBannerBean{" +
                "ret=" + ret +
                ", data=" + data +
                '}';
    }
    public class Data{
        public List<Banners> banner;

        @Override
        public String toString() {
            return "Data{" +
                    "banner=" + banner +
                    '}';
        }
        public class Banners{
            public String image;
            public String click;

            @Override
            public String toString() {
                return "Banners{" +
                        "image='" + image + '\'' +
                        ", click='" + click + '\'' +
                        '}';
            }
        }
    }
}
