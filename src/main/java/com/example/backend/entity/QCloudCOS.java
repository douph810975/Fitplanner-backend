package com.example.backend.entity;

import com.example.backend.config.Config;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class QCloudCOS {
    @Autowired
    private Config config;
    private static final Logger log = LoggerFactory.getLogger(QCloudCOS.class);
//    public String sendObject(MultipartFile file) throws Exception {
//        COSCredentials cred=new BasicCOSCredentials(config.getSecretId(),config.getSecretKey());
//        ClientConfig clientConfig=new ClientConfig(new Region(config.getRegion()));
//        COSClient cosClient=new COSClient(cred,clientConfig);
//        String bucketName=config.getBucketName();
//
//        String uploadFileName=file.getOriginalFilename();
//        String key= UUID.randomUUID().toString()+uploadFileName.substring(uploadFileName.lastIndexOf("."));
//        File localFile= File.createTempFile("temp",null);
//        file.transferTo(localFile);
//        PutObjectRequest putObjectRequest=new PutObjectRequest(bucketName,key,localFile);
//        PutObjectResult putObjectResult=cosClient.putObject(putObjectRequest);
//        cosClient.shutdown();
//        return config.getUrl() + "/" + putObjectRequest.getKey();

//        File localFile = null;
//        try {
//            localFile = File.createTempFile("temp", null);
//            file.transferTo(localFile);
//            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
//            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
//            return config.getUrl() + "/" + putObjectRequest.getKey();
//        } finally {
//            if (localFile != null && localFile.exists()) {
//                localFile.delete();  // 删除临时文件
//            }
//            cosClient.shutdown();  // 确保 COSClient 被正确关闭
//        }
    public String sendObject(MultipartFile file) throws Exception {
        COSCredentials cred = new BasicCOSCredentials(config.getSecretId(), config.getSecretKey());
        ClientConfig clientConfig = new ClientConfig(new Region(config.getRegion()));
        COSClient cosClient = new COSClient(cred, clientConfig);
        String bucketName = config.getBucketName();

        String uploadFileName = file.getOriginalFilename();
        String fileExtension = "";
        int dotIndex = uploadFileName.lastIndexOf(".");
        if (dotIndex > 0) {
            fileExtension = uploadFileName.substring(dotIndex);
        }
        String key = UUID.randomUUID().toString() + fileExtension;

        File localFile = null;
        try {
            // 创建临时文件并上传
            localFile = File.createTempFile("temp", null);
            file.transferTo(localFile);

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

            // 上传成功后返回 URL
            return config.getUrl() + "/" + putObjectRequest.getKey();

        } catch (CosServiceException e) {
            log.error("COS 服务端错误: {}", e.getErrorMessage(), e);
            throw new Exception("COS 服务端错误", e);

        } catch (CosClientException e) {
            log.error("COS 客户端错误: {}", e.getMessage(), e);
            throw new Exception("COS 客户端错误", e);

        } catch (IOException e) {
            log.error("文件处理错误: {}", e.getMessage(), e);
            throw new Exception("文件处理错误", e);

        } finally {
            // 确保文件上传后删除临时文件
            if (localFile != null && localFile.exists()) {
                localFile.delete();
            }
            // 确保 COSClient 被正确关闭
            cosClient.shutdown();
        }
    }





}
