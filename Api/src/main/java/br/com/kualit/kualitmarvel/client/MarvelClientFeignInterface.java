package br.com.kualit.kualitmarvel.client;

import br.com.kualit.kualitmarvel.domain.request.ClientRequestParams;
import br.com.kualit.kualitmarvel.domain.response.MarvelCharacterDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(name = "marvel", url = "${spring.cloud.openfeign.client.config.feignName.url}")
public interface MarvelClientFeignInterface {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/public/characters")
    MarvelCharacterDataResponse getCharacterData(@SpringQueryMap ClientRequestParams clientRequestParams);
}
