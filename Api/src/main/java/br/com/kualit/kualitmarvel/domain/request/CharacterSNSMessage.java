package br.com.kualit.kualitmarvel.domain.request;

import java.io.Serializable;

public record CharacterSNSMessage(String imageUri, String characterName) implements Serializable {
}
