package com.mutlucankarinca.springbootcamp.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/client-test")
@RequiredArgsConstructor
public class ClientTestController {

    private final MailApi mailApi;

    @GetMapping("/default-mail-address/with-rest-template")
    public String getDefaultMailInfo(){

        String url = "http://localhost:8081/api/v1/mails/default-mail-address";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        String body = responseEntity.getBody();

        return body;
    }


}
