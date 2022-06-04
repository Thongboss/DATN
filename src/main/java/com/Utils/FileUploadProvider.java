package com.Utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class FileUploadProvider {

    private final String bucket = "web-datn2022";
    private final String bucketEndpoint = "https://web-datn2022.s3.ap-southeast-1.amazonaws.com/";
    private final AmazonS3 s3Client;
    private final String accessKey = "AKIAZ22L6D272AAGPMFQ";
    private final String accessSecret = "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";
    private final String region = "ap-southeast-1";
    private final Logger log = LoggerFactory.getLogger(FileUploadProvider.class);

    public FileUploadProvider() {
        this.s3Client = amazonS3ClientBuilder().build();
    }

    public String uploadFile(String folder, MultipartFile file) throws IOException {
        StringBuilder checkFileName = new StringBuilder(file.getOriginalFilename());
        if (isFileExist(file.toString())) {
            int i = 1;
            while (true) {
                checkFileName.setLength(0);
                checkFileName.append(i++).append(file.getOriginalFilename());
                if (!isFileExist(file.toString()))
                    break;
            }
        }
        String filePath = folder + checkFileName.toString();
        s3Client.putObject(this.bucket, filePath, file.getInputStream(), null);
        return bucketEndpoint + filePath;
    }

    public boolean isFileExist(String key) {
        try {
            s3Client.getObject(bucket, key);
            return true;
        } catch (Exception e) {
            log.info("File not found: " + key);
            return false;
        }
    }
    public void deleteFile(String key){
        System.out.println("Delete File: "+ key);
        this.s3Client.deleteObject(this.bucket,key.replace(this.bucketEndpoint, ""));
    }

    public AmazonS3ClientBuilder amazonS3ClientBuilder() {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(credentialsProvider())
                .withRegion(this.region);
    }

    private AWSCredentialsProvider credentialsProvider() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(this.accessKey, this.accessSecret);
        return new AWSStaticCredentialsProvider(awsCredentials);
    }
}
