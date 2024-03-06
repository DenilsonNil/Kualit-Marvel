package br.com.kualit.s3worker.service;

import br.com.kualit.s3worker.domain.SQSMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SQSListener {

    private final ObjectMapper mapper;

    public SQSListener(ObjectMapper objectMapper) {
        this.mapper = objectMapper;
    }

    @SqsListener("${sqs.queue-name}")
    public void read(String message) throws JsonProcessingException {
        val sqsMessage = mapper.readValue(message, SQSMessage.class);

        log.info("image URI: {} ", sqsMessage.message());
    }
}
