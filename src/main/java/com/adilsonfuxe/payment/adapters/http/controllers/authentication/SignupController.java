package com.adilsonfuxe.payment.adapters.http.controllers.authentication;

import com.adilsonfuxe.payment.core.domain.porters.in.user.SignIn;
import com.adilsonfuxe.payment.core.domain.porters.in.user.SignUp;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignInParams;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignUpParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class SignupController {

  private final SignUp signUp;
  private final SignIn signIn;

  @Autowired
  public SignupController(SignUp signUp, SignIn signIn) {
    this.signUp = signUp;
    this.signIn = signIn;
  }


  @PostMapping(value = "/sign-up")
  public ResponseEntity<AuthHttpResponse> signIpController(@RequestBody SignupHttpRequest httpRequest) {
    var result = signUp.signUp(new SignUpParams(
        httpRequest.getFirstName(),
        httpRequest.getLastName(),
        httpRequest.getEmail(),
        httpRequest.getPhone(),
        httpRequest.getPassword()
    ));
    var accessToken = signIn.signIn(new SignInParams(httpRequest.getEmail(), httpRequest.getPassword()));
    return ResponseEntity.ok(AuthHttpResponse.builder().accessToken(accessToken).build());
  }
}
