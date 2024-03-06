package br.com.kualit.kualitmarvel.domain.request;

import lombok.Builder;

@Builder
public record ClientRequestParams(String name, String ts, String apikey, String hash){}