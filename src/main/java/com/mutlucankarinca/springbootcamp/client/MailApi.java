package com.mutlucankarinca.springbootcamp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mail", url = "http://localhost:8081/api/v1/mails")
public interface MailApi {

    @GetMapping("/default-mail-address")
    String getMailAddress();
}
