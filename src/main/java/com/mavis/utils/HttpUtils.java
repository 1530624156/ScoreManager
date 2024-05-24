package com.mavis.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * HttpUtils
 *
 * @author Mavis郭逸轩
 * @since 2024/5/24 20:14
 */

@Component
public class HttpUtils {

    //发送邮件接口URL
    public String sendEmailURL = "http://mavis01.top:17777/email/sendEmail";

    /**
     * 执行发送邮件请求
     * @param mailReceive
     * @param mailTitle
     * @param mailContent
     * @param isHtml
     * @return
     */
    public Boolean sendEmailApi(String mailReceive, String mailTitle, String mailContent ,boolean isHtml){
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("mailReceive", mailReceive)
                .add("mailTitle", mailTitle)
                .add("mailContent", mailContent)
                .add("isHtml", String.valueOf(isHtml))
                .build();
        Request request = new Request.Builder()
                .url(sendEmailURL)
                .post(formBody)
                .build();

        try {
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()){
                String responseBody = execute.body().string();
                String[] responseBodys = responseBody.split(",");
                String status = responseBodys[0].substring(responseBodys[0].length() - 1);
                if (status.equals("1")){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
