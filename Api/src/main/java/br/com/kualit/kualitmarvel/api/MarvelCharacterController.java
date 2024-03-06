package br.com.kualit.kualitmarvel.api;

import br.com.kualit.kualitmarvel.domain.service.MarvelCharacterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/marvelcharacter")
public class MarvelCharacterController {

    private final MarvelCharacterService service;

    public MarvelCharacterController(MarvelCharacterService service) {
        this.service = service;
    }

    @GetMapping(value = "/{characterName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]>  getCharacterData(@PathVariable("characterName") String characterName) {
        return new ResponseEntity<>(
                service.getCharacterPicture(characterName),
                OK
        );
    }
}
