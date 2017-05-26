package com.renjue.yuzhilai.bean;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/26 10:02
 */
public class GetHostBean {
    public int ret;
    public Data data;

    @Override
    public String toString() {
        return "GetHostBean{" +
                "ret=" + ret +
                ", data=" + data +
                '}';
    }
    public class Data{
        public String url_host;

        @Override
        public String toString() {
            return "Data{" +
                    "url_host='" + url_host + '\'' +
                    '}';
        }
    }
}
