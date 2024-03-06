package br.com.kualit.s3worker.service;

import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Template;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class S3Service {

    private final S3Template s3Template;
    private static final String FILE_EXTENSION = ".jpg";

    @Value("${s3.bucket-name}")
    private String bucketName;

    public S3Service(S3Template s3Template) {
        this.s3Template = s3Template;
    }

    public void sendFileToS3(String fileName, String filePath) throws IOException {
        val url = new URL(filePath);
        val connection = url.openConnection();
        try(InputStream is = connection.getInputStream()) {
            s3Template.upload(bucketName, fileName.concat(FILE_EXTENSION), is, ObjectMetadata.builder().contentType("image/jpeg").build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
