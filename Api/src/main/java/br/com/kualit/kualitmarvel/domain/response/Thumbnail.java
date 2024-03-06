
package br.com.kualit.kualitmarvel.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Thumbnail (@JsonProperty("path") String path, @JsonProperty("extension") String extension){}
