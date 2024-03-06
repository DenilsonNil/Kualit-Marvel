
package br.com.kualit.s3worker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ContentType(

        @JsonProperty("Type")
        String type,

        @JsonProperty("Value")
        String value
) {}
