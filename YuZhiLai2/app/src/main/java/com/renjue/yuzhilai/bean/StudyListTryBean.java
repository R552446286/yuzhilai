package com.renjue.yuzhilai.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 16:34
 */
public class StudyListTryBean {
    public int ret;
    public Data data;

    @Override
    public String toString() {
        return "StudyListTryBean{" +
                "ret=" + ret +
                ", data=" + data +
                '}';
    }
    public class Data{
        @SerializedName("try")
        public List<Try> tryX;
        public int total;
        public int page_size;
        public int page_index;

        @Override
        public String toString() {
            return "Data{" +
                    "tryX=" + tryX +
                    ", total=" + total +
                    ", page_size=" + page_size +
                    ", page_index=" + page_index +
                    '}';
        }

        public class Try{
            public String object_id;
            public String title2;
            public String speaker;
            public String title;
            public int try_time;
            public String image;
            public int type;
            public int length;

            @Override
            public String toString() {
                return "Try{" +
                        "object_id='" + object_id + '\'' +
                        ", title2='" + title2 + '\'' +
                        ", speaker='" + speaker + '\'' +
                        ", title='" + title + '\'' +
                        ", try_time=" + try_time +
                        ", image='" + image + '\'' +
                        ", type=" + type +
                        ", length=" + length +
                        '}';
            }
        }
    }
}
