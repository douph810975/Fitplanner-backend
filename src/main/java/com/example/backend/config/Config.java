package com.example.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Value("${qcloud.secretId}")
    private String secretId;
    @Value("${qcloud.secretKey}")
    private String secretKey;
    @Value("${qcloud.region}")
    private String region;
    @Value("${qcloud.bucketName}")
    private String bucketName;
    @Value("${qcloud.url}")
    private String url;

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecretId() {
        return secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getRegion() {
        return region;
    }

    public String getBucketName() {
        return bucketName;
    }

    public String getUrl() {
        return url;
    }
}
