
package br.com.kualit.kualitmarvel.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record Comics(
        @JsonProperty("available")
        Integer available,

        @JsonProperty("collectionURI")
        String collectionURI,

        @JsonProperty("items")
        List<Item> items,

        @JsonProperty("returned")
        Integer returned
){}
