package com.mavis.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * MavisUtils
 *
 * @author Mavis郭逸轩
 * @since 2024/5/8 15:39
 */
@Component
public class MavisUtils {

    /**
     * 获取随机UUID
     * @return
     */
    public String randomUUID(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");
        return uuid;
    }

    /**
     * 生成随机文件名称
     * @return
     */
    public String randomFileName(){
        String nowTime = MyDate.getNowTime();
        String uuid = randomUUID();
        uuid = uuid.substring(7, 12);
        String fileName = nowTime + uuid;
        fileName = fileName.replace(" ","");
        fileName = fileName.replace("-","");
        fileName = fileName.replace(":","");
        return fileName;
    }
}
