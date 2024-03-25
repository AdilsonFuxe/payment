package com.adilsonfuxe.payment.ports.http.controllers.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class SignupController {

  @PostMapping(value = "/sign-up")
  public ResponseEntity<String> signIp(@RequestBody SignupHttpRequest httpRequest){
    return ResponseEntity.ok("Hello World");
  }
}
