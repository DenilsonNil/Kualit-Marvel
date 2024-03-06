
package br.com.kualit.kualitmarvel.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@Builder

public record MarvelCharacterDataResponse (

    @JsonProperty("code")
    Integer code,

    @JsonProperty("status")
    String status,

    @JsonProperty("copyright")
    String copyright,

    @JsonProperty("attributionText")
    String attributionText,

    @JsonProperty("attributionHTML")
    String attributionHTML,

    @JsonProperty("etag")
    String etag,

    @JsonProperty("data")
    Data data
){}
