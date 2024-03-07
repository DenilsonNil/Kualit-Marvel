package br.com.kualit.s3worker.service;

import br.com.kualit.s3worker.domain.CharacterSNSMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Value("${s3.bucket-name}")
    private String bucketName;
    public S3Service(S3Template s3Template) {
        this.s3Template = s3Template;
    }

    public void sendFileToS3(String payload) throws IOException {
        val body = convertStringToObject(payload);

        try(InputStream is = getInputStream(body)) {
            s3Template.upload(bucketName, body.characterName(), is, ObjectMetadata.builder().contentType("image/jpeg").build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getInputStream(CharacterSNSMessage objectBody) throws IOException {
        val url = new URL(objectBody.imageUri());
        return url.openConnection().getInputStream();
    }
    private CharacterSNSMessage convertStringToObject(String payload) throws JsonProcessingException {
        return new ObjectMapper().readValue(payload, CharacterSNSMessage.class);
    }
}
