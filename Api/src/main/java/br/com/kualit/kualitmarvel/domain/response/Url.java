
package br.com.kualit.kualitmarvel.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record Url (
    @JsonProperty("type")
    String type,

    @JsonProperty("url")
    String url
){}
