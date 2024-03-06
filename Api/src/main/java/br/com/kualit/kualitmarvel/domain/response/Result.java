
package br.com.kualit.kualitmarvel.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;


@Builder
public record Result(
        @JsonProperty("id")
        Integer id,

        @JsonProperty("name")
        String name,

        @JsonProperty("description")
        String description,

        @JsonProperty("modified")
        String modified,

        @JsonProperty("thumbnail")
        Thumbnail thumbnail,

        @JsonProperty("resourceURI")
        String resourceURI,

        @JsonProperty("comics")
        Comics comics,

        @JsonProperty("series")
        Series series,

        @JsonProperty("stories")
        Stories stories,

        @JsonProperty("events")
        Events events,
        @JsonProperty("urls")
        List<Url> urls
) {}
