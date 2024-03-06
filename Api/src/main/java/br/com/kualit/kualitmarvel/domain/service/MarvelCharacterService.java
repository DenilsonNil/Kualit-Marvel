package br.com.kualit.kualitmarvel.domain.service;

import br.com.kualit.kualitmarvel.client.MarvelAuthService;
import br.com.kualit.kualitmarvel.client.MarvelClientFeignInterface;
import br.com.kualit.kualitmarvel.domain.response.MarvelCharacterDataResponse;
import br.com.kualit.kualitmarvel.domain.response.Thumbnail;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;

import static br.com.kualit.kualitmarvel.utils.StringUtils.concat;

@Service
@AllArgsConstructor
public class MarvelCharacterService {
    public static final String FILE_EXTESION_SEPARATOR = ".";
    private final MarvelAuthService clientAuthService;
    private final MarvelClientFeignInterface clientFeignInterface;
    public byte[] getCharacterPicture(String characterName) {
        return convertImageToByteArray(prepareClientResponse(characterName));
    }
    private Thumbnail prepareClientResponse(String characterName) {
        return callClient(characterName)
                .data()
                .results()
                .stream()
                .findFirst().orElseThrow(NoSuchElementException::new).thumbnail();
    }
    private MarvelCharacterDataResponse callClient(String characterName) {
        return clientFeignInterface.getCharacterData(clientAuthService.getClientMandatoryParams(characterName));
    }
    private byte[] convertImageToByteArray(Thumbnail clientResponse) {
        val imageURI = concat(clientResponse.path(), FILE_EXTESION_SEPARATOR, clientResponse.extension());
        return new RestTemplate().getForObject(imageURI, byte[].class);
    }
}
