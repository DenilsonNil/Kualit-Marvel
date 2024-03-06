package br.com.kualit.kualitmarvel.client;

import br.com.kualit.kualitmarvel.domain.request.ClientRequestParams;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
@Component
public class MarvelAuthService {
    @Value("${client-marvel-public-key}")
    private String publicKey;

    @Value("${client-marvel-private-key}")
    private String privateKey;

    public ClientRequestParams getClientMandatoryParams(String characterName) {
        long epochSecond = Instant.now().getEpochSecond();

        return ClientRequestParams.builder()
                .name(characterName)
                .ts(Long.toString(epochSecond))
                .apikey(publicKey)
                .hash(md5Hash(epochSecond + privateKey + publicKey))
                .build();
    }

    private String md5Hash(String input) {
        try {
            val md5Instance = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md5Instance.digest(input.getBytes());
            val hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
