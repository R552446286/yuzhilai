package com.renjue.yuzhilai.bean;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 8:31
 */
public class FirstHandBean {
    public int ret;
    public Data data;

    @Override
    public String toString() {
        return "FirstHandBean{" +
                "ret=" + ret +
                ", data=" + data +
                '}';
    }
    public class Data{
        public String app_id;
        public String private_key;

        @Override
        public String toString() {
            return "Data{" +
                    "app_id='" + app_id + '\'' +
                    ", private_key='" + private_key + '\'' +
                    '}';
        }
    }
}
