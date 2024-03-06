
package br.com.kualit.kualitmarvel.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record Item (
    @JsonProperty("resourceURI")
    String resourceURI,

    @JsonProperty("name")
    String name,

    @JsonProperty("type")
    String type

){}
