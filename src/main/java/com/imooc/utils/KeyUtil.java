package com.imooc.utils;

import java.util.UUID;

public class KeyUtil {

    /**
     *生成唯一主键
     * 格式：UUID
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();

        return uuid.replace("-","");
    }
}
