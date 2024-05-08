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
        uuid.replace("-","");
        return uuid;
    }
}
