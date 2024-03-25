package com.adilsonfuxe.payment.adapters.http.controllers.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class SignupHttpRequest {
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String phone;
  private final String password;
}
