package br.com.kualit.kualitmarvel.domain.service;

import br.com.kualit.kualitmarvel.domain.request.CharacterSNSMessage;
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
    public void notify(CharacterSNSMessage payload){
        snsTemplate.sendNotification(topicArn, payload, payload.characterName());
    }
}
