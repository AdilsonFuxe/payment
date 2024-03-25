package com.adilsonfuxe.payment.adapters.http.controllers.authentication;

import com.adilsonfuxe.payment.core.domain.porters.in.user.SignIn;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignInParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class SignInController {
  private final SignIn signIn;

  @Autowired
  public SignInController(SignIn signIn) {
    this.signIn = signIn;
  }


  @PostMapping(value = "/sign-in")
  public ResponseEntity<AuthHttpResponse> signInController(@RequestBody SignInHttpRequest httpRequest) {
    var accessToken = signIn.signIn(new SignInParams(httpRequest.getEmail(), httpRequest.getPassword()));
    return ResponseEntity.ok(AuthHttpResponse.builder().accessToken(accessToken).build());
  }
}
