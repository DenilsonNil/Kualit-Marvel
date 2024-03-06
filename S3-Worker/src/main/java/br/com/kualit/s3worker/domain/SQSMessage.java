
package br.com.kualit.s3worker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record SQSMessage(

        @JsonProperty("Type")
        String type,

        @JsonProperty("MessageId")
        String messageId,

        @JsonProperty("TopicArn")
        String topicArn,

        @JsonProperty("Message")
        String message,

        @JsonProperty("Timestamp")
        String timestamp,

        @JsonProperty("UnsubscribeURL")
        String unsubscribeURL,

        @JsonProperty("Subject")
        String subject,

        @JsonProperty("MessageAttributes")
        MessageAttributes messageAttributes,

        @JsonProperty("SignatureVersion")
        String signatureVersion,

        @JsonProperty("Signature")
        String signature,

        @JsonProperty("SigningCertURL")
        String signingCertURL
) {
}
