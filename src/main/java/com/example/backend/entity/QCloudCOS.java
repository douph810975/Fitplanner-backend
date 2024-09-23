package com.example.backend.entity;

import com.example.backend.config.Config;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class QCloudCOS {
    @Autowired
    private Config config;

    public String sendObject(MultipartFile file) throws Exception {
        COSCredentials cred=new BasicCOSCredentials(config.getSecretId(),config.getSecretKey());
        ClientConfig clientConfig=new ClientConfig(new Region(config.getRegion()));
        COSClient cosClient=new COSClient(cred,clientConfig);
        String bucketName=config.getBucketName();

        String uploadFileName=file.getOriginalFilename();
        String key= UUID.randomUUID().toString()+uploadFileName.substring(uploadFileName.lastIndexOf("."));
        File localFile= File.createTempFile("temp",null);
        file.transferTo(localFile);
        PutObjectRequest putObjectRequest=new PutObjectRequest(bucketName,key,localFile);
        PutObjectResult putObjectResult=cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        return config.getUrl() + "/" + putObjectRequest.getKey();
    }


}
