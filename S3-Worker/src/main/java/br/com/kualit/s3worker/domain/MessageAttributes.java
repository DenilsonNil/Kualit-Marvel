
package br.com.kualit.s3worker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record MessageAttributes(

        @JsonProperty("id")
        ContentType id,

        @JsonProperty("contentType")
        ContentType contentType,

        @JsonProperty("timestamp")
        ContentType timestamp
) {}
