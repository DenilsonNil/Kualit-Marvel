package br.com.kualit.s3worker.domain;

import java.io.Serializable;

public record CharacterSNSMessage(String imageUri, String characterName) implements Serializable {
}
