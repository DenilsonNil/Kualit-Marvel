package br.com.kualit.s3worker.service;

import br.com.kualit.s3worker.domain.SQSMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;

@Component
@Slf4j
public class SQSListener {

    private final ObjectMapper mapper;
    private final S3Service s3Service;
    public SQSListener(ObjectMapper objectMapper, S3Service s3Service) {
        this.mapper = objectMapper;
        this.s3Service = s3Service;
    }

    @SqsListener("${sqs.queue-name}")
    public void read(String message) throws IOException {
        val sqsMessage = mapper.readValue(message, SQSMessage.class);
        log.info("image URI: {} ", sqsMessage.message());
        s3Service.sendFileToS3(sqsMessage.subject(), sqsMessage.message());
    }
}
