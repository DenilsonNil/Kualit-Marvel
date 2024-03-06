
package br.com.kualit.kualitmarvel.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record Data(

        @JsonProperty("offset")
        Integer offset,

        @JsonProperty("limit")
        Integer limit,

        @JsonProperty("total")
        Integer total,

        @JsonProperty("count")
        Integer count,

        @JsonProperty("results")
        List<Result> results
) {}
