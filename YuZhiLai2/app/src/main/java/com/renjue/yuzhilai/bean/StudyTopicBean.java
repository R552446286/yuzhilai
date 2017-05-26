package com.renjue.yuzhilai.bean;

import java.util.List;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 21:04
 */
public class StudyTopicBean {
    public int ret;
    public Data data;

    @Override
    public String toString() {
        return "StudyTopicBean{" +
                "ret=" + ret +
                ", data=" + data +
                '}';
    }
    public class Data{
        public List<Topic> topic;
        public int total;
        public int page_size;
        public int page_index;

        @Override
        public String toString() {
            return "Data{" +
                    "topic=" + topic +
                    ", total=" + total +
                    ", page_size=" + page_size +
                    ", page_index=" + page_index +
                    '}';
        }
        public class Topic{
            public String object_id;
            public String title2;
            public String speaker;
            public String title;
            public String image;
            public int type;
            public int length;

            @Override
            public String toString() {
                return "Topic{" +
                        "object_id='" + object_id + '\'' +
                        ", title2='" + title2 + '\'' +
                        ", speaker='" + speaker + '\'' +
                        ", title='" + title + '\'' +
                        ", image='" + image + '\'' +
                        ", type=" + type +
                        ", length=" + length +
                        '}';
            }
        }
    }
}
