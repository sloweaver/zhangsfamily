package com.sloweaver.springbootinit.utils;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.provider.ProfileCredentialsProvider;
import com.tencentcloudapi.tmt.v20180321.TmtClient;
import com.tencentcloudapi.tmt.v20180321.models.*;

/**
 * @author sloweaver
 * @date 2023/03/25
 */

public class TextTranslate {
    public static String translate(String sourceText,String sourceLanguage,String targetLanguage){
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户 SecretId 和 SecretKey，此处还需注意密钥对的保密
            // 代码泄露可能会导致 SecretId 和 SecretKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议采用更安全的方式来使用密钥，请参见：https://cloud.tencent.com/document/product/1278/85305
            // 密钥可前往官网控制台 https://console.cloud.tencent.com/cam/capi 进行获取
            // 从windows系统中获取变量 C:\Users\Administrator\.tencentcloud
            Credential cred = new ProfileCredentialsProvider().getCredentials();
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(sourceText);
            req.setSource(sourceLanguage);
            req.setTarget(targetLanguage);
            req.setProjectId(0L);
            // 返回的resp是一个TextTranslateResponse的实例，与请求对象对应
            TextTranslateResponse resp = client.TextTranslate(req);


            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return null;
    }


}
