package com.Utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class FileUploadProvider {

    private final String bucket;
    private final String bucketEndpoint;
    private final AmazonS3 s3Client;
    private final String accessKey;
    private final String accessSecret;
    private final String region;
    private final Logger log = LoggerFactory.getLogger(FileUploadProvider.class);

    private final Dotenv environment;

    public FileUploadProvider(Dotenv environment) {
        this.environment = environment;
        this.bucket = environment.get("bucket_name");
        this.bucketEndpoint = environment.get("bucket_endpoint");
        this.accessKey = environment.get("access_key");
        this.accessSecret = environment.get("secret_key");
        this.region = environment.get("region");
        this.s3Client = amazonS3ClientBuilder().build();

        System.out.println(this.s3Client == null);
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

    public void deleteFile(String key) {
        System.out.println("Delete File: " + key);
        if (key != null)
            this.s3Client.deleteObject(this.bucket, key.replace(this.bucketEndpoint, ""));
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
