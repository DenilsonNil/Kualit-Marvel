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
    private final SnsService snsService;
    public byte[] getCharacterPicture(String characterName) {
        val clientResponse = prepareClientResponse(characterName);

        val imagePath = clientResponse.path();
        val imageExtension = clientResponse.extension();

        snsService.notify(getImageURI(imagePath, imageExtension), characterName);
        return convertImageToByteArray(imagePath, imageExtension);
    }

    private String getImageURI(String clientResponse, String clientResponse1) {
        return concat(clientResponse, FILE_EXTESION_SEPARATOR, clientResponse1);
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
    private byte[] convertImageToByteArray(String path, String extension) {
        val imageURI = getImageURI(path, extension);
        return new RestTemplate().getForObject(imageURI, byte[].class);
    }
}
