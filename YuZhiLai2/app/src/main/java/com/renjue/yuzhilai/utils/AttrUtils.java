package com.renjue.yuzhilai.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/25 20:43
 */
public class AttrUtils {
    private static AttrUtils attrUtils=null;
    private Context context;

    private AttrUtils(Context context) {
        this.context = context;
    }
    public static AttrUtils getInstance(Context context){
        if (attrUtils==null){
            synchronized (AttrUtils.class){
                if (attrUtils==null){
                    attrUtils=new AttrUtils(context);
                }
            }
        }
        return attrUtils;
    }
    public String getDev_id(){
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String DEVICE_ID = tm.getDeviceId();
        return DEVICE_ID;
    }
    public int getVer_code(){
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            int versionCode = pi.versionCode;
            return versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String getTick(){
        long time=System.currentTimeMillis()/1000;//获取系统时间的10位的时间戳
        String  str=String.valueOf(time);
        return str;
    }
    public String stringToMD5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        String sign_ = hex.toString();
        String sign=sign_.toUpperCase();
        return sign;
    }
}
