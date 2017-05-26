package com.renjue.yuzhilai.bean;

import java.util.List;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 20:31
 */
public class StudyCourseBean {
    public int ret;
    public Data data;

    @Override
    public String toString() {
        return "StudyCourseBean{" +
                "ret=" + ret +
                ", data=" + data +
                '}';
    }
    public class Data{
        public List<Course> course;
        public int total;
        public int page_size;
        public int page_index;

        @Override
        public String toString() {
            return "Data{" +
                    "tryX=" + course +
                    ", total=" + total +
                    ", page_size=" + page_size +
                    ", page_index=" + page_index +
                    '}';
        }

        public class Course{
            public String object_id;
            public String title2;
            public String speaker;
            public String title;
            public String image;
            public int type;
            public int length;
            public int price;
            public int volume;

            @Override
            public String toString() {
                return "Course{" +
                        "object_id='" + object_id + '\'' +
                        ", title2='" + title2 + '\'' +
                        ", speaker='" + speaker + '\'' +
                        ", title='" + title + '\'' +
                        ", image='" + image + '\'' +
                        ", type=" + type +
                        ", length=" + length +
                        ", price=" + price +
                        ", volume=" + volume +
                        '}';
            }
        }
    }
}
