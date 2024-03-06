package br.com.kualit.kualitmarvel.domain.service;

import io.awspring.cloud.sns.core.SnsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SnsService {

    private final SnsTemplate snsTemplate;
    @Value("${sns.topicArn}")
    private String topicArn;

    SnsService(SnsTemplate snsTemplate) {
        this.snsTemplate = snsTemplate;
    }
    public void notify(String payload, String subject){
        snsTemplate.sendNotification(topicArn, payload, subject);
    }
}
