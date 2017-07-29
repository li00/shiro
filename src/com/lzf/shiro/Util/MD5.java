package com.lzf.shiro.Util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by Administrator on 2017/7/25.
 */
public class MD5 {
    public String md5(String code){
        Object md5 = new SimpleHash("MD5",code,null,10);
        return md5.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MD5().md5("2"));
    }
}
